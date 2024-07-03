package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.model.ProductCSV;
import com.bozntouran.farmereshop.model.ProductCategoryCSV;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class ProductCSVService {

        public List<ProductCSV> convertCSV(File file) {

            try {
                List<ProductCSV> productCSVList = new CsvToBeanBuilder<ProductCSV>(new FileReader(file))
                        .withType(ProductCSV.class)
                        .build()
                        .parse();
                return productCSVList;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

}
