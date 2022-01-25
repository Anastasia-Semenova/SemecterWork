package ru.itis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.itis.conf.RabbitConfiguration;

@SpringBootApplication
@Import(RabbitConfiguration.class)
public class PdfgeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfgeneratorApplication.class, args);
    }

}
