package ru.itis.dto;

import lombok.*;
import ru.itis.util.PdfType;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PdfForAcademDto extends SimplePdfDto {

    private int cource;

    private int year;

    private PdfType pdfType;

}
