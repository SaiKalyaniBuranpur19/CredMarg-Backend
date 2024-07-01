package com.credmarg.payment_flow_backend.Open.Controllers;

import com.credmarg.payment_flow_backend.Open.Model.Vendor;
import com.credmarg.payment_flow_backend.Open.Services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class VendorController {
    @Autowired
    private VendorService service =new VendorService();

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors(){
        return service.getAllVendors();
    }
    @PostMapping("/vendors")
    public Vendor addVendor(@RequestBody Vendor vendor){
        return service.addVendor(vendor);
    }
}
