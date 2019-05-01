package com.lays.sampleactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SampleActivemqApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SampleActivemqApplication.class, args);
        JmsTemplate jms = ctx.getBean(JmsTemplate.class);
        jms.convertAndSend("sample-queue-1", "hello world");
    }

}
