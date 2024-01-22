package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.HorseInterface;
import org.springframework.stereotype.Component;


public class ArabicHorse implements HorseInterface {
    @Override
    public String print() {
        return "Arabic";
    }
}
