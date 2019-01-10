package com.mavs.productservice.service;

import com.mavs.productservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAll();

    Optional<Product> getById(Integer id);

    Product save(Product product);

    void update(Product product);

    void deleteById(Integer id);

}
