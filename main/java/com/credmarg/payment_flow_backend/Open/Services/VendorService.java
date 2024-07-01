package com.credmarg.payment_flow_backend.Open.Services;

import com.credmarg.payment_flow_backend.Open.Model.Employee;
import com.credmarg.payment_flow_backend.Open.Model.Vendor;
import com.credmarg.payment_flow_backend.Open.Repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {
    @Autowired
    private VendorRepository vendorRepository;
    private List<Vendor> vendors = new ArrayList<>();

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }
    public Vendor addVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }
}

