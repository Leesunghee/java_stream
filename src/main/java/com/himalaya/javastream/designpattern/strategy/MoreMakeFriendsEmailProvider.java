package com.himalaya.javastream.designpattern.strategy;

public class MoreMakeFriendsEmailProvider implements EmailProvider{
    @Override
    public String getEmail(User user) {
        return "make more friends :: " + user.getEmail();
    }
}
