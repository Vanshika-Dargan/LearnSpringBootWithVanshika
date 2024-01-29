package com.vanshika.database.dao.impl;

import com.vanshika.database.dao.CountryDao;
import com.vanshika.database.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
public class CountryDaoImpl implements CountryDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryDaoImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Country country) {
        jdbcTemplate.update("INSERT INTO country (id,name,gdp) VALUES(?,?,?)",country.getId(),country.getName(),country.getGdp());
    }

    @Override
    public Optional<Country> findOne(long countryId) {
        List<Country> results=jdbcTemplate.query(
                "SELECT id,name,gdp FROM country WHERE id=? LIMIT 1",
                new CountryRowMapper(),
                countryId
        );
        return results.stream().findFirst();
    }

    @Override
    public List<Country> find() {
        return jdbcTemplate.query(
                "SELECT id,name,gdp FROM country",
                new CountryRowMapper()
        );

    }


    public static class CountryRowMapper implements RowMapper<Country>{

        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Country.builder()
                    .id(rs.getLong("id"))
                    .name(rs.getString("name"))
                    .gdp(rs.getDouble("gdp"))
                    .build();
        }
    }
}
