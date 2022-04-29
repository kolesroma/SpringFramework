package com.example.demo.service;

import com.example.demo.dao.entity.*;

import java.util.List;

public interface Library {
    List<Book> getByAuthorName(String name);
    List<Book> getByTitleName(String name);
    List<Book> getByKeyWordName(String name);
    Book getById(int id);
    void addBook(String authorName, String titleName, String keyWordLine, String bookId);
    void removeBook(String id);
    void editBook(String authorName, String titleName, String keyWordLine, String bookId);
    List<Book> getAll();
}
