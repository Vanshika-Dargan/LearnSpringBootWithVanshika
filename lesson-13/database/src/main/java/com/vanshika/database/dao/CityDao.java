package com.vanshika.database.dao;

import com.vanshika.database.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    void create(City city);

    Optional<City> findOne(long l);

    List<City> find();

    void update(long l, City city);

    void delete(long l);
}
