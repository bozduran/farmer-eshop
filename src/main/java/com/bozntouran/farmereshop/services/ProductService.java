package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.entity.Product;
import com.bozntouran.farmereshop.model.ProductDTO;

public interface ProductService {
    Boolean saveProduct(ProductDTO productDTO);
}
