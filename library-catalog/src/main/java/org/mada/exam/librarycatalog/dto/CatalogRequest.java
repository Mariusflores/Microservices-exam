package org.mada.exam.librarycatalog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogRequest {
    private String isbn;
    private int quantity;
    private int quantityAvailable;
}
