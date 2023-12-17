package org.mada.exam.librarycatalog.repository;

import org.mada.exam.librarycatalog.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository extends JpaRepository<Catalog, String> {

    Optional<Catalog> findByIsbn(String isbn);
}
