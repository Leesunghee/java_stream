package com.himalaya.javastream.designpattern.templatemethod;

public abstract class UserService {

    public abstract boolean validateUser(User user);

    public abstract void writeToDb(User user);

    public void createUser(User user) {
        if (!validateUser(user)) {
            System.out.println("user is not verified");
        } else {
            writeToDb(user);
        }
    }
}
