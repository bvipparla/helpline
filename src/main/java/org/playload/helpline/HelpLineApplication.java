package org.playload.helpline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.playload.helpline"})
public class HelpLineApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelpLineApplication.class, args);
	}
}
