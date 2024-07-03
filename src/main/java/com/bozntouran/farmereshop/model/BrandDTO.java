package com.bozntouran.farmereshop.model;

import com.bozntouran.farmereshop.entity.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Brand}
 */

@Data
@Builder
public class BrandDTO implements Serializable {

    private Long id;
    @NotNull
    @NotBlank
    private String brandName;

    private Set<ProductDTO> products;
}