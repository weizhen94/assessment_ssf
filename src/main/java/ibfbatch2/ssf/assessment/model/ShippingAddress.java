package ibfbatch2.ssf.assessment.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ShippingAddress {

    @NotNull(message="Name is required")
    @Size(min=2, message="Name must be at least 2 characters long")
    private String name;

    @NotNull(message="Address is required")
    @Size(min=2, message="Address must be at least 2 characters long")
    private String address;

    public ShippingAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public ShippingAddress() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
