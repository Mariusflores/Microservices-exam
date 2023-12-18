package org.mada.exam.librarycatalog.RabbitMQ;
/*
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

 */
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
/*
    public static final String QUEUE_NAME = "book-queue";

    @Bean
    public AmqpTemplate Template(ConnectionFactory connectionFactory){
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    ConnectionFactory connectionFactory(){
        return new CachingConnectionFactory();
    }

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME, false);
    }

 */
}
