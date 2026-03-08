package com.service.product.service;

import com.service.product.model.Product;
import jakarta.validation.Valid;

public interface ProductCreateService {


    Product createProduct(@Valid Product product);
}
