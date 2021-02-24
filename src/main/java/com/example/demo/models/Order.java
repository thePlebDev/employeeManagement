package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="mainOrder")
@Table(name="mainOrder")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long customerId; // we can make this a one to one relationship;
	private String details;
	// need to put an arrayList here
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Item> item = new ArrayList<>();
	
	

	public Order( String details) {
		this.details = details;
	}
	public Order() {}
	
	public Long getId() {
		return id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public String getDetails() {
		return details;
	}
	
	// BELOW ARE THE SETTERS
	
	public void setDetails(String details) {
		this.details = details;
	}
	public void addItem(Item item) {
		this.item.add(item);
	}
	public void removeItem(Item item) {
		this.item.remove(item);
	}

	
	

	

}
