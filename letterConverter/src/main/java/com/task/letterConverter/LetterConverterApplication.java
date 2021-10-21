package com.task.letterConverter;

import com.task.letterConverter.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class LetterConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetterConverterApplication.class, args);
	}


}