package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class LibraryImpl implements Library {
    final BookDao bookDao;

    public LibraryImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Collection<Book> getAll(Integer page) {
        return bookDao.getAll(page);
    }

    @Override
    public Collection<Book> get(Author author) {
        return bookDao.get(author);
    }

    @Override
    public Collection<Book> get(Title title) {
        return bookDao.get(title);
    }

    @Override
    public Collection<Book> get(KeyWord keyWord) {
        return bookDao.get(keyWord);
    }

    @Override
    public Optional<Book> get(Integer bookId) {
        return bookDao.get(bookId);
    }

    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Override
    public void update(Integer bookId, Book book) {
        bookDao.update(bookId, book);
    }

    @Override
    public void remove(Integer bookId) {
        bookDao.remove(bookId);
    }
}
