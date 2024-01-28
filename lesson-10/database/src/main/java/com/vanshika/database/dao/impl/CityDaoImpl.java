package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CityDao;
import com.vanshika.database.domain.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class CityDaoImpl implements CityDao {

    private final JdbcTemplate jdbcTemplate;


    public CityDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(City city) {
        jdbcTemplate.update("INSERT INTO city (id,name,country_id) VALUES(?,?,?)",city.getId(),city.getName(),city.getCountry_id());
    }

    @Override
    public Optional<City> findOne(long cityId) {
        List<City> results=jdbcTemplate.query(
                "SELECT id,name,country_id FROM city WHERE id=?",
                new CityRowMapper(),
                cityId
        );

        return results.stream().findFirst();
    }

    public static class CityRowMapper implements RowMapper<City>{

        @Override
        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
            return City.builder()
                    .id(rs.getLong("id"))
            .name(rs.getString("name"))
                    .country_id(rs.getLong("country_id"))
                    .build()
                    ;
        }
    }
}
