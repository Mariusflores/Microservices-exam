package org.mada.exam.bookservice.repository;

import org.mada.exam.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;

import java.util.List;
// ... other imports ...

public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{'$or': [{'author': {$regex: ?0, $options: 'i'}}, {'title': {$regex: ?0, $options: 'i'}}, {'genre': {$regex: ?0, $options: 'i'}}]}")
    List<Book> findByAuthorContainsOrTitleContainsOrGenreContains(String value);
}

