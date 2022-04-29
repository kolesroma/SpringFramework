package com.example.demo.dao;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@Primary
public class BookDaoFake implements BookDao {
    private final List<Book> allBooks = new ArrayList<>(List.of(getKobzar(), getOnTheWingsOfSongs()));

    private Book getKobzar() {
        return new Book(new Author("shevchenko"),
                new Title("kobzar"),
                List.of(new KeyWord("adventure"), new KeyWord("slaves"), new KeyWord("sadness")),
                1);
    }

    private Book getOnTheWingsOfSongs() {
        return new Book(new Author("lesya ukrainka"),
                new Title("on the wings of songs"),
                List.of(new KeyWord("adventure"), new KeyWord("happiness")),
                2);
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return allBooks.stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public void addBook(Book book) {
        allBooks.add(book);
    }

    @Override
    public List<Book> getByTitle(Title title) {
        return allBooks.stream()
                .filter(b -> b.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getByKeyWord(KeyWord keyWord) {
        return allBooks.stream()
                .filter(b -> b.getKeyWords().contains(keyWord))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAll() {
        return allBooks;
    }

    @Override
    public Book getById(int id) {
        return allBooks.stream()
                .filter(b -> b.getId() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("no book with such id"));
    }
}
