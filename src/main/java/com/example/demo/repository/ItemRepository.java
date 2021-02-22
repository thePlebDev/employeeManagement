package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	
}
