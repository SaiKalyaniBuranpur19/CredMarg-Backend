package com.credmarg.payment_flow_backend.Open.Controllers;

import com.credmarg.payment_flow_backend.Open.Model.EmailData;
import com.credmarg.payment_flow_backend.Open.Model.Vendor;
import com.credmarg.payment_flow_backend.Open.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*")  // Adjust origin as necessary
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Endpoint to send emails to vendors
    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmailsToVendors(@RequestBody List<Vendor> vendors) {
        for (Vendor vendor : vendors) {
            if (vendor.getName() == null || vendor.getEmail() == null || vendor.getUpi() == null) {
                return ResponseEntity.badRequest().body("Missing required fields for vendor: " + vendor);
            }
        }

        String messageTemplate = "Sending payments to vendor { name } at UPI { upi }";
        emailService.sendEmailsToVendors(vendors, messageTemplate);
        return ResponseEntity.ok("Emails sent successfully!");
    }


    // Endpoint to get all sent emails
    @GetMapping("/emails")
    public ResponseEntity<List<EmailData>> getAllSentEmails() {
        List<EmailData> sentEmails = emailService.getAllSentEmails();
        return ResponseEntity.ok(sentEmails);
    }

}
