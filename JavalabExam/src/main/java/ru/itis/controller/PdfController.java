package ru.itis.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.PdfDto;
import ru.itis.dto.PdfForAcademDto;
import ru.itis.dto.PdfForOtchDto;
import ru.itis.service.PdfService;
import ru.itis.service.ProducerService;
import ru.itis.util.JsonUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pdf")
public class PdfController {

    private final ProducerService producerService;
    private final PdfService pdfService;


    @PostMapping("/academ")
    public ResponseEntity<String> generatePdfForAddress(@RequestBody PdfForAcademDto pdfForAcademDto) {
        return ResponseEntity.ok(
                producerService.convertAndSend(pdfForAcademDto.getPdfType().toString(),
                        JsonUtil.pdfDtoToJson(pdfForAcademDto)
                )
        );
    }

    @PostMapping("/otch")
    public ResponseEntity<String> generatePdfForBankAccount(@RequestBody PdfForOtchDto pdfForOtchDto) {
        return ResponseEntity.ok(
                producerService.convertAndSend(pdfForOtchDto.getPdfType().toString(),
                        JsonUtil.pdfDtoToJson(pdfForOtchDto)
                )
        );
    }

    @GetMapping("/{pdf-id}")
    public ResponseEntity<byte []> getPdfById(@PathVariable("pdf-id") Long pdfId) {
        PdfDto pdfDto = pdfService.getPdfBytesById(pdfId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.builder("attachment").filename(pdfDto.getFilename()).build().toString())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(pdfDto.getPdfBytes());
    }

}

