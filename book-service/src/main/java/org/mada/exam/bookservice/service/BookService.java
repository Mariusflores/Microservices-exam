package org.mada.exam.bookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mada.exam.bookservice.RabbitMQ.RabbitMQSender;
import org.mada.exam.bookservice.dto.BookRequest;
import org.mada.exam.bookservice.dto.BookResponse;
import org.mada.exam.bookservice.model.Book;
import org.mada.exam.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final RabbitMQSender sender;
    private final BookRepository bookRepository;

    public void createProduct(BookRequest bookRequest) {
        Book book = Book.builder()
                .isbn(bookRequest.getIsbn())
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .releaseYear(bookRequest.getReleaseYear())
                .description(bookRequest.getDescription())
                .build();

        bookRepository.save(book);
        sender.sendMessage(book.getIsbn());
        log.info("product: {} is saved", book.getId());
    }

    public List<BookResponse> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(this::mapToBookResponse).toList();
    }

    private BookResponse mapToBookResponse(Book book) {

        return BookResponse.builder()
                .isbn(book.getIsbn())
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .releaseYear(book.getReleaseYear())
                .description(book.getDescription())
                .build();
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
