package com.bozntouran.farmereshop.model;

import com.bozntouran.farmereshop.entity.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ProductCategory}
 */
@Data
@Builder
public class ProductCategoryDTO implements Serializable {

    private Long id;
    @NotNull
    @NotBlank
    private String productCategoryName;
}