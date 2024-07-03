package com.bozntouran.farmereshop.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class BrandCSV {
    @CsvBindByName(column = "brand")
    private String brand;
}
