package com.example.demo.dao;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;

import java.util.Collection;
import java.util.Optional;

public interface BookDao {
    Collection<Book> getAll(Integer page);
    Collection<Book> get(Author author);
    Collection<Book> get(Title title);
    Collection<Book> get(KeyWord keyWord);
    Optional<Book> get(Integer id);

    void add(Book book);

    void update(Integer id, Book book);

    void remove(Integer id);
}
