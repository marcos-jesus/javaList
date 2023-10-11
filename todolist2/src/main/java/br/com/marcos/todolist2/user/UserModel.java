package br.com.marcos.todolist2.user;

import lombok.*;

@Data
public class UserModel {
    private String username;
    private String name;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassowrd(String passowrd) {
        this.password = passowrd;
    }

    public String getPassword() {
        return password;
    }
}
