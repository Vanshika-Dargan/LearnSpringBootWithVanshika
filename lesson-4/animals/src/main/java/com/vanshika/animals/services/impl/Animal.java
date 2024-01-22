package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.AnimalInterface;
import com.vanshika.animals.services.CatInterface;
import com.vanshika.animals.services.DogInterface;
import com.vanshika.animals.services.HorseInterface;
import org.springframework.stereotype.Component;

@Component
public class Animal implements AnimalInterface {

    private DogInterface dog;
    private CatInterface cat;
    private HorseInterface horse;

    public Animal(DogInterface dog,CatInterface cat,HorseInterface horse){

    this.dog=dog;
    this.cat=cat;
    this.horse=horse;
    }
    @Override
    public String print() {
        return String.join(",",dog.print(),cat.print(),horse.print());
    }
}
