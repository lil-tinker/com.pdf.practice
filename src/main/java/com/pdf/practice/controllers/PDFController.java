package com.pdf.practice.controllers;

import com.pdf.practice.models.PDF;
import com.pdf.practice.services.PDFService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class PDFController {
    private final PDFService pdfService;
    @GetMapping("/pdf/read/files/{id}")
    private ResponseEntity<?> getPDFById(@PathVariable Long id)  {
        PDF pdf = pdfService.getPDFById(id);
        return ResponseEntity.ok()
                .header("fileName", pdf.getOriginalFileName())
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdf.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(pdf.getBytes())));
    }
}