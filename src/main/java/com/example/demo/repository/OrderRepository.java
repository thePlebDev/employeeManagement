package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	// I need to make queries to peanut because that is what I set the name to

}
