package com.ecom.productcatalog.service;


//import src.test.java.com.ecommerce.productcatalogservice.Entity.Product;
//import src.test.java.com.ecommerce.productcatalogservice.Repository.ProductRepository;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepository;
//import com.ecommerce.ecommerceapipractice.model.Product;
//import com.ecommerce.ecommerceapipractice.repository.ProductRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductService {

    private final ProductRepository repository;
    public ProductService(ProductRepository repository) {     this.repository = repository;   }

    public Product createProduct(Product pro){
        return repository.save(pro);
    }

    public List<Product>  getProducts(){
        return repository.findAll();
    }

    public Product getProduct(Long id){
        Product Pro= repository.findById(id).orElseThrow(()->new RuntimeException("ID is not found"));
        return Pro;
    }

    public void updateProduct(Product product,Long id){
        Product oldPro=repository.findById(id).orElseThrow(()->new RuntimeException("Product is not found"));

        oldPro.setName(product.getName());
        oldPro.setDescription(product.getDescription());
        oldPro.setPrice(product.getPrice());
        oldPro.setStock(product.getStock());
        repository.save(oldPro);
    }

    public void removeProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}