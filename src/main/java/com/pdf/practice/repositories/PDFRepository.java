package com.pdf.practice.repositories;

import com.pdf.practice.models.PDF;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PDFRepository extends JpaRepository<PDF, Long> {
    List<PDF> findBySave(boolean save);
}