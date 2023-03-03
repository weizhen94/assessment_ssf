package ibfbatch2.ssf.assessment.model;

import java.io.Serializable;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Cart implements Serializable {

    @Pattern(regexp = "^(apple|bread|chicken)$", message = "We do not stock ${validatedValue}")
	private String item;

    @Min(value=1, message="You must add at least 1 item")
    private String quantity;

    public Cart() {
    }

    public Cart(@Pattern(regexp = "^(apple|bread|chicken)$", message = "We do not stock {validatedValue}") String item,
            @Min(value = 1, message = "You must add at least 1 item") String quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    





    
}
