package com.bozntouran.farmereshop.bootstrap;

import com.bozntouran.farmereshop.entity.Brand;
import com.bozntouran.farmereshop.entity.Product;
import com.bozntouran.farmereshop.entity.ProductCategory;
import com.bozntouran.farmereshop.model.BrandCSV;
import com.bozntouran.farmereshop.model.ProductCSV;
import com.bozntouran.farmereshop.model.ProductCategoryCSV;
import com.bozntouran.farmereshop.repositories.BrandRepository;
import com.bozntouran.farmereshop.repositories.ProductCategoryRepository;
import com.bozntouran.farmereshop.repositories.ProductRepository;
import com.bozntouran.farmereshop.services.BrandCSVService;
import com.bozntouran.farmereshop.services.ProductCSVService;
import com.bozntouran.farmereshop.services.ProductCategoryCSVService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
public class BootstrapData implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final BrandRepository brandRepository;

    private final ProductCategoryCSVService categoryCSVService;
    private final BrandCSVService brandCSVService;
    private final ProductCategoryCSVService productCategoryCSVService;
    private final ProductCSVService productCSVService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Data bootstrapping.");

        if(productCategoryRepository.count() == 0)
            loadProductCategoryDataFromCsv();
        if(brandRepository.count() == 0)
            loadBrandDataFromCsv();
        if (productRepository.count() == 0)
            loadProductDataFromCsv();

        log.info("Data bootstrapping end.");

    }

    @Transactional
    public void loadBrandDataFromCsv() {
        File brandCSVFile = null;
        try {
            brandCSVFile = ResourceUtils.getFile("classpath:csvdata/brand.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<BrandCSV> brandCSVList = brandCSVService.convertCSV(brandCSVFile);

        for (BrandCSV brandCSV : brandCSVList) {
            brandRepository.save(Brand
                    .builder()
                            .brandName(brandCSV.getBrand())
                    .build());

        }
    }

    @Transactional
    public void loadProductCategoryDataFromCsv() {
        File productCategoryCSVFile = null;
        try {
            productCategoryCSVFile = ResourceUtils.getFile("classpath:csvdata/category.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<ProductCategoryCSV> productCategoryCSVList = productCategoryCSVService.convertCSV(productCategoryCSVFile);

        for (ProductCategoryCSV productCategoryCSV : productCategoryCSVList) {
            productCategoryRepository.save(ProductCategory
                    .builder()
                            .productCategoryName(productCategoryCSV.getCategoryName())
                    .build());

        }

    }

    @Transactional
    public void loadProductDataFromCsv() {
        File productCSVFile = null;
        try {
            productCSVFile = ResourceUtils.getFile("classpath:csvdata/products.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<ProductCSV> productCSVList = productCSVService.convertCSV(productCSVFile);

        for (ProductCSV productCSV : productCSVList) {

            productRepository.save(Product
                    .builder()
                    .productName(productCSV.getProductName())
                    .price(productCSV.getPrice())
                            .description(productCSV.getBrand() + " " +
                                    productCSV.getProductName() +" "+
                                    productCSV.getCategory() +" "+
                                    productCSV.getPrice())
                    .stockQuantity(productCSV.getStockQuantity())
                    .imageUrl("/assets/images/products/"+productCSV.getImage())
                            .brand(brandRepository.getBrandByBrandName(productCSV.getBrand()) )
                            .category(productCategoryRepository.getProductCategoryByProductCategoryName(productCSV.getCategory()))
                    .build());

        }
    }
}
