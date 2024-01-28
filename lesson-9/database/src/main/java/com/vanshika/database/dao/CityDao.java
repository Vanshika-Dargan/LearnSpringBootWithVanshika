package com.vanshika.database.dao;

import com.vanshika.database.domain.City;

import java.util.Optional;

public interface CityDao {
    void create(City city);

    Optional<City> findOne(long l);
}
