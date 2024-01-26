package com.vanshika.database.dao.impl;

import com.vanshika.database.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
