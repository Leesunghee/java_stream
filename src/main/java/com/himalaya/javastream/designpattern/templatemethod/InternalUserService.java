package com.himalaya.javastream.designpattern.templatemethod;

public class InternalUserService extends UserService {
    @Override
    public boolean validateUser(User user) {
        System.out.println("validate internal user :: " + user.getName());
        return true;
    }

    @Override
    public void writeToDb(User user) {
        System.out.println("write user :: " + user.getName() + " to internal DB");
    }
}
