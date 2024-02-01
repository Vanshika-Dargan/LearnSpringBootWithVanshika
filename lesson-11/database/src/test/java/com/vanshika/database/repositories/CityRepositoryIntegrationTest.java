package com.vanshika.database.repositories;

import com.vanshika.database.TestDataUtil;
import com.vanshika.database.dao.CountryDao;
import com.vanshika.database.domain.City;
import com.vanshika.database.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
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
        Country country= TestDataUtil.createTestCountryA();
        countryDao.create(country);
        City city= TestDataUtil.createTestCityA();
        city.setCountry_id(country.getId());
        cityDaoImpl.create(city);
        Optional<City> result=cityDaoImpl.findOne(city.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(city);
    }

    @Test
    public void testThatMultipleCitiesCanBeCreatedAndRecalled(){
        Country countryA= TestDataUtil.createTestCountryA();
        countryDao.create(countryA);
        City cityA= TestDataUtil.createTestCityA();
        cityA.setCountry_id(1L);
        cityDaoImpl.create(cityA);

        City cityB= TestDataUtil.createTestCityB();
        cityB.setCountry_id(1L);
        cityDaoImpl.create(cityB);

        City cityC= TestDataUtil.createTestCityC();
        cityC.setCountry_id(1L);
        cityDaoImpl.create(cityC);

        List<City> result=cityDaoImpl.find();
        assertThat(result)
                .hasSize(3)
                .containsExactly(cityA,cityB,cityC);
    }

    @Test
    public void testThatCityCanBeUpdated(){
        Country country=TestDataUtil.createTestCountryA();
        countryDao.create(country);
        City city=TestDataUtil.createTestCityA();
        city.setCountry_id(country.getId());
        cityDaoImpl.create(city);
        city.setName("Ghaziabad");
        cityDaoImpl.update(city.getId(),city);
        Optional<City> updatedCity=cityDaoImpl.findOne(city.getId());
        assertThat(updatedCity).isPresent();
        assertThat(updatedCity.get()).isEqualTo(city);

    }

    @Test
    public void testThatCityCanBeDeleted(){
        Country country=TestDataUtil.createTestCountryA();
        countryDao.create(country);

        City city=TestDataUtil.createTestCityA();
        city.setCountry_id(country.getId());
        cityDaoImpl.create(city);

        cityDaoImpl.delete(city.getId());
        Optional<City> result=cityDaoImpl.findOne(1L);

        assertThat(result).isEmpty();
    }

}
