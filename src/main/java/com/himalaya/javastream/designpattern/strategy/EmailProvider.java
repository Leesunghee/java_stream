package com.himalaya.javastream.designpattern.strategy;

@FunctionalInterface
public interface EmailProvider {

    String getEmail(User user);
}
