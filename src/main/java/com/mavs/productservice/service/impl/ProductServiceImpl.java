package com.mavs.productservice.service.impl;

import com.google.common.collect.Lists;
import com.mavs.productservice.model.Product;
import com.mavs.productservice.repository.ProductRepository;
import com.mavs.productservice.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.findById(product.getId()).ifPresent(dbProduct -> {
            BeanUtils.copyProperties(product, dbProduct);
            productRepository.save(dbProduct);
        });
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
