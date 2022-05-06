package com.example.demo.dao;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;

import java.util.List;

public interface BookDao {
    List<Book> getByAuthor(Author author);
    List<Book> getByTitle(Title title);
    List<Book> getByKeyWord(KeyWord keyWord);
    Book getById(int id);
    List<Book> getAll();
}
