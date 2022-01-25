package ru.itis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import ru.itis.dto.PdfDto;
import ru.itis.model.Pdf;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = UserMapper.class)
public interface PdfMapper {

    PdfDto toPdfDto(Pdf pdf);

    Pdf toPdf(PdfDto pdfDto);

}
