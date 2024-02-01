package com.vanshika.database.repositories;


import com.vanshika.database.TestDataUtil;
import com.vanshika.database.domain.Country;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryRepositoryIntegrationTest {


    @Autowired
    private CountryRepository countryRepository;





    @Test
    public void testThatCountryCanBeCreatedAndRecalled(){

        Country country= TestDataUtil.createTestCountryA();

        countryRepository.save(country);
        Optional<Country> result=countryRepository.findById(country.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(country);
    }

    @Test
    public void testThatMultipleCountriesCanBeCreatedAndRecalled(){

        Country countryA= TestDataUtil.createTestCountryA();
        countryRepository.save(countryA);
        Country countryB= TestDataUtil.createTestCountryB();
        countryRepository.save(countryB);
        Country countryC= TestDataUtil.createTestCountryC();
    countryRepository.save(countryC);
        Iterable<Country> results=countryRepository.findAll();
        assertThat(results)
                .hasSize(3)
                .containsExactly(countryA,countryB,countryC);
    }

    @Test
    public void testThatCountryCanBeUpdated(){

        Country countryA=TestDataUtil.createTestCountryA();
        countryRepository.save(countryA);
        countryA.setName("Australia");
        countryRepository.save(countryA);
        Optional<Country> updatedCountry=countryRepository.findById(countryA.getId());
        assertThat(updatedCountry).isPresent();
        assertThat(updatedCountry.get()).isEqualTo(countryA);
    }

    @Test
    public void testThatCountryCanBeDeleted(){
        Country country=TestDataUtil.createTestCountryA();
        countryRepository.save(country);
        countryRepository.deleteById(country.getId());
        Optional<Country> result=countryRepository.findById(1L);
        assertThat(result).isEmpty();
    }

}
