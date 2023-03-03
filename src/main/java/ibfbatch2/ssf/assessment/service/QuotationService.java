package ibfbatch2.ssf.assessment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ibfbatch2.ssf.assessment.model.Quotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class QuotationService {

    private static final String restEndpoint = "https://quotation.chuklee.com/api/quotation";

    public Quotation getQuotation(List<String> items) throws IOException {

        String url = restEndpoint + "?items=" + String.join(",", items);

        URL apiUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("error"
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream()), StandardCharsets.UTF_8));


        JsonReader reader = Json.createReader(br);
        JsonObject response = reader.readObject();
        
        String quoteId = response.getString("quoteId");
        JsonObject quotationsJson = response.getJsonObject("quotations");

        Quotation quotation = new Quotation();
        quotation.setQuoteId(quoteId);

        for (String item : items) {
            if (quotationsJson.containsKey(item)) {
                Float unitPrice = Float.parseFloat(quotationsJson.get(item).toString());
                quotation.addQuotation(item, unitPrice);
            }
        }

        conn.disconnect();
        return quotation;
    }
}