package com.vanshika.database.dao;

import com.vanshika.database.domain.Country;

import java.util.Optional;


public interface CountryDao {
    void create(Country country);

    Optional<Country> findOne(long l);
}
