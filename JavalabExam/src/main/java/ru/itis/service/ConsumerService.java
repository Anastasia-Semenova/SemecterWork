package ru.itis.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.dto.PdfForAcademDto;
import ru.itis.dto.PdfForOtchDto;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PdfService pdfService;

    @RabbitListener(queues = "queue_address")
    public void addressWorker(String message) {
        log.info("MESSAGE ACCEPTED {}", message);
        PdfForAcademDto pdf;
        try {
            pdf = objectMapper.readValue(message, PdfForAcademDto.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON_NOT_READ");
        }
        pdfService.generatePdfForAcadem(pdf);
    }

    @RabbitListener(queues = "queue_bank_account")
    public void bankAccountWorker(String message) {
        log.info("MESSAGE ACCEPTED {}", message);
        PdfForOtchDto pdf;
        try {
            pdf = objectMapper.readValue(message, PdfForOtchDto.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON_NOT_READ");
        }
        pdfService.generatePdfForOtch(pdf);
    }

}

