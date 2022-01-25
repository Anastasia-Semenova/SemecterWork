package ru.itis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.dto.SimplePdfDto;

public class JsonUtil {

    public static String pdfDtoToJson(SimplePdfDto simplePdfDto) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(simplePdfDto);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
