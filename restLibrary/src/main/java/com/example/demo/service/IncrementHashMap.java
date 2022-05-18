package com.example.demo.service;

import com.example.demo.dao.entity.Book;

import java.util.Collection;
import java.util.HashMap;

public class IncrementHashMap<T> extends HashMap<Integer, T> {
    private int counter = 1;

    public void add(T value) {
        super.put(counter++, value);
    }
}