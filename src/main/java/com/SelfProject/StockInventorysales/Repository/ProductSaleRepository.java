package com.SelfProject.StockInventorysales.Repository;

import com.SelfProject.StockInventorysales.Entity.Productsale;
import com.SelfProject.StockInventorysales.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductSaleRepository extends JpaRepository<Productsale,Integer> {
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Productsale s WHERE s.billno = :id")
//    void deleteByBillno(int id);
}
