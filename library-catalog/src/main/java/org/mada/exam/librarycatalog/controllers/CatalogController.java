package org.mada.exam.librarycatalog.controllers;

import lombok.RequiredArgsConstructor;
import org.mada.exam.librarycatalog.service.CatalogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private CatalogService catalogService;
/*
    @GetMapping()
    public List<CatalogResponse> displayCatalog(){
        return catalogService.getAllBooks();

    }

 */



}
