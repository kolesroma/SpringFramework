package com.example.demo.dao.entity;


import java.util.List;
import java.util.Objects;

public class Book {
    private Author author;
    private Title title;
    private List<KeyWord> keyWords;
    private int id;

    public Book(Author author, Title title, List<KeyWord> keyWords, int id) {
        this.author = author;
        this.title = title;
        this.keyWords = keyWords;
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public Title getTitle() {
        return title;
    }

    public List<KeyWord> getKeyWords() {
        return keyWords;
    }

    public int getId() {
        return id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setKeyWords(List<KeyWord> keyWords) {
        this.keyWords = keyWords;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getId() == book.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
