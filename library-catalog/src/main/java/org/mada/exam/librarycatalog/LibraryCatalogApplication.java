package org.mada.exam.librarycatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"org.mada.exam.librarycatalog.RabbitMQ", "org.mada.exam.librarycatalog.service"})
public class LibraryCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryCatalogApplication.class, args);
    }

}
