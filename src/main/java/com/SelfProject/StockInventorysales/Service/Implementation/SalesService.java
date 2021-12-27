package com.SelfProject.StockInventorysales.Service.Implementation;

import com.SelfProject.StockInventorysales.Entity.Creditsales;
import com.SelfProject.StockInventorysales.Entity.Productsale;
import com.SelfProject.StockInventorysales.Entity.Sales;
import com.SelfProject.StockInventorysales.Repository.CreditSalesRepository;
import com.SelfProject.StockInventorysales.Repository.ProductSaleRepository;
import com.SelfProject.StockInventorysales.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SalesService {

    @Autowired
    private final SalesRepository salesRepository;

    @Autowired
    private  CreditSalesRepository creditSalesRepository;

    @Autowired
    private final ProductSaleRepository productSaleRepository;

    public SalesService(SalesRepository salesRepository, ProductSaleRepository productSaleRepository) {
        this.salesRepository = salesRepository;
        this.productSaleRepository = productSaleRepository;
    }

    @Transactional
    public ResponseEntity<Object> addsale(Sales sales) {
        Productsale s1=new Productsale();
        String str=sales.getMode_of_buy().toUpperCase();
        System.out.println("into service");
        int temp = 0;
        for (int i = 0; i < sales.getProductsales().size(); i++) {
            temp = temp + sales.getProductsales().get(i).getQuantity() * sales.getProductsales().get(i).getPrice();
        }
        System.out.println(temp);
        sales.setTotal_price(temp);
        System.out.println(sales);
        Sales tempsale = salesRepository.findByBillno(sales.getBillno());
        if(tempsale==null){
            Sales save = salesRepository.save(sales);
        if(str.equals("CREDIT")){
            Creditsales creditsales=new Creditsales();
            creditsales.setCustomername(save.getCustomername());
            creditsales.setBillno(save.getBillno());
            creditsales.setDate_of_buy(save.getDate_of_buy());
            creditsales.setAmount(save.getTotal_price());
            creditsales.setMobileno(save.getMobileno());
            creditSalesRepository.save(creditsales);
        }
        }
        Sales tempsales = salesRepository.findByBillno(sales.getBillno());
        if (tempsales != null) {
            return ResponseEntity.accepted().body("Saved Successfully");
        } else return ResponseEntity.unprocessableEntity().body("Failed to Save");
    }

    @Transactional
    public ResponseEntity<Object> deletesales(int id) {
        System.out.println("into sales delete sales");
        Sales sale=salesRepository.findByBillno(id);
        System.out.println(sale.toString());
        if(sale != null){
            salesRepository.deleteByBillno(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Deletion is not successfull", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Object> getbybillno(int billno) {
        Sales tempsales = salesRepository.findByBillno(billno);
        if(tempsales==null){
            return new ResponseEntity<>("Not found ", HttpStatus.NOT_FOUND);
        }
        else{
            return  new ResponseEntity<>(tempsales,HttpStatus.OK);
        }
    }

    public Object getbyname(String customername) {
        List<Sales> saleslist=salesRepository.findAllByCustomername(customername);
        return saleslist;
    }
}
