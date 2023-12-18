package org.mada.exam.librarycatalog.RabbitMQ;

import lombok.RequiredArgsConstructor;
/*
import org.mada.exam.librarycatalog.dto.CatalogRequest;
import org.mada.exam.librarycatalog.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

 */
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQListener {

/*
    private final CatalogService catalogService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        // Process the received message
        System.out.println("Received message: " + message);

        CatalogRequest catalogRequest = CatalogRequest.builder()
                .isbn(message)
                .quantity(4)
                .quantityAvailable(4)
                .build();

        catalogService.AddBook(catalogRequest);
    }

 */
}
