package org.mada.exam.reservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationLineItemsDto {

    private Long id;
    private String isbn;
    private Integer quantity;

}
