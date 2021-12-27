package com.SelfProject.StockInventorysales.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor

public class Productsale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int productid;
    private String product_name;
    private int quantity;
    private  int price;

    public Productsale(){
    }

    public Productsale(int productid, String product_name, int quantity, int price) {
        this.productid = productid;
        this.product_name = product_name;
        this.quantity = quantity;
        this.price = price;
    }
}
