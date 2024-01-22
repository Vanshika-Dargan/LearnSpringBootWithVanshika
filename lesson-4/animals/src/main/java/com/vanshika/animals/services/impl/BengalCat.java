package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.CatInterface;
import org.springframework.stereotype.Component;

@Component
public class BengalCat implements CatInterface {
    @Override
    public String print() {
        return "Bengal";
    }
}
