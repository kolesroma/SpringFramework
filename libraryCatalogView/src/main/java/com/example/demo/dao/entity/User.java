package com.example.demo.dao.entity;

public class User {
    private final String name;
    private final Role role;

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public static void main(String[] args) {
        User u = new User("arsen", Role.ADMIN);
        System.out.println(u.role.name().equals("ADMIN"));
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public enum Role {
        ADMIN,
        CLIENT;
    }
}
