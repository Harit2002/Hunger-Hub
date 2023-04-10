package com.masai.Service;

import java.util.List;

import com.masai.Exception.CategoryException;
import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Item;

public interface ItemService {
	public Item addItem(Item item, Integer resId) throws ItemException,RestaurantException;
	public Item updateItem(Item item, Integer id) throws ItemException;
	public Item removeItem(Integer id) throws ItemException;
	public List<Item> viewItemByCategory(Integer id) throws ItemException, CategoryException;
	public List<Item> viewItemByRestaurant(Integer id) throws ItemException,RestaurantException;
	public List<Item> viewItemByName(String name) throws ItemException;
	
}
