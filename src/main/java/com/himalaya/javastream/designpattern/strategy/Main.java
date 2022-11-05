package com.himalaya.javastream.designpattern.strategy;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EmailSender emailSender = new EmailSender();

        User user1 = User.builder(1L, "Alice")
                .with(builder -> {
                    builder.email = "Alice@email.com";
                    builder.isVerified = false;
                    builder.friends = Arrays.asList(101L, 102L, 103L, 104L, 105L, 106L, 107L, 108L);
                })
                .build();

        User user2 = User.builder(2L, "Bob")
                .with(builder -> {
                    builder.email = "Bob@email.com";
                    builder.isVerified = true;
                    builder.friends = Arrays.asList(101L, 102L, 103L);
                })
                .build();

        User user3 = User.builder(3L, "Chalie")
                .with(builder -> {
                    builder.email = "Chaile@email.com";
                    builder.isVerified = true;
                    builder.friends = Arrays.asList(101L, 102L, 103L, 104L, 105L, 106L);
                })
                .build();

        List<User> users = Arrays.asList(user1, user2, user3);

        VerifyYourEmailAddressEmailProvider verifyYourEmailAddressEmailProvider = new VerifyYourEmailAddressEmailProvider();
        MoreMakeFriendsEmailProvider moreMakeFriendsEmailProvider = new MoreMakeFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);

        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(moreMakeFriendsEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriends().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(user -> "Sending your friends :: " + user.getEmail());
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriends().size() > 5)
                .forEach(emailSender::sendEmail);

    }
}
