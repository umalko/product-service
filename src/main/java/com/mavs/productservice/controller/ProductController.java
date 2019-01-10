package com.mavs.productservice.controller;

import com.mavs.productservice.model.Product;
import com.mavs.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@Value("id") Integer id) {
        return productService.getById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@Value("id") Integer id) {
        productService.deleteById(id);
    }
}
