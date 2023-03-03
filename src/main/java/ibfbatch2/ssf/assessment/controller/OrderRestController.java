package ibfbatch2.ssf.assessment.controller;

import java.util.List;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;


import ibfbatch2.ssf.assessment.model.Quotation;
import ibfbatch2.ssf.assessment.service.QuotationService;

@RestController
public class OrderRestController {

    @Autowired
    public QuotationService quotationService; 

    @PostMapping("/invoice")
    public Quotation getQuotation(HttpServletRequest request, @RequestBody List<String> items) throws IOException {
        Quotation quotation = quotationService.getQuotation(items);
        return quotation;
    }
}

