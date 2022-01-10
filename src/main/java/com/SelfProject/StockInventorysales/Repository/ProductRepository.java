package com.SelfProject.StockInventorysales.Repository;

import com.SelfProject.StockInventorysales.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductid(int productid);

//    Product findByProductName(String product_name);
}
