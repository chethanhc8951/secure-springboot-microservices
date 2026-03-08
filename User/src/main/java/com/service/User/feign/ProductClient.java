package com.service.User.feign;

import com.service.User.Product;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {


    @PostMapping("/api/v1/products")
    //   @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product createProduct(@Valid @RequestBody Product product);


    @GetMapping("/api/v1/products/{id}")
    //  @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product getProductById(@PathVariable Long id);

    @GetMapping("/api/v1/products")
    //  @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<Product> getAllProducts();


    @PutMapping("/api/v1/products/{id}")
    //   @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product);


    @DeleteMapping("/api/v1/products/{id}")
    // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public void deleteProduct(@PathVariable Long id);


}
