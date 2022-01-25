package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.model.Pdf;

@Repository
public interface PdfRepository extends JpaRepository<Pdf, Long> {
}
