package com.service.product.service.impl;

import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;
import com.service.product.service.ProductReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductReadServiceImpl implements ProductReadService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}