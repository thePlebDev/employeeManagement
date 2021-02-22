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


@Entity(name="order") // this is the name that we have to use for queries
@Table(name="order")// this is the name of our table in the database
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long customerId;
	
	@OneToMany(
			mappedBy="order",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Item> itemId = new ArrayList<>();
	
	
	private String details;
	private Status status;
	
	public Order( String details, Long itemId) {
		this.status = Status.PROCESSING;
		this.details = details;
	}
	
	public Long getId() {
		return id;
	}
	public Long getCustomerid() {
		return customerId;
	}
	public List<Item> getItemids() {
		return itemId;
	}
	public Status getStatus() {
		return status;
	}
	public String getDetails() {
		return details;
	}
	
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void addItem(Item itemId) {
		this.itemId.add(itemId);
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	

}
