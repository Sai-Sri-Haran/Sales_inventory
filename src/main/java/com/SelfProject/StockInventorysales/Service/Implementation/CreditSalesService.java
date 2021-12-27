package com.SelfProject.StockInventorysales.Service.Implementation;

import com.SelfProject.StockInventorysales.Entity.Creditsales;
import com.SelfProject.StockInventorysales.Repository.CreditSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditSalesService {
    @Autowired
    private CreditSalesRepository creditSalesRepository;

    public List<Creditsales> findbyname(String customername) {
        List<Creditsales> creditsales = creditSalesRepository.findByCustomername(customername);
        return creditsales;
    }

    public int getamount(String customername) {
        List<Creditsales> creditsales = creditSalesRepository.findByCustomername(customername);
        int totalamount = 0;
        if (creditsales.size() > 0) {
            for (int i = 0; i < creditsales.size(); i++) {
                totalamount = totalamount + creditsales.get(i).getAmount();
            }
        }
        return totalamount;
    }
}
