package org.mada.exam.librarycatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryCatalogApplication.class, args);
    }

}
