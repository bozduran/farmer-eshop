package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.entity.Brand;
import com.bozntouran.farmereshop.model.BrandDTO;

public interface BrandService {
    Boolean saveBrand(BrandDTO brandDTO);
    Brand getBrandByBrandName(String name);
}
