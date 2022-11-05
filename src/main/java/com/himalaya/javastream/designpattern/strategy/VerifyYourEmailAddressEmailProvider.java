package com.himalaya.javastream.designpattern.strategy;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User user) {
        return "verify your email address :: " + user.getEmail();
    }
}
