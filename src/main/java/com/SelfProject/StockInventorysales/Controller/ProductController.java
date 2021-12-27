package com.SelfProject.StockInventorysales.Controller;

import com.SelfProject.StockInventorysales.Entity.Product;
import com.SelfProject.StockInventorysales.Service.Implementation.ProductService;
import com.SelfProject.StockInventorysales.Util.Quantityupdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    public ResponseEntity<?> addproduct(@RequestBody Product product) throws Exception{
        return new ResponseEntity<>(productService.createproduct(product), HttpStatus.OK);
    }
    @PostMapping("/updatestock")
    public ResponseEntity<?> updatequantity(@RequestBody Quantityupdate quantityupdate) throws Exception{
        return new ResponseEntity<>(productService.updateProduct(quantityupdate), HttpStatus.OK);
    }
    @GetMapping("/getbyproductid/{id}")
    public ResponseEntity<?> getproductbyid(@PathVariable int id) throws Exception{
        return new ResponseEntity<>(productService.getProductbyid(id), HttpStatus.OK);
    }
    @GetMapping("/getbyname/{product_name}")
    public ResponseEntity<Object> getproductbyname(@PathVariable String product_name ){
        return new ResponseEntity<>(productService.getProductbyname(product_name), HttpStatus.OK);
    }
}
