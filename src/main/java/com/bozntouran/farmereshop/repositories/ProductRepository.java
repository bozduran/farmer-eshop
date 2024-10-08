package com.bozntouran.farmereshop.repositories;

import com.bozntouran.farmereshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200/")
public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByCategoryId(@Param("id") Long categoryId, Pageable pageable);
    Page<Product> findProductByProductNameContaining(@Param("productName") String productName, Pageable pageable);

}
