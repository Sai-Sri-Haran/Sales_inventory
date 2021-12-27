package com.SelfProject.StockInventorysales.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Creditsales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int creditsalesid;
    private  int billno;
    private String customername;
    private  int amount;
    private String date_of_buy;
    private String mobileno;
}
