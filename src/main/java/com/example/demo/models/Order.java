package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name="peanut")
@Table(name="peanut")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long customerId; // we can make this a one to one relationship;
	private String details;
	private Status status;
	// need to put an arrayList here
	@OneToMany(
			mappedBy="order",
			cascade=CascadeType.ALL,
			orphanRemoval = true
			)
	
	private List<Item> item = new ArrayList<>();
	
	

	public Order( String details, Long itemId) {
		this.status = Status.PROCESSING;
		this.details = details;
	}
	
	public Long getId() {
		return id;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public String getDetails() {
		return details;
	}
	public Status getStatus() {
		return status;
	}
	
	// BELOW ARE THE SETTERS
	
	public void setDetails(String details) {
		this.details = details;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void addItem(Item item) {
		this.item.add(item);
	}
	public void removeItem(Item item) {
		this.item.remove(item);
	}

	
	

	

}
