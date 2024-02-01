package com.vanshika.database;

import com.vanshika.database.domain.City;
import com.vanshika.database.domain.Country;

public class TestDataUtil {
    public static Country createTestCountryA() {
        return Country.builder()
                .id(1L)
                .name("India")
                .gdp(2256.59D)
                .build();
    }
    public static Country createTestCountryB() {
        return Country.builder()
                .id(2L)
                .name("Germany")
                .gdp(51203.55D)
                .build();
    }
    public static Country createTestCountryC() {
        return Country.builder()
                .id(3L)
                .name("China")
                .gdp(12556.33D)
                .build();
    }

    public static Country createTestCountryD() {
        return Country.builder()
                .id(4L)
                .name("Egypt")
                .gdp(3700.13D)
                .build();
    }

    public static City createTestCityC(final Country country) {
        return City.builder()
                .id(3L)
                .name("Delhi")
                .country(country)
                .build();
    }

    public static City createTestCityB(final Country country) {
        return City.builder()
                .id(2L)
                .name("Kolkata")
                .country(country)
                .build();
    }

    public static City createTestCityA(final Country country) {
        return City.builder()
                .id(1L)
                .name("Mumbai")
                .country(country)
                .build();
    }
    public static City createTestCityD(final Country country) {
        return City.builder()
                .id(4L)
                .name("Lucknow")
                .country(country)
                .build();
    }
}
