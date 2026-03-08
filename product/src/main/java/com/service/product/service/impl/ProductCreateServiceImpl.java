package com.service.product.service.impl;

import com.service.product.model.Product;
import com.service.product.repository.ProductRepository;
import com.service.product.service.ProductCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCreateServiceImpl implements ProductCreateService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);

    }
}