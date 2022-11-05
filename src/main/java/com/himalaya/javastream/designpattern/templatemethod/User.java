package com.himalaya.javastream.designpattern.templatemethod;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@ToString
@Getter
public class User {
    private Long id;
    private String name;
    private String email;
    private String nickname;
    private LocalDate birthday;

    private List<Long> friends = new ArrayList<>();

    private boolean isVerified;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.birthday = builder.birthday;
        this.isVerified = builder.isVerified;
        this.friends = builder.friends;
    }

    public static Builder builder(Long id, String name) {
        return new Builder(id, name);
    }

    public static class Builder {
        private Long id;
        private String name;
        public String email;
        public String nickname;
        public LocalDate birthday;
        public List<Long> friends = new ArrayList<>();
        public boolean isVerified;


        private Builder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }



        public User build() {
            return new User(this);
        }

    }

}
