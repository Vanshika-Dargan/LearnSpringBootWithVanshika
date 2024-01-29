package com.vanshika.database.dao.impl;

import com.vanshika.database.TestDataUtil;
import com.vanshika.database.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
public class CountryDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    public CountryDaoImpl countryDaoImpl;

    @Test
    public void testThatCreateCountryGeneratesValidSql(){
        Country country=Country.builder()
                .id(1L)
                .name("India")
                .gdp(2256.59)
                .build();
        countryDaoImpl.create(country);

        verify(jdbcTemplate).update(
                eq("INSERT INTO country (id,name,gdp) VALUES(?,?,?)"),
        eq(1L),eq("India"),eq(2256.59D)
        );
    }

    @Test
    public void testThatFindOneCountryGeneratesValidSql(){
        countryDaoImpl.findOne(1L);

        verify(jdbcTemplate).query(
                eq("SELECT id,name,gdp FROM country WHERE id=? LIMIT 1"),
                ArgumentMatchers.<CountryDaoImpl.CountryRowMapper>any(),
                eq(1L)
        );
    }

    @Test
    public void testThatFindManyCountryGeneratesValidSql(){
        countryDaoImpl.find();

        verify(jdbcTemplate).query(
                eq("SELECT id,name,gdp FROM country"),
                ArgumentMatchers.<CountryDaoImpl.CountryRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateGeneratesValidSql(){
        Country country= TestDataUtil.createTestCountryD();
        countryDaoImpl.update(1L,country);

        verify(jdbcTemplate).update(
                eq("UPDATE country SET id=?,name=?,gdp=? WHERE id=?"),
                eq(4L),eq("Egypt"),eq(3700.13D),eq(1L)
        );

    }
}
