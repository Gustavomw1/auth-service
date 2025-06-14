package com.ecommerce.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.demo.entity.Pedidos;
import com.ecommerce.demo.entity.Product;
import com.ecommerce.demo.repository.PedidosRepository;
import com.ecommerce.demo.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProductRepository productRepository;

    public Pedidos fazerPedidos(Pedidos pedidos) {
        List<Product> produtosAtualizados = new ArrayList<>();

        for (Product p : pedidos.getProducts()) {
            Optional<Product> optProduto = productRepository.findById(p.getId());

            if (optProduto.isPresent()) {
                Product produto = optProduto.get();

                if (produto.getStock() > 0) {
                    produto.setStock(produto.getStock() - 1);
                    productRepository.save(produto);
                    produtosAtualizados.add(produto);
                } else {
                    throw new RuntimeException("Produto sem estoque: " + produto.getName());
                }

            } else {
                throw new RuntimeException("Produto não encontrado com ID: " + p.getId());
            }
        }

        pedidos.setProducts(produtosAtualizados);

        return pedidosRepository.save(pedidos);
    }
}
