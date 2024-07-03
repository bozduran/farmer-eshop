package com.bozntouran.farmereshop.mappers;

import com.bozntouran.farmereshop.entity.Product;
import com.bozntouran.farmereshop.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO productToProductDTO(Product product);

}
