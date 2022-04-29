package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryImpl implements Library {
    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getByAuthorName(String name) {
        return bookDao.getByAuthor(new Author(name));
    }

    @Override
    public List<Book> getByTitleName(String name) {
        return bookDao.getByTitle(new Title(name));
    }

    @Override
    public List<Book> getByKeyWordName(String name) {
        return bookDao.getByKeyWord(new KeyWord(name));
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public void addBook(String authorName, String titleName, String keyWordLine, String bookId) {
        Book book = new Book(new Author(authorName),
                new Title(titleName),
                Arrays.stream(keyWordLine.split(" ")).map(KeyWord::new).collect(Collectors.toList()),
                Integer.parseInt(bookId));
        bookDao.getAll().add(book);
    }

    @Override
    public void removeBook(String id) {
        Book book = new Book(null, null, null, Integer.parseInt(id));
        bookDao.getAll().remove(book);
    }

    @Override
    public void editBook(String authorName, String titleName, String keyWordLine, String bookId) {
        Book book = bookDao.getById(Integer.parseInt(bookId));
        book.setAuthor(new Author(authorName));
        book.setTitle(new Title(titleName));
        book.setKeyWords(Arrays.stream(keyWordLine.split(" "))
                .map(KeyWord::new)
                .collect(Collectors.toList()));
    }
}
