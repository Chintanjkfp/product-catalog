package com.ecom.productcatalog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 200)
    @NotBlank(message = "name is required")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @NotNull(message = "price is required")
    @PositiveOrZero(message = "price must be 0 or greater")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @NotNull(message = "stock is required")
    @Min(value = 0, message = "stock must be 0 or greater")
    @Column(nullable = false)
    private Integer stock=0;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    public Product(String name, String description, BigDecimal price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product() {}

    public Long getId() {   return id;  }
    public String getName() {   return name;    }
    public String getDescription() {    return description; }
    public BigDecimal getPrice() {  return price;   }
    public Integer getStock() {     return stock;   }
    public OffsetDateTime getCreatedAt() {  return createdAt;   }

    public void setName(String name) {  this.name = name;   }
    public void setDescription(String description) {    this.description = description; }
    public void setPrice(BigDecimal price) {    this.price = price; }
    public void setStock(Integer stock) {   this.stock = stock; }

}
