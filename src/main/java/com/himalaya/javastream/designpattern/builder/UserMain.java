package com.himalaya.javastream.designpattern.builder;

import java.time.LocalDate;


public class UserMain {

    public static void main(String[] args) {

//        User user = User.builder(1L, "test@email.com")
//                .withBirthDay(LocalDate.now())
//                .withNickname("tester")
//                .build();

        User user = User.builder(1L, "test@email.com")
                .with(builder -> {
                    builder.birthday = LocalDate.now();
                    builder.nickname = "tester";
                })
                .build();

        System.out.println("user = " + user);
    }
}
