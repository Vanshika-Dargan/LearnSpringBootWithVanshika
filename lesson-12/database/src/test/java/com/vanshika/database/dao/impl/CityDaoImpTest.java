package com.vanshika.database.dao.impl;

import com.vanshika.database.TestDataUtil;
import com.vanshika.database.dao.CityDao;
import com.vanshika.database.domain.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CityDaoImpTest {


    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CityDaoImpl cityDaoImpl;

    @Test
    public void testthatCreateCityMethodGeneratesValidSql(){
        City city= City.builder()
                .id(1L)
                .name("Mumbai")
                .country_id(1L)
                .build();

        cityDaoImpl.create(city);

        verify(jdbcTemplate).update(
                eq("INSERT INTO city (id,name,country_id) VALUES(?,?,?)"),
                        eq(1L),eq("Mumbai"),eq(1L)
        );

    }

    @Test
    public void testthatFindOneCityGeneratesValidSql(){
        cityDaoImpl.findOne(1L);

        jdbcTemplate.query(
                eq("SELECT id,name,country_id FROM city WHERE id=?"),
                ArgumentMatchers.<CityDaoImpl.CityRowMapper>any(),
                eq("1L")
        );

    }

    @Test
    public void testThatFindManyCitiesGeneratesValidSql(){
        cityDaoImpl.find();

        verify(jdbcTemplate).query(
                eq("SELECT id,name,country_id FROM city"),
                ArgumentMatchers.<CityDaoImpl.CityRowMapper>any()
        );
    }

    @Test
    public void testThatUpdateCityGeneratesValidSql(){
        City city= TestDataUtil.createTestCityD();
        cityDaoImpl.update(2L,city);

        verify(jdbcTemplate).update(
                eq("UPDATE city SET id=?,name=?,country_id=? WHERE id=?"),
                eq(4L),eq("Lucknow"),eq(1L),eq(2L)

        );

    }
}
