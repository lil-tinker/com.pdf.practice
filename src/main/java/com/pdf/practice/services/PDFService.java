package com.pdf.practice.services;

import com.pdf.practice.models.PDF;
import com.pdf.practice.repositories.PDFRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PDFService {
    private final PDFRepository pdfRepository;
    public List<PDF> listPDF() {
        return pdfRepository.findBySave(true);
    }
    public void deletePDF(Long id) {
        pdfRepository.deleteById(id);
    }
    public void savePDF(PDF pdf) {
        pdfRepository.save(pdf);
    }
    public boolean isPDF(String MIME) {
        return Objects.equals(MIME, "application/pdf");
    }
    public PDF getPDFById(Long id) {
        return pdfRepository.findById(id).orElse(null);
    }
    @Scheduled(fixedDelayString = "PT05M")
    public void clearDB() {
        pdfRepository.deleteAll(pdfRepository.findBySave(false));
    }
}