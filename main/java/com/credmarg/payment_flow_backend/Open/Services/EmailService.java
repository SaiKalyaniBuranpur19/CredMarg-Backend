package com.credmarg.payment_flow_backend.Open.Services;

import com.credmarg.payment_flow_backend.Open.Model.EmailData;
import com.credmarg.payment_flow_backend.Open.Model.Vendor;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.net.http.common.Log.logError;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    // List to store sent emails for retrieval
    private List<EmailData> sentEmails = new ArrayList<>();

    public void sendEmailsToVendors(List<Vendor> vendors, String messageTemplate) {
        for (Vendor vendor : vendors) {
            String personalizedMessage = messageTemplate
                    .replace("{ name }", vendor.getName())
                    .replace("{ upi }", vendor.getUpi());

            Email from = new Email("buranpursaikalyani19@gmail.com"); // Replace with your verified sender email
            String subject = "Payment Notification";
            Email to = new Email(vendor.getEmail());

            Content plainContent = new Content("text/plain", personalizedMessage);
            Content htmlContent = new Content("text/html", "<p>" + personalizedMessage + "</p>");

            Mail mail = new Mail(from, subject, to, plainContent);
            mail.addContent(htmlContent);

            SendGrid sg = new SendGrid(sendGridApiKey);
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println("Status Code: " + response.getStatusCode());
                System.out.println("Body: " + response.getBody());
                System.out.println("Headers: " + response.getHeaders());

                // Store sent email
                EmailData emailData = new EmailData(vendor.getEmail(), subject, personalizedMessage);
                sentEmails.add(emailData);
            } catch (IOException ex) {
                System.out.println("Error sending email: " + ex.getMessage());
                logError(ex); // Make sure to define or import logError properly
            }
        }
    }

    public List<EmailData> getAllSentEmails() {
        return new ArrayList<>(sentEmails);
    }
}

