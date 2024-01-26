package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CityDao;
import com.vanshika.database.domain.City;
import org.springframework.jdbc.core.JdbcTemplate;

public class CityDaoImpl implements CityDao {

    private final JdbcTemplate jdbcTemplate;


    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(City city) {
        jdbcTemplate.update("INSERT INTO city (id,name,country_id) VALUES(?,?,?)",city.getId(),city.getName(),city.getCountry_id());
    }
}
