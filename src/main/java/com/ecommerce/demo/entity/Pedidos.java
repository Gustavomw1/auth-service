package com.ecommerce.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")

public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    private List<Product> products;
}
