package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.DogInterface;
import org.springframework.stereotype.Component;

@Component
public class LabradorDog implements DogInterface {
    @Override
    public String print() {
        return "Labrador";
    }
}
