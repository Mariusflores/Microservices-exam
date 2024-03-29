package org.mada.exam.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int releaseYear;
    private String description;
}
