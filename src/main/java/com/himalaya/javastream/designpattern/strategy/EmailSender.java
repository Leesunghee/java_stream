package com.himalaya.javastream.designpattern.strategy;

public class EmailSender {

    private EmailProvider emailProvider;

    public void setEmailProvider(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    public void sendEmail(User user) {
        String email = emailProvider.getEmail(user);
        System.out.println("Sending " + email);
    }
}
