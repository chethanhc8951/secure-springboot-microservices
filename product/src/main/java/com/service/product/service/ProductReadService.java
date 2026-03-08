package com.service.product.service;

import com.service.product.model.Product;

import java.util.List;

public interface ProductReadService {


    Product getProductById(Long id);

    List<Product> getAllProducts();
}
