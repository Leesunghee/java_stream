package com.himalaya.javastream.designpattern.templatemethod;

public class DefaultUserService extends UserService {
    @Override
    public boolean validateUser(User user) {
        System.out.println("validate user :: " + user.getName());
        return user.getId() != null && user.getEmail() != null;
    }

    @Override
    public void writeToDb(User user) {
        System.out.println("write user :: " + user.getName() + " to DB");
    }
}
