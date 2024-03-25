package com.vijay.orderservice.Repository;

import com.vijay.orderservice.Model.Order;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
