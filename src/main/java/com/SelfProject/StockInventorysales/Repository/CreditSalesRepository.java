package com.SelfProject.StockInventorysales.Repository;

import com.SelfProject.StockInventorysales.Entity.Creditsales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditSalesRepository extends JpaRepository<Creditsales,Integer> {
    List<Creditsales> findByCustomername(String customername);
}
