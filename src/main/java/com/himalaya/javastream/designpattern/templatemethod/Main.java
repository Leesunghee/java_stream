package com.himalaya.javastream.designpattern.templatemethod;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User alice = User.builder(1L, "Alice")
                .with(builder -> {
                    builder.email = "Alice@email.com";
                    builder.isVerified = false;
                    builder.friends = Arrays.asList(101L, 102L, 103L, 104L, 105L, 106L, 107L, 108L);
                })
                .build();

        DefaultUserService defaultUserService = new DefaultUserService();
        InternalUserService internalUserService = new InternalUserService();

        defaultUserService.createUser(alice);
        internalUserService.createUser(alice);

        System.out.println("==========================================");

        UserServiceByFunctinalWay userServiceByFunctinalWay = new UserServiceByFunctinalWay(
                user -> {
                    System.out.println("validate user :: " + user.getName());
                    return user.getName() != null && user.getEmail() != null;
                },
                user -> System.out.println("write user :: " + user.getName())
        );
        userServiceByFunctinalWay.createUser(alice);
    }
}
