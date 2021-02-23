package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Item;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {
	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public Item addItem(Item item) {
		return itemRepository.save(item);
	}
	public List<Item> getItems(){
		return itemRepository.findAll();
	}
	public Item getItem(Long id) {
		return itemRepository.findById(id)
				.orElseThrow(()-> )
	}

}
