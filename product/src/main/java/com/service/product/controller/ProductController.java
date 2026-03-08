package com.service.product.controller;

import com.service.product.model.Product;
import com.service.product.service.ProductCreateService;
import com.service.product.service.ProductDeleteService;
import com.service.product.service.ProductReadService;
import com.service.product.service.ProductUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller named {@link ProductController} for managing products.
 * Provides endpoints to create, read, update, and delete products.
 */
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductCreateService productCreateService;
    private final ProductReadService productReadService;
    private final ProductUpdateService productUpdateService;
    private final ProductDeleteService productDeleteService;


    /**
     * Create a new product
     */
    @PostMapping
  //  @PreAuthorize("hasRole('ADMIN')")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productCreateService.createProduct(product);
    }

    /**
     * Get product by ID
     */
    @GetMapping("/{id}")
   // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product getProductById(@PathVariable Long id) {
        return productReadService.getProductById(id);
    }

    /**
     * Get all products
     */
    @GetMapping
   // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Product> getAllProducts() {
        return productReadService.getAllProducts();
    }

    /**
     * Update product
     */
    @PutMapping("/{id}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody Product product) {
        return productUpdateService.updateProduct(id, product);
    }

    /**
     * Delete product
     */
    @DeleteMapping("/{id}")
  //  @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        productDeleteService.deleteProduct(id);
    }



}