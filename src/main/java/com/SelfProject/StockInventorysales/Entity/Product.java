package com.SelfProject.StockInventorysales.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productid;
    private String product_name;
    private  int mrp;
    private  int cashprice;
    private int creditprice;
    private  String expirydate;
    private  int stockquantity;
}
