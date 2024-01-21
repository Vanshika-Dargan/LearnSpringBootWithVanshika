package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.DogInterface;

public class Dog implements DogInterface {
    @Override
    public String print() {
        return "Labrador";
    }
}
