package org.mada.exam.reservationservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mada.exam.reservationservice.dto.CatalogResponse;
import org.mada.exam.reservationservice.dto.ReservationLineItemsDto;
import org.mada.exam.reservationservice.dto.ReservationRequest;
import org.mada.exam.reservationservice.models.Reservation;
import org.mada.exam.reservationservice.models.ReservationLineItems;
import org.mada.exam.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final WebClient.Builder webClientBuilder;


    public void reserveBook(ReservationRequest reservationRequest) {

        Reservation reservation = new Reservation();
        reservation.setReservationNumber(UUID.randomUUID().toString());

        List<ReservationLineItems> reservationLineItems = reservationRequest.getReservationLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        log.info(reservationLineItems.toString());
        reservation.setReservationLineItemsList(reservationLineItems);
        List<String> isbnNumbers = reservation.getReservationLineItemsList().stream()
                .map(ReservationLineItems::getIsbn)
                .toList();

        log.info(isbnNumbers.toString());
        //call catalog response, and place reservation if book is available
        CatalogResponse[] catalogResponses = webClientBuilder.build().get()
                .uri("http://library-catalog/api/catalog",
                        uriBuilder -> uriBuilder.queryParam("isbn", isbnNumbers).build())
                .retrieve()
                .bodyToMono(CatalogResponse[].class)
                .block();

        boolean allBooksAvailable = Arrays.stream(catalogResponses).allMatch(CatalogResponse::isAvailable);

        log.info(reservation.toString());
        if (allBooksAvailable) {
            reservationRepository.save(reservation);
        } else {
            throw new IllegalArgumentException("Book(s) not available, please try again later");
        }

    }

    private ReservationLineItems mapToDto(ReservationLineItemsDto reservationLineItemsDto) {

        return ReservationLineItems.builder()
                .isbn(reservationLineItemsDto.getIsbn())
                .quantity(reservationLineItemsDto.getQuantity())
                .build();
    }
}
