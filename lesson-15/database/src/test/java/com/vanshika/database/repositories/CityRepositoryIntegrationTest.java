package com.vanshika.database.repositories;

import com.vanshika.database.TestDataUtil;
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
public class CityRepositoryIntegrationTest {

    private CityRepository cityRepository;


    @Autowired
    public CityRepositoryIntegrationTest(CityRepository cityRepository){
        this.cityRepository=cityRepository;

    }

    @Test
    public void testThatCityCanBeCreatedAndRecalled(){
        Country country= TestDataUtil.createTestCountryA();
        City city= TestDataUtil.createTestCityA(country);
        cityRepository.save(city);
        Optional<City> result=cityRepository.findById(city.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(city);
    }

    @Test
    public void testThatMultipleCitiesCanBeCreatedAndRecalled(){
        Country countryA= TestDataUtil.createTestCountryA();
        City cityA= TestDataUtil.createTestCityA(countryA);

        cityRepository.save(cityA);

        City cityB= TestDataUtil.createTestCityB(countryA);

        cityRepository.save(cityB);

        City cityC= TestDataUtil.createTestCityC(countryA);

        cityRepository.save(cityC);

        Iterable<City> result=cityRepository.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(cityA,cityB,cityC);
    }

    @Test
    public void testThatCityCanBeUpdated(){
        Country country=TestDataUtil.createTestCountryA();
        City city=TestDataUtil.createTestCityA(country);
        cityRepository.save(city);
        city.setName("Ghaziabad");
        cityRepository.save(city);
        Optional<City> updatedCity=cityRepository.findById(city.getId());
        assertThat(updatedCity).isPresent();
        assertThat(updatedCity.get()).isEqualTo(city);

    }

    @Test
    public void testThatCityCanBeDeleted(){
        Country country=TestDataUtil.createTestCountryA();
        City city=TestDataUtil.createTestCityA(country);

        cityRepository.save(city);

        cityRepository.deleteById(city.getId());
        Optional<City> result=cityRepository.findById(1L);

        assertThat(result).isEmpty();
    }

}
