package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.entity.ProductCategory;
import com.bozntouran.farmereshop.model.ProductCategoryDTO;

public interface ProductCategoryService {
    Boolean saveProductCategory(ProductCategoryDTO productCategoryDTO);
    ProductCategory getProductCategoryByName(String name);

}
