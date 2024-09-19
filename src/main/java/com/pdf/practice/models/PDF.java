package com.pdf.practice.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Entity
@Table(name = "files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PDF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "save")
    private boolean save;
    @Lob
    @Column(name = "bytes", columnDefinition="LONGBLOB")
    private byte[] bytes;
    public PDF(MultipartFile filePDF, boolean save) throws IOException {
        this.save = save;
        originalFileName = filePDF.getOriginalFilename();
        size = filePDF.getSize();
        bytes = filePDF.getBytes();
    }
}