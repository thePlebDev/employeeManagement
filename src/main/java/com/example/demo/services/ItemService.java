package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ItemNotFoundException;
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
				.orElseThrow(()->new ItemNotFoundException(id) );
	}
	public Item deleteItem(Long id) {
		Item item = getItem(id);
		itemRepository.delete(item);
		return item;
	}
	
	@Transactional
	public Item editItem(Item item,Long id) {
		Item itemToEdit = getItem(id);
		itemToEdit.setName(item.getName());
		return itemToEdit;
	}

}
