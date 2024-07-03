package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.mappers.ProductMapper;
import com.bozntouran.farmereshop.model.ProductDTO;
import com.bozntouran.farmereshop.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Override
    public Boolean saveProduct(ProductDTO productDTO) {
        productRepository.save(
                productMapper.productDTOToProduct(productDTO));
        return null;
    }
}
