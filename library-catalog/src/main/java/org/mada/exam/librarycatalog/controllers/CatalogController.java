package org.mada.exam.librarycatalog.controllers;

import lombok.RequiredArgsConstructor;
import org.mada.exam.librarycatalog.dto.CatalogRequest;
import org.mada.exam.librarycatalog.dto.CatalogResponse;
import org.mada.exam.librarycatalog.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogResponse> isInStock(@RequestParam List<String> isbn) {
        return catalogService.isAvailable(isbn);
    }
}
