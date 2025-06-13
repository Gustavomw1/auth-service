package com.ecommerce.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entity.Pedidos;
import com.ecommerce.demo.entity.Product;
import com.ecommerce.demo.repository.PedidosRepository;
import com.ecommerce.demo.repository.ProductRepository;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProductRepository productRepository;

    public Pedidos fazerPedidos(Pedidos pedidos) {
        for (Product p : pedidos.getProducts()) {
            Product prod = productRepository.findById(p.getId()).orElse(null);
            if (prod != null && prod.getStock() > 0) {
                prod.setStock(prod.getStock() - 1);
                productRepository.save(prod);
            }
        }
        return pedidosRepository.save(pedidos);
    }
}
