package com.bozntouran.farmereshop.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class ProductCategoryCSV {
    @CsvBindByName(column = "category")
    private String categoryName;
}
