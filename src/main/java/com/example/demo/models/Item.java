package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Item")
@Table(name="item")
public class Item {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id")
	private Order order;

}
