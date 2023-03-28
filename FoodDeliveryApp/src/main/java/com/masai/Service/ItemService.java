package com.masai.Service;

import java.util.List;

import javax.xml.catalog.CatalogException;

import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Category;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;

public interface ItemService {
	public Item addItem(Item item) throws ItemException;
	public Item updateItem(Item item, Integer id) throws ItemException;
	public Item removeItem(Integer id) throws ItemException;
	public List<Item> viewItemByCategory(Category category) throws ItemException, CatalogException;
	public List<Item> viewItemByRestaurant(Restaurant restaurant) throws ItemException,RestaurantException;
	public List<Item> viewItemByName(String name) throws ItemException;
	
}
