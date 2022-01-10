package com.SelfProject.StockInventorysales.Service.Implementation;

import com.SelfProject.StockInventorysales.Entity.Product;
import com.SelfProject.StockInventorysales.Repository.ProductRepository;
import com.SelfProject.StockInventorysales.Util.CustomResponse;
import com.SelfProject.StockInventorysales.Util.Quantityupdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService  {

    @Autowired
    private ProductRepository productRepository;

    public CustomResponse createproduct(Product product) throws Exception {
        Product sample= productRepository.findByProductid(product.getProductid());

        if (sample!=null){
            return  new CustomResponse(false,500,"Product with this Id ALready found",null);
        }
        productRepository.save(product);
        return  new CustomResponse(true,200,"Product saved Successfully",product);
    }


    public CustomResponse updateProduct(Quantityupdate quantityupdate) throws Exception {
        Product sample= productRepository.findByProductid(quantityupdate.getProductid());
        if (sample==null){
            return  new CustomResponse(false,500,"Product with this Id Not found",null);
        }
        sample.setStockquantity(sample.getStockquantity()+quantityupdate.getStockquantity());
        productRepository.save(sample);
        Product sample1= productRepository.findByProductid(quantityupdate.getProductid());
        return  new CustomResponse(true,200,"Updated Successfully",sample1);
    }


    public CustomResponse getProductbyid(int id) throws Exception {
        Product sample= productRepository.findByProductid(id);
        if (sample==null){
            return  new CustomResponse(false,500,"Product with this Id Not found",null);
        }
        return  new CustomResponse(true,200,"Updated Successfully",sample);
    }

//    public Object getProductbyname(String product_name) {
//
//        Product sample= productRepository.findByProductName(product_name);
//        if (sample==null){
//            return  new CustomResponse(false,500,"Product with this Name Not found",null);
//        }
//        return  new CustomResponse(true,200,"Updated Successfully",sample);
//    }
}
