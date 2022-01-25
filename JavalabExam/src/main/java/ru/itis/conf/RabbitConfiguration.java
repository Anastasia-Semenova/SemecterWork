package ru.itis.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.util.PdfType;

@Slf4j
@EnableRabbit
@Configuration
public class RabbitConfiguration {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.queue.academ}")
    private String queueAcadem;

    @Value("${rabbit.queue.otch}")
    private String queueOtch;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setUsername(username);
//        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPort(port);
        connectionFactory.setHost(host);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setExchange(exchange);
        return rabbitTemplate;
    }

    @Bean
    public Queue academQueue() {
        return new Queue(queueAcadem);
    }

    @Bean
    public Queue otchQueue() {
        return new Queue(queueOtch);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding academBinding(){
        return BindingBuilder.bind(academQueue()).to(directExchange()).with(PdfType.ACADEM.name());
    }

    @Bean
    public Binding otchAccountBinding(){
        return BindingBuilder.bind(otchQueue()).to(directExchange()).with(PdfType.OTCH.name());
    }


}
