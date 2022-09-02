package fr.m2i.feuilledethym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;


import java.util.ResourceBundle;

@SpringBootApplication
public class FeuilledeThymApplication {

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages");
		return source;
	}


	public static void main(String[] args) {
		SpringApplication.run(FeuilledeThymApplication.class, args);
	}

}
