package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends AbstractEntity {

    private String userName;

    private String password;

    private Role role;

    public User(String id, String userName, String password, Role role) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
