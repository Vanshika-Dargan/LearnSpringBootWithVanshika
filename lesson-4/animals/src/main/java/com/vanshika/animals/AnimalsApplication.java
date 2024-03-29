package com.vanshika.animals;

import com.vanshika.animals.services.impl.Animal;
import com.vanshika.animals.services.AnimalInterface;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class AnimalsApplication implements CommandLineRunner {

	private AnimalInterface animal;

	public AnimalsApplication(AnimalInterface animal){
		this.animal=animal;
	}
	public static void main(String[] args) {

		SpringApplication.run(AnimalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info(animal.print());

	}




}
