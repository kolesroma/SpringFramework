package com.example.demo.dao;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> getByAuthor(Author author) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> getByTitle(Title title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> getByKeyWord(KeyWord keyWord) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Book getById(int id) {
        throw new UnsupportedOperationException();
    }
}
