package com.vanshika.database.repositories;

import com.vanshika.database.domain.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country,Long> {

    Iterable<Country> gdpLessThan(Double val);

    @Query("SELECT c from Country c where c.gdp> ?1")
    Iterable<Country> findCountryWithGdpMoreThan(Double val);
}
