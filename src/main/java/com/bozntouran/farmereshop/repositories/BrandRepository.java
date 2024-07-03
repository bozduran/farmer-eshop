package com.bozntouran.farmereshop.repositories;

import com.bozntouran.farmereshop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200/")
public interface BrandRepository extends JpaRepository<Brand, Long> {
    Brand getBrandByBrandName(String name);
}
