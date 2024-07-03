package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.entity.ProductCategory;
import com.bozntouran.farmereshop.mappers.ProductCategoryMapper;
import com.bozntouran.farmereshop.model.ProductCategoryDTO;
import com.bozntouran.farmereshop.repositories.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public Boolean saveProductCategory(ProductCategoryDTO productCategoryDTO) {
        productCategoryRepository.save(
                productCategoryMapper.productCategoryDTOToProductCategory
                        (productCategoryDTO));
        return null;
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryRepository.getProductCategoryByProductCategoryName(name);
    }
}
