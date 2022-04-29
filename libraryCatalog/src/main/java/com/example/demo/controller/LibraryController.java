package com.example.demo.controller;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.KeyWord;
import com.example.demo.dao.entity.Title;
import com.example.demo.service.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    private Library library;

    @GetMapping("byAuthor")
    public String byAuthor(@RequestParam String authorName, Model model) {
        List<Book> books = library.getByAuthorName(authorName);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("byTitle")
    public String byTitle(@RequestParam String titleName, Model model) {
        List<Book> books = library.getByTitleName(titleName);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("byKeyWord")
    public String byKeyWord(@RequestParam String keyWordName, Model model) {
        List<Book> books = library.getByKeyWordName(keyWordName);
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("allBooks")
    public String allBooks(Model model) {
        List<Book> books = library.getAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("byId")
    public String byId(@RequestParam int bookId, Model model) {
        List<Book> books = List.of(library.getById(bookId));
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("addBook")
    public String addBook(@RequestParam String authorName,
                          @RequestParam String titleName,
                          @RequestParam String keyWordLine,
                          @RequestParam String bookId) {
        library.addBook(authorName, titleName, keyWordLine, bookId);
        return "home";
    }

    @PostMapping("removeBook")
    public String removeBook(@RequestParam String bookId) {
        library.removeBook(bookId);
        return "home";
    }

    @PostMapping("editBook")
    public String editBook(@RequestParam String authorName,
                           @RequestParam String titleName,
                           @RequestParam String keyWordLine,
                           @RequestParam String bookId) {
        library.editBook(authorName, titleName, keyWordLine, bookId);
        return "home";
    }
}
