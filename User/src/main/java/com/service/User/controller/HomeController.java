package com.service.User.controller;


import com.service.User.Product;
import com.service.User.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class HomeController {

    private final ProductClient productClient;

    public HomeController(ProductClient productClient) {
        this.productClient = productClient;
    }

//    product Service

    // Create Product
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product createProduct(@RequestBody Product product) {
        return productClient.createProduct(product);
    }

    // Get Product By id
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product getProductById(@PathVariable Long id) {
        return productClient.getProductById(id);
    }

    // Get All Products
    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Product> getAllProducts() {
        return productClient.getAllProducts();
    }

    // Update Product
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productClient.updateProduct(id, product);
    }

    // Delete Product
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteProduct(@PathVariable Long id) {
        productClient.deleteProduct(id);
    }

//    ------------------------

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }
}
