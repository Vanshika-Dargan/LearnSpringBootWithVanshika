package com.vanshika.database.dao.impl;


import com.vanshika.database.domain.Country;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryDaoImplIntegrationTest {


    @Autowired
    private CountryDaoImpl countryDaoImpl;





    @Test
    public void testThatCountryCanBeCreatedAndRecalled(){

        Country country= Country.builder()
                .id(1L)
                .name("India")
                .gdp(2256.59D)
                .build();

        countryDaoImpl.create(country);
        Optional<Country> result=countryDaoImpl.findOne(country.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(country);
    }

}
