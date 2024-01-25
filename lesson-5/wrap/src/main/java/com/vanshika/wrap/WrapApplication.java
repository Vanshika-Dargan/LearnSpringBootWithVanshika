package com.vanshika.wrap;

import com.vanshika.wrap.config.WrapConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class WrapApplication implements CommandLineRunner {

	private WrapConfig wrapConfig;
	public static void main(String[] args) {
		SpringApplication.run(WrapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(
			String.format("I want a wrap with %s cheese, %s bread and %s toppings",
			wrapConfig.getCheese(),
			wrapConfig.getBread(),
					wrapConfig.getToppings()

			)
		);
	}
}
