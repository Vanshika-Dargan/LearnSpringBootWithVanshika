package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CityDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CityDaoImpl implements CityDao {

    private final JdbcTemplate jdbcTemplate;


    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
