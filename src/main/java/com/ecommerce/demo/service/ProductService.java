package com.ecommerce.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entity.Product;
import com.ecommerce.demo.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void reduceStock(Long productId, int quantity) {
        Product p = productRepository.findById(productId).orElse(null);
        if (p != null && p.getStock() >= quantity) {
            p.setStock(p.getStock() - quantity);
            productRepository.save(p);
        }
    }
}
