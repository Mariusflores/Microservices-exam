package org.mada.exam.bookservice.repository;

import org.mada.exam.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book, String> {
}
