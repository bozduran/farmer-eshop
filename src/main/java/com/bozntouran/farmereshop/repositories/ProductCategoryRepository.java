package com.bozntouran.farmereshop.repositories;


import com.bozntouran.farmereshop.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@CrossOrigin("http://localhost:4200/")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    ProductCategory getProductCategoryByProductCategoryName(String name);
}
