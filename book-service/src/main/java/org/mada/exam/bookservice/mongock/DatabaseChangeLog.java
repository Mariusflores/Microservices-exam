package org.mada.exam.bookservice.mongock;

import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@ChangeUnit(order = "001", id = "books_initializer", author = "candidate_2015")
@RequiredArgsConstructor
public class DatabaseChangeLog {

    private final MongoTemplate mongoTemplate;

    @Execution
    public void changeSet(){
        getData().stream()
                .forEach(book ->  mongoTemplate.save(book, "books"));
    }

    @RollbackExecution
    public void rollback() {
        mongoTemplate.remove(new Query());
    }

    public List<Document> getData(){
        List<Document> books = new ArrayList<>();

        Document book1 = new Document()
                .append("isbn", "978-0988262591")
                .append("title", "The Phoenix Project")
                .append("author", "Gene Kim")
                .append("genre", "Novel")
                .append("releaseYear", 2013)
                .append("description", "a business novel that chronicles Bill, an IT manager's journey to revamp his struggling company's processes, using principles of DevOps");

        books.add(book1);

        Document book2 = new Document()
                .append("isbn", "979-8579327079")
                .append("title", "Read People Like a Book")
                .append("author", "Patrick King")
                .append("genre", "Self-help book")
                .append("releaseYear", 2020)
                .append("description", "Speed read people, decipher body language, detect lies, and understand human nature.");

        books.add(book2);

        return books;
    }
}
