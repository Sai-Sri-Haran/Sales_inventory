package com.SelfProject.StockInventorysales;


import com.SelfProject.StockInventorysales.Repository.ProductSaleRepository;
import com.SelfProject.StockInventorysales.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockInventorySalesApplication {
    @Autowired
    private ProductSaleRepository productSaleRepository;
    @Autowired
    private SalesRepository salesRepository;

    public static void main(String[] args) {
        SpringApplication.run(StockInventorySalesApplication.class, args);
    }

//    public void run(String... args) throws Exception {
//        Sales sale = new Sales("saisriharan", "cash", "31/05/2001");
//        Productsale productsale = new Productsale(1, "2,4,D", 5, 150, sale);
//        Productsale productsale1 = new Productsale(2, "Atregen", 2, 175, sale);
//        ArrayList<Productsale> arrayList = new ArrayList<>();
//        arrayList.add(productsale);
//        arrayList.add(productsale1);
//        sale.setTotal_price((productsale.getPrice() * productsale.getQuantity() + productsale1.getQuantity() * productsale1.getPrice()));
//		salesRepository.save(sale);
//		productSaleRepository.save(productsale);
//		productSaleRepository.save(productsale1);
//		System.out.println("saved");
//		Sales sale2 = new Sales("Rahul", "Credit", "31/05/2001");
//		Productsale productsale2 = new Productsale(10, "Lacer", 2, 1500, sale2);
//		Productsale productsale12 = new Productsale(11, "Corogen", 2, 1750, sale2);
//		ArrayList<Productsale> arrayList2 = new ArrayList<>();
//		arrayList2.add(productsale2);
//		arrayList2.add(productsale12);
//		sale2.setTotal_price((productsale2.getPrice() * productsale2.getQuantity() + productsale12.getQuantity() * productsale12.getPrice()));
//		salesRepository.save(sale2);
//		productSaleRepository.save(productsale2);
//		productSaleRepository.save(productsale12);
//		System.out.println("saved");
//    }

}

