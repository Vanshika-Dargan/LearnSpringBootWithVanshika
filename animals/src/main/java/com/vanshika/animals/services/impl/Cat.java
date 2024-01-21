package com.vanshika.animals.services.impl;

import com.vanshika.animals.services.CatInterface;

public class Cat implements CatInterface {
    @Override
    public String print() {
        return "Persian";
    }
}
