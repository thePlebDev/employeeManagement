package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Order;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	
	private final OrderService orderService;
	
	@Autowired
	OrderController(OrderService orderService){
		this.orderService = orderService;
	}
	
	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
	
	@GetMapping
	public List<Order> getOrders(){
		return orderService.getAllOrders();
	}
	@GetMapping(value="{id}")
	public Order getOrder(@PathVariable final Long id ) {
		return orderService.getOrder(id);
	}
	@DeleteMapping(value = "{id}")
	public Order deleteOrder(@PathVariable final Long id) {
		return orderService.deleteOrder(id);
	}
	@PutMapping(value="{id}")
	public Order editOrder(@PathVariable final Long id,
							@RequestBody final Order order) {
		return orderService.editDetails(id, order);
	}
	@PostMapping(value="{orderId}/{itemId}/add")
	public Order addItemToOrder(@PathVariable final Long orderId,
								@PathVariable final Long itemId) {
		return orderService.addItemToOrder(itemId, orderId);
		
	}
	@DeleteMapping(value="{orderId}/items/{itemId}/remove")
	public Order removeItemFromOrder(@PathVariable final Long orderId,
									 @PathVariable final Long itemId) {
		return orderService.removeItemFromOrder(orderId, itemId);
	}
										
}
