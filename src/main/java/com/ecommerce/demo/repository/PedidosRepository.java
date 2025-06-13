package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.demo.entity.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
