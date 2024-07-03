package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.entity.Brand;
import com.bozntouran.farmereshop.mappers.BrandMapper;
import com.bozntouran.farmereshop.model.BrandDTO;
import com.bozntouran.farmereshop.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

    private BrandRepository brandRepository;
    private BrandMapper brandMapper;

    @Override
    public Boolean saveBrand(BrandDTO brandDTO) {
        brandRepository.save(brandMapper.brandDTOToBrand(brandDTO));
        return null;
    }

    @Override
    public Brand getBrandByBrandName(String name) {
        return brandRepository.getBrandByBrandName(name);
    }
}
