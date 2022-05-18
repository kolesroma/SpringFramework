package com.example.demo.dao;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import com.example.demo.service.IncrementHashMap;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Primary
public class BookDaoInMemory implements BookDao {
    private final IncrementHashMap<Book> allBooks;

    public BookDaoInMemory() {
        this.allBooks = new IncrementHashMap<>();
        allBooks.add(getKobzar());
        allBooks.add(getOnTheWingsOfSongs());
    }

    private Book getKobzar() {
        return new Book(new Author("shevchenko"),
                new Title("kobzar"),
                List.of(new KeyWord("adventure"), new KeyWord("slaves"), new KeyWord("sadness")));
    }

    private Book getOnTheWingsOfSongs() {
        return new Book(new Author("lesya ukrainka"),
                new Title("on the wings of songs"),
                List.of(new KeyWord("adventure"), new KeyWord("happiness")));
    }

    @Override
    public Collection<Book> getAll(Integer page) {
        int pageCapacity = 2;
        int offset = (page - 1) * pageCapacity;
        return allBooks.values().stream()
                .skip(offset)
                .limit(pageCapacity)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Book> get(Author author) {
        return allBooks.values().stream()
                .filter(b -> b.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Book> get(Title title) {
        return allBooks.values().stream()
                .filter(b -> b.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Book> get(KeyWord keyWord) {
        return allBooks.values().stream()
                .filter(b -> b.getKeyWords().contains(keyWord))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> get(Integer id) {
        return Optional.ofNullable(allBooks.get(id));
    }

    @Override
    public void add(Book book) {
        allBooks.add(book);
    }

    @Override
    public void update(Integer id, Book book) {
        allBooks.put(id, book);
    }

    @Override
    public void remove(Integer id) {
        allBooks.remove(id);
    }
}
