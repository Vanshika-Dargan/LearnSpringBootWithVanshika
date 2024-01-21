package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.AnimalInterface;
import com.vanshika.animals.services.CatInterface;
import com.vanshika.animals.services.DogInterface;
import com.vanshika.animals.services.HorseInterface;

public class Animal implements AnimalInterface {

    private DogInterface dog;
    private CatInterface cat;
    private HorseInterface horse;

    public Animal(){
        this.dog=new Dog();
        this.cat=new Cat();
        this.horse=new Horse();
    }
    @Override
    public String print() {
        return String.join(",",dog.print(),cat.print(),horse.print());
    }
}
