package com.bozntouran.farmereshop.model;

import com.bozntouran.farmereshop.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@Builder
public class ProductDTO implements Serializable {
    private Long id;
    @NotNull
    @NotBlank
    private String productName;
    @NotNull
    private Double price;
    @NotNull
    private int stockQuantity;
    private ProductCategoryDTO category;
    private BrandDTO brand;
    private String imageUrl;


}