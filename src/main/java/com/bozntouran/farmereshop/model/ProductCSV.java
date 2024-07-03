package com.bozntouran.farmereshop.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class ProductCSV {
    @CsvBindByName(column = "name")
    private String productName;
    @CsvBindByName(column = "price")
    private Double price;
    @CsvBindByName(column="brand")
    private String brand;
    @CsvBindByName(column = "category")
    private String category;
    @CsvBindByName(column = "image")
    private String image;
    @CsvBindByName(column = "stock_quantity")
    private int stockQuantity ;

}
