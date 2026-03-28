package com.ecom.productcatalog.controller;

//import src.test.java.com.ecommerce.productcatalogservice.Entity.Product;
//import src.test.java.com.ecommerce.productcatalogservice.Service.ProductService;
//import com.ecommerce.productcatalog.model.Product;
//import com.ecommerce.productcatalog.service.ProductService;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;
    public ProductController(ProductService service) {    this.service = service;     }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        Product saved = service.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/all")
    public List<Product> displayProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    public Product displayProduct(@PathVariable Long id){
        return service.getProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@RequestBody Product product ,@PathVariable Long id) {
        service.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.removeProduct(id);
    }
}
