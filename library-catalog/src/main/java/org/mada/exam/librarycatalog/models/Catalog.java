package org.mada.exam.librarycatalog.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String isbn;
    private int quantity;
    private int quantityAvailable;
}
