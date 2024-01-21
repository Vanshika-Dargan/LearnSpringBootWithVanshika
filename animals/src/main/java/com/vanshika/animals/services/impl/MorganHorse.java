package com.vanshika.animals.services.impl;


import com.vanshika.animals.services.HorseInterface;

public class MorganHorse implements HorseInterface {

    @Override
    public String print() {
        return "Morgan";
    }
}
