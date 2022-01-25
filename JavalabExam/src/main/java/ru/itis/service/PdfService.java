package ru.itis.service;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;
import ru.itis.dto.PdfDto;
import ru.itis.dto.PdfForAcademDto;
import ru.itis.dto.PdfForOtchDto;
import ru.itis.mapper.PdfMapper;
import ru.itis.model.Pdf;
import ru.itis.model.User;
import ru.itis.repository.PdfRepository;
import ru.itis.repository.UserRepository;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class PdfService {

    private final PdfRepository pdfsRepository;
    private final PdfMapper pdfMapper;
    private final UserRepository usersRepository;

    @SneakyThrows
    public byte[] generatePdfForAcadem(PdfForAcademDto pdfForAcademDto) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();

            content.setFont(PDType1Font.TIMES_ROMAN, 14);
            content.setLeading(16.5f);

            content.newLineAtOffset(25, 700);

            String text = "Я беру академический отпуск";
            content.showText(text);
            content.newLine();

            String name = "Name: " + pdfForAcademDto.getUserDto().getName();
            content.showText(name);
            content.newLine();

            String surname = "Surname: " + pdfForAcademDto.getUserDto().getSurname();
            content.showText(surname);
            content.newLine();

            String cource = "Cource: " + pdfForAcademDto.getCource();
            content.showText(cource);
            content.newLine();

            String year = "Year: " + pdfForAcademDto.getYear();
            content.showText(year);
            content.newLine();

            content.endText();
            content.close();

            document.save(byteArrayOutputStream);
            document.close();

            User user = usersRepository.findById(pdfForAcademDto.getUserDto().getId())
                    .orElseThrow((Supplier<Throwable>) () -> new IllegalArgumentException("USER_NOT_FOUND"));
            Pdf pdf = Pdf.builder()
                    .user(user)
                    .pdfBytes(byteArrayOutputStream.toByteArray())
                    .type(pdfForAcademDto.getPdfType().name())
                    .filename(pdfForAcademDto.getFilename())
                    .build();
            pdfsRepository.save(pdf);

            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            throw new IllegalArgumentException("ERROR_CREATING_PDF");
        }
    }

    @SneakyThrows
    public byte[] generatePdfForOtch(PdfForOtchDto pdfForOtchDto) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();

            content.setFont(PDType1Font.TIMES_ROMAN, 14);
            content.setLeading(16.5f);

            content.newLineAtOffset(25, 700);

            String text = "Я отчисляюсь по собственному желанию";
            content.showText(text);
            content.newLine();

            String name = "Name: " + pdfForOtchDto.getUserDto().getName();
            content.showText(name);
            content.newLine();

            String surname = "Surname: " + pdfForOtchDto.getUserDto().getSurname();
            content.showText(surname);
            content.newLine();

            String cource = "Cource: " + pdfForOtchDto.getCource();
            content.showText(cource);
            content.newLine();

            String year = "Year: " + pdfForOtchDto.getYear();
            content.showText(year);
            content.newLine();

            String facultet = "Facultet: " + pdfForOtchDto.getFacultet();
            content.showText(facultet);
            content.newLine();

            content.endText();
            content.close();

            document.save(byteArrayOutputStream);
            document.close();

            User user = usersRepository.findById(pdfForOtchDto.getUserDto().getId())
                    .orElseThrow((Supplier<Throwable>) () -> new IllegalArgumentException("USER_NOT_FOUND"));
            Pdf pdf = Pdf.builder()
                    .user(user)
                    .pdfBytes(byteArrayOutputStream.toByteArray())
                    .type(pdfForOtchDto.getPdfType().name())
                    .filename(pdfForOtchDto.getFilename())
                    .build();
            pdfsRepository.save(pdf);

            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            throw new IllegalArgumentException("ERROR_CREATING_PDF");
        }
    }

    @SneakyThrows
    public PdfDto getPdfBytesById(Long pdfId) {
        Pdf pdf = pdfsRepository.findById(pdfId)
                .orElseThrow((Supplier<Throwable>) () -> new IllegalArgumentException("PDF_NOT_FOUND"));
        return pdfMapper.toPdfDto(pdf);
    }

}

