package ua.nure.odyw.client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.nure.odyw.client.model.Book;
import ua.nure.odyw.client.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/book", consumes = "text/graphql")
    public Book bookById(@RequestBody String query) {
        return bookService.getBook(query);
    }

}