package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.model.BrandCSV;
import com.bozntouran.farmereshop.model.ProductCategoryCSV;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
@Service
public class ProductCategoryCSVService {
    public List<ProductCategoryCSV> convertCSV(File file) {

        try {
            List<ProductCategoryCSV> productCategoryCSVList = new CsvToBeanBuilder<ProductCategoryCSV>(new FileReader(file))
                    .withType(ProductCategoryCSV.class)
                    .build()
                    .parse();
            return productCategoryCSVList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
