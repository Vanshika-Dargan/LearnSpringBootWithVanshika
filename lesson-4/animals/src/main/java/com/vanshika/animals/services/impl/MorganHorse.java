package com.vanshika.animals.services.impl;


import com.vanshika.animals.services.HorseInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MorganHorse implements HorseInterface {

    @Override
    public String print() {
        return "Morgan";
    }
}
