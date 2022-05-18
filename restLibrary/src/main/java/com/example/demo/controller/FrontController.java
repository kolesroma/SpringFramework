package com.example.demo.controller;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import com.example.demo.service.Library;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books")
public class FrontController {
    final Library service;

    public FrontController(Library service) {
        this.service = service;
    }

    @GetMapping("/page/{page}")
    public Collection<Book> getAll(@PathVariable Integer page) {
        return service.getAll(page);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> get(@PathVariable Integer bookId) {
        return ResponseEntity.of(service.get(bookId));
    }

    @GetMapping("/author/{author}")
    public Collection<Book> get(@PathVariable Author author) {
        return service.get(author);
    }

    @GetMapping("/title/{title}")
    public Collection<Book> get(@PathVariable Title title) {
        return service.get(title);
    }

    @GetMapping("/keyWord/{keyWord}")
    public Collection<Book> get(@PathVariable KeyWord keyWord) {
        return service.get(keyWord);
    }

    /* process data */

    @PostMapping
    public void add(@RequestBody Book book) {
        service.add(book);
    }

    @PutMapping("/{bookId}")
    public void update(@PathVariable Integer bookId,
                       @RequestBody Book book) {
        service.update(bookId, book);
    }

    @DeleteMapping("/{bookId}")
    public void delete(@PathVariable Integer bookId) {
        service.remove(bookId);
    }
}
