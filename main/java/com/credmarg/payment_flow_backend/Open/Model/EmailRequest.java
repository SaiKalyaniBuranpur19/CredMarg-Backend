package com.credmarg.payment_flow_backend.Open.Model;

import java.util.List;

public class EmailRequest {

    private List<Vendor> vendors;
    private String message;

    // getters and setters
    public List<Vendor> getVendors() {
        return vendors;
    }

    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
