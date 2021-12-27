package com.SelfProject.StockInventorysales.Controller;

import com.SelfProject.StockInventorysales.Service.Implementation.CreditSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditSalesController {

    @Autowired
    private CreditSalesService creditSalesService;

    @GetMapping("/getbyname/{customername}")
    public ResponseEntity<Object> getbyname(@PathVariable String customername){
        return  new ResponseEntity<>(creditSalesService.findbyname(customername), HttpStatus.OK);
    }
    @GetMapping("/getamount/{customername}")
    public ResponseEntity <Object> postamount(@PathVariable String customername){
        return  new ResponseEntity<>(creditSalesService.getamount(customername), HttpStatus.OK);
    }
}
