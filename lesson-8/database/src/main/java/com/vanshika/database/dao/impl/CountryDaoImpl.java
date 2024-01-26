package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CountryDao;
import com.vanshika.database.domain.Country;
import org.springframework.jdbc.core.JdbcTemplate;

public class CountryDaoImpl implements CountryDao {


    private final JdbcTemplate jdbcTemplate;

    public CountryDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Country country) {
        jdbcTemplate.update("INSERT INTO country (id,name,gdp) VALUES(?,?,?)",country.getId(),country.getName(),country.getGdp());
    }
}
