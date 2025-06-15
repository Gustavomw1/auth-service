package com.ecommerce.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}