package org.mada.exam.librarycatalog;

import org.mada.exam.librarycatalog.models.Catalog;
import org.mada.exam.librarycatalog.repository.CatalogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryCatalogApplication {

    public static void main(String[] args) {

        SpringApplication.run(LibraryCatalogApplication.class, args);


    }

    @Bean
    public CommandLineRunner loadData(CatalogRepository catalogRepository){
        return args -> {
            Catalog catalog = new Catalog();
            catalog.setIsbn("9781942788294");
            catalog.setQuantity(4);
            catalog.setQuantityAvailable(4);

            catalogRepository.save(catalog);
        };
    }

}
