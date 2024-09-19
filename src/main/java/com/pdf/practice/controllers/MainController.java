package com.pdf.practice.controllers;

import com.pdf.practice.models.PDF;
import com.pdf.practice.services.PDFService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final PDFService pdfService;
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("files", pdfService.listPDF());
        return "home";
    }
    @PostMapping("/home/submit")
    public String fileSubmit(@RequestParam("filePDF") MultipartFile filePDF, boolean save, RedirectAttributes redirectAttributes) throws IOException {
        if (pdfService.isPDF(filePDF.getContentType())) {
            PDF pdf = new PDF(filePDF, save);
            pdfService.savePDF(pdf);
            return "redirect:/pdf/analize/" + pdf.getId();
        }
        redirectAttributes.addFlashAttribute("errorMessage", "Ошибка! Файл дожен быть формата .pdf");
        return "redirect:/home";
    }
    @GetMapping("/pdf/analize/{id}")
    public String pdfAnalizeDB(@PathVariable Long id, Model model) throws IOException {
        Map<String, Object> attributes = new HashMap<>();
        PDF pdf = pdfService.getPDFById(id);
        attributes.put("originalFileName", pdf.getOriginalFileName());
        attributes.put("size", pdf.getSize());
        PDDocument document = Loader.loadPDF(pdf.getBytes());
        attributes.put("count", document.getNumberOfPages());
        PDPage page = document.getPage(0);
        PDRectangle mediaBox = page.getMediaBox();
        double pageWidth = mediaBox.getWidth();
        double pageHeight = mediaBox.getHeight();
        PDRectangle cropBox = page.getCropBox();
        double printWidth = cropBox.getWidth();
        double printHeight = cropBox.getHeight();
        attributes.put("pageWidth", String.format("%.1f",(pageWidth*254/7200)));
        attributes.put("pageHeight", String.format("%.1f",(pageHeight*254/7200)));
        attributes.put("printWidth", String.format("%.1f",(printWidth*254/7200)));
        attributes.put("printHeight", String.format("%.1f",(printHeight*254/7200)));
        attributes.put("printWidthPercent", (printWidth / pageWidth) * 100);
        attributes.put("printHeightPercent", (printHeight / pageHeight) * 100);
        attributes.put("pdfId", id);
        model.addAllAttributes(attributes);
        return "analize";
    }
    @GetMapping("/pdf/read/{id}")
    public String pdfRead(@PathVariable Long id, Model model) {
        model.addAttribute("fileName", pdfService.getPDFById(id).getOriginalFileName());
        model.addAttribute("fileId", id);
        return "pdf";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        pdfService.deletePDF(id);
        return "redirect:/home";
    }
}