package com.example.demo.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Item;
import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.exception.ItemIsAlreadyAssignedException;
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
	@Transactional
	 public Order addItemToOrder(Long itemId,Long orderId) {
		 Item addedItem = itemService.getItem(itemId);
		 if(Objects.nonNull(addedItem.getOrder())) {
			 // this makes it impossible to steal an item and put it in another order
			 throw new ItemIsAlreadyAssignedException(itemId, addedItem.getOrder().getId());
		 }
		 Order orderToAdd = getOrder(orderId);
		 orderToAdd.addItem(addedItem);
		 return orderToAdd; 
	 }
	 
	 @Transactional
	 public Order editDetails(Long id, Order order) {
		 Order orderToEdit = getOrder(id);
		 orderToEdit.setDetails(order.getDetails());
		 return orderToEdit;
	 }
	 
	 @Transactional
	 public Order removeItemFromOrder(Long orderId, Long itemId) {
		 Item item = itemService.getItem(itemId);
		 Order order = getOrder(orderId);
		 order.removeItem(item);
		 return order;
		 
	 }
}
