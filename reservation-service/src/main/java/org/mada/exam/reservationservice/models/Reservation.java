package org.mada.exam.reservationservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "t_reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reservationNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ReservationLineItems> reservationLineItemsList;

}
