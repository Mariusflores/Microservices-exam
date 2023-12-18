package org.mada.exam.librarycatalog.repository;

import org.mada.exam.librarycatalog.models.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, String> {

    List<Catalog> findByIsbnIn(List<String> isbn);
}
