package com.bozntouran.farmereshop.mappers;

import com.bozntouran.farmereshop.entity.ProductCategory;
import com.bozntouran.farmereshop.model.ProductCategoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductCategoryMapper {
    ProductCategoryDTO productCategoryToProductCategoryDTO(ProductCategory productCategory);
    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);

}
