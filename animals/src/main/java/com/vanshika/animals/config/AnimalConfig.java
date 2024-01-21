package com.vanshika.animals.config;

import com.vanshika.animals.services.AnimalInterface;
import com.vanshika.animals.services.DogInterface;
import com.vanshika.animals.services.CatInterface;
import com.vanshika.animals.services.HorseInterface;
import com.vanshika.animals.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnimalConfig {

    @Bean
    public DogInterface dogType(){
//        return new LabradorDog();
        return new ShihTzuDog();
    }
    @Bean
    public CatInterface catType(){
//        return new PersianCat();
        return new BengalCat();
    }

    @Bean
    public HorseInterface horseTye(){
//        return new ArabicHorse();
        return new MorganHorse();
    }

    @Bean
    public AnimalInterface animalType(DogInterface dog,CatInterface cat,HorseInterface horse){

        return new Animal(dog,cat,horse);
    }

}
