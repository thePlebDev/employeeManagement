package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Item;
import com.example.demo.models.Order;
import com.example.demo.models.Status;
import com.example.demo.repository.OrderRepository;
import com.example.demo.exception.OrderNotFoundException;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	private final ItemService itemService;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, ItemService itemService) {
		this.orderRepository = orderRepository;
		this.itemService = itemService;
	}
	
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	public Order getOrder(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(()-> new OrderNotFoundException(id));
	}
	public Order deleteOrder(Long id) {
		Order orderDelete = getOrder(id);
		orderRepository.delete(orderDelete);
		return orderDelete;
	}
	 public Order addItemToOrder(Long itemId,Long orderId) {
		 Item addedItem = itemService.getItem(itemId);
		 Order orderToAdd = getOrder(orderId);
		 orderToAdd.addItem(addedItem);
		 return orderToAdd; 
	 }
	 public Order editStatus(Long id, Order order) {
		 Order orderToEdit = getOrder(id);
		 orderToEdit.setDetails(order.getDetails());
		 return orderToEdit;
	 }
	 
	 public Order removeItemFromOrder(Long orderId, Long itemId) {
		 Item item = itemService.getItem(itemId);
		 Order order = getOrder(orderId);
		 order.removeItem(item);
		 return order;
		 
	 }
}
