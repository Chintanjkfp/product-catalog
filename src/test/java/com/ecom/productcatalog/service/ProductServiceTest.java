package com.ecom.productcatalog.service;

import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void createProduct_ShouldReturnSavedProduct() {
        Product input = new Product("Mouse", "RGB", new BigDecimal("25"), 10);
        when(repository.save(any(Product.class))).thenReturn(input);

        Product saved = service.createProduct(input);

        assertNotNull(saved);
        assertEquals("Mouse", saved.getName());
        verify(repository, times(1)).save(input);
    }

    @Test
    void getProducts_ShouldReturnList() {
        Product p1 = new Product("P1", "D1", BigDecimal.TEN, 1);
        Product p2 = new Product("P2", "D2", BigDecimal.TEN, 2);
        when(repository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<Product> result = service.getProducts();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void updateProduct_ShouldUpdateFields_WhenIdExists() {
        Product existing = new Product("Old Name", "Old Desc", BigDecimal.ONE, 1);
        Product updateInfo = new Product("New Name", "New Desc", BigDecimal.TEN, 10);

        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(Product.class))).thenReturn(existing);

        service.updateProduct(updateInfo, 1L);

        assertEquals("New Name", existing.getName());
        assertEquals("New Desc", existing.getDescription());
        verify(repository, times(1)).save(existing);
    }

    @Test
    void removeProduct_ShouldInvokeDelete() {
        doNothing().when(repository).deleteById(1L);

        service.removeProduct(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
