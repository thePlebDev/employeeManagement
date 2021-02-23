package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Item;
import com.example.demo.services.ItemService;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
	
	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public Item createItem(@RequestBody Item item) {
		return itemService.addItem(item);
	}
	@GetMapping
	public List<Item> getItems(){
		return itemService.getItems();
	}
	@GetMapping(value="{id}")
	public Item getItem(@PathVariable final Long id) {
		return itemService.getItem(id);
		
	}
	@DeleteMapping(value="{id")
	public Item deleteItem(@PathVariable final Long id) {
		return itemService.deleteItem(id);
	}
	@PutMapping(value="{id}")
	public Item editItem(@PathVariable final Long id,
						 @RequestBody final Item item) {
		return itemService.editItem(item, id);
	}

}
