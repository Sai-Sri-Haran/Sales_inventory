package com.SelfProject.StockInventorysales.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private  int billno;
    private String customername;

    @OneToMany(targetEntity=Productsale.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="billno",referencedColumnName = "billno")
    private List<Productsale> productsales= new ArrayList<>();

    private  String mode_of_buy;
    private String date_of_buy;
    private int total_price;
    private  String mobileno;

    public Sales(String customername, String mode_of_buy, String date_of_buy) {
        this.customername = customername;
        this.mode_of_buy = mode_of_buy;
        this.date_of_buy = date_of_buy;
    }
}
