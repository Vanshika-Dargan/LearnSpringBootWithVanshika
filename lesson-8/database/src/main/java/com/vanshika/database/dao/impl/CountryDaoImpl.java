package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CountryDao;
import org.springframework.jdbc.core.JdbcTemplate;

public class CountryDaoImpl implements CountryDao {


    private final JdbcTemplate jdbcTemplate;

    public CountryDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
