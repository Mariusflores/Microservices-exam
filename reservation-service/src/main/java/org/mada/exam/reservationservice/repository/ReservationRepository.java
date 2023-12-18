package org.mada.exam.reservationservice.repository;

import org.mada.exam.reservationservice.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
