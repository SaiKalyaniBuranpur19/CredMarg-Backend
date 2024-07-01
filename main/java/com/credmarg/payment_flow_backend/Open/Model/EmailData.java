package com.credmarg.payment_flow_backend.Open.Model;

public class EmailData {

    private String to;
    private String subject;
    private String message;
    private String email;


    public EmailData() {

    }

    public EmailData(String email, String subject, String message) {
        this.email=email;
        this.subject=subject;
        this.message=message;

    }

    // getters and setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String content) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
