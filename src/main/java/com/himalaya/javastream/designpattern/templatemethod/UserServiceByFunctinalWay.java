package com.himalaya.javastream.designpattern.templatemethod;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserServiceByFunctinalWay {

    Predicate<User> validateUser;
    Consumer<User> writeToDb;

    public UserServiceByFunctinalWay(Predicate<User> validateUser, Consumer<User> writeToDb) {
        this.validateUser = validateUser;
        this.writeToDb = writeToDb;
    }

    public void createUser(User user) {
        if (!validateUser.test(user)) {
            System.out.println("user is not verified");
        } else {
            writeToDb.accept(user);
        }
    }
}
