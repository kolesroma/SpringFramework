package com.example.demo.dao.entity;

import java.util.Objects;

public class KeyWord {
    private final String name;

    public KeyWord(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KeyWord)) return false;
        KeyWord keyWord = (KeyWord) o;
        return Objects.equals(getName(), keyWord.getName());
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
