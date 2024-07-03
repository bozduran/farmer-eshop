package com.bozntouran.farmereshop.mappers;

import com.bozntouran.farmereshop.entity.Brand;
import com.bozntouran.farmereshop.entity.Product;
import com.bozntouran.farmereshop.model.BrandDTO;
import com.bozntouran.farmereshop.model.ProductDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface BrandMapper {

    Brand brandDTOToBrand(BrandDTO brandDTO);
    BrandDTO branDTOBrandDTO(Brand brand);

    Set<Product> productDTOToProduct(Set<ProductDTO> productDTO);
    Set<ProductDTO> productToProductDTO(Set<Product> products);

}
