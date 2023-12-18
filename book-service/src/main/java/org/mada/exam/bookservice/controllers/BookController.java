package org.mada.exam.bookservice.controllers;

import lombok.RequiredArgsConstructor;
import org.mada.exam.bookservice.dto.BookRequest;
import org.mada.exam.bookservice.dto.BookResponse;
import org.mada.exam.bookservice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks(){ return bookService.getAllBooks();}


    @GetMapping("/{value}")
    public List<BookResponse> getByAuthorContainsOrTitleContainsOrGenreContains(@PathVariable("value") String value){
        return bookService.getByAuthorContainsOrTitleContainsOrGenreContains(value);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody BookRequest bookRequest){

        bookService.createProduct(bookRequest);

    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteBooks(){
        bookService.deleteAll();
    }




}
