package com.example.demo.dao.entity;

import java.util.Objects;

public class Title {
    private String name;

    public Title(String name) {
        this.name = name;
    }

    public Title() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Title)) return false;
        Title title = (Title) o;
        return Objects.equals(getName(), title.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
