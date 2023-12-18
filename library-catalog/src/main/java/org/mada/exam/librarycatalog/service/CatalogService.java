package org.mada.exam.librarycatalog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mada.exam.librarycatalog.dto.CatalogRequest;
import org.mada.exam.librarycatalog.dto.CatalogResponse;
import org.mada.exam.librarycatalog.models.Catalog;
import org.mada.exam.librarycatalog.repository.CatalogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {

    private final CatalogRepository catalogRepository;


    @Transactional(readOnly = true)
    public List<CatalogResponse> isAvailable(List<String> isbn) {
        return catalogRepository.findByIsbnIn(isbn).stream()
                .map(catalog ->
                        CatalogResponse.builder()
                                .isbn(catalog.getIsbn())
                                .isAvailable(catalog.getQuantityAvailable() > 0)
                                .build())
                .toList();
    }

    public List<CatalogRequest> findAll() {
        List<Catalog> catalog = catalogRepository.findAll();
        return catalog.stream()
                .map(c ->
                        CatalogRequest.builder()
                                .isbn(c.getIsbn())
                                .quantity(c.getQuantity())
                                .quantityAvailable(c.getQuantityAvailable())
                                .build())
                .toList();
    }

    public void addBook(CatalogRequest request) {
        Catalog catalog = Catalog.builder()
                .isbn(request.getIsbn())
                .quantity(request.getQuantity())
                .quantityAvailable(request.getQuantityAvailable())
                .build();

        catalogRepository.save(catalog);
    }
}
