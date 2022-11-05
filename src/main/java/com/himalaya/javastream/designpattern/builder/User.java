package com.himalaya.javastream.designpattern.builder;

import lombok.ToString;

import java.time.LocalDate;
import java.util.function.Consumer;

@ToString
public class User {
    private Long id;
    private String email;
    private String nickname;
    private LocalDate birthday;

    public User(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.nickname = builder.nickname;
        this.birthday = builder.birthday;
    }

    public static Builder builder(Long id, String email) {
        return new Builder(id, email);
    }

    public static class Builder {
        private Long id;
        private String email;
        public String nickname;
        public LocalDate birthday;

        private Builder(Long id, String email) {
            this.id = id;
            this.email = email;
        }

//        public Builder withNickname(String nickname) {
//            this.nickname = nickname;
//            return this;
//        }
//
//        public Builder withBirthDay(LocalDate birthDay) {
//            this.birthday = birthDay;
//            return this;
//        }

        public Builder with(Consumer<Builder> consumer) {
            consumer.accept(this);
            return this;
        }



        public User build() {
            return new User(this);
        }

    }

}
