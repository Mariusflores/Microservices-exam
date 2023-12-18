package org.mada.exam.reservationservice.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mada.exam.reservationservice.dto.ReservationRequest;
import org.mada.exam.reservationservice.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String reserveBook(@RequestBody ReservationRequest reservationRequest){

        log.info(reservationRequest.getReservationLineItemsDtoList().toString());
        reservationService.reserveBook(reservationRequest);
        return "order placed successfully";
    }

}
