package com.bozntouran.farmereshop.services;

import com.bozntouran.farmereshop.model.BrandCSV;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class BrandCSVService {

        public List<BrandCSV> convertCSV(File file) {

            try {
                List<BrandCSV> brandCSVList = new CsvToBeanBuilder<BrandCSV>(new FileReader(file))
                        .withType(BrandCSV.class)
                        .build()
                        .parse();
                return brandCSVList;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

}
