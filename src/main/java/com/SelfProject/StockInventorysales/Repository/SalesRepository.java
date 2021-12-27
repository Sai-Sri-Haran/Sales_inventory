package com.SelfProject.StockInventorysales.Repository;

import com.SelfProject.StockInventorysales.Entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {
    Sales findByBillno(int billno);


    void deleteByBillno(int id);

    List<Sales> findAllByCustomername(String customername);
}
