package com.bozntouran.farmereshop.repositories;

import com.bozntouran.farmereshop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200/")
@RepositoryRestResource(collectionResourceRel = "countries")
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
