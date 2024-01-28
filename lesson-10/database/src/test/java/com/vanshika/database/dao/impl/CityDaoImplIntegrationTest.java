package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CountryDao;
import com.vanshika.database.domain.City;
import com.vanshika.database.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CityDaoImplIntegrationTest {

    private CityDaoImpl cityDaoImpl;
    private CountryDao countryDao;

    @Autowired
    public CityDaoImplIntegrationTest(CityDaoImpl cityDaoImpl,CountryDao countryDao){
        this.cityDaoImpl=cityDaoImpl;
        this.countryDao=countryDao;
    }

    @Test
    public void testThatCityCanBeCreatedAndRecalled(){
        Country country= Country.builder()
                .id(1L)
                .name("India")
                .gdp(2256.59D)
                .build();
        countryDao.create(country);
        City city=City.builder()
                .id(1L)
                .name("Mumbai")
                .country_id(1L)
                .build();
        city.setCountry_id(country.getId());
        cityDaoImpl.create(city);
        Optional<City> result=cityDaoImpl.findOne(city.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(city);
    }

}
