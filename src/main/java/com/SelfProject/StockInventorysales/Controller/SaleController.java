package com.SelfProject.StockInventorysales.Controller;

import com.SelfProject.StockInventorysales.Entity.Sales;
import com.SelfProject.StockInventorysales.Repository.SalesRepository;
import com.SelfProject.StockInventorysales.Service.Implementation.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SalesService salesService;

    @Autowired
    private SalesRepository salesRepository;

    public SaleController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/addsales")
    public ResponseEntity<Object> addSales(@RequestBody Sales sale){
        return  salesService.addsale(sale);
    }

    @GetMapping("/getbybillno/{billno}")
    public ResponseEntity<Object> getbybillno (@PathVariable(name = "billno")  int billno){
        return salesService.getbybillno(billno);
    }

    @DeleteMapping("/deletesales/{id}")
    public  ResponseEntity<Object> deletebyid(@PathVariable int id){

        return salesService.deletesales(id);
    }

    @GetMapping("/getbyname/{customername}")
    public  ResponseEntity<Object> getbyname(@PathVariable String customername){
        return  new ResponseEntity<>(salesService.getbyname(customername), HttpStatus.OK);
    }
}
