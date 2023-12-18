package org.mada.exam.reservationservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_reservation_line_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationLineItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String isbn;
    private int quantity;
}
