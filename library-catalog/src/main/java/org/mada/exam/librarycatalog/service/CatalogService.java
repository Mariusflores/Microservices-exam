package org.mada.exam.librarycatalog.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mada.exam.librarycatalog.repository.CatalogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {

    private final CatalogRepository catalogRepository;


}
