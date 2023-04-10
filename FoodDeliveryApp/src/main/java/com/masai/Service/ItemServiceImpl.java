package com.masai.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exception.CategoryException;
import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Category;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;
import com.masai.Repository.CategoryRepo;
import com.masai.Repository.ItemRepo;
import com.masai.Repository.RestaurantRepo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepo itemRepo;

	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public Item addItem(Item item, Integer resId) throws ItemException,RestaurantException {
		if (item == null)
			throw new ItemException("Please enter valid item details");
		
		Restaurant restaurant = restaurantRepo.findById(resId).orElseThrow(() -> new RestaurantException("Please enter valid restaurant id."));
		
		item.setRestaurant(restaurant);
		
		Item item1 = itemRepo.save(item);
		
		restaurant.getItemList().add(item1);
		
		return item1;
	}

	@Override
	public Item updateItem(Item item, Integer id) throws ItemException {
		itemRepo.findById(id).orElseThrow(() -> new ItemException("Please enter valid item details"));
		
		item.setItemId(id);
		
		return itemRepo.save(item);
	}

	@Override
	public Item removeItem(Integer id) throws ItemException {
		Item item = itemRepo.findById(id)
				.orElseThrow(() -> new ItemException("Please enter valid item details"));
		
		itemRepo.delete(item);
		return item;
	}

	@Override
	public List<Item> viewItemByCategory(Integer categoryId) throws ItemException, CategoryException {
		Category cat = categoryRepo.findById(categoryId)
				.orElseThrow(() -> new CategoryException("Please enter a valid category id."));
		
		List<Item> list = itemRepo.findByCategory(cat);
		
		if (list.isEmpty())
			throw new ItemException("No item exist with category " + cat.getCategoryName());
		
		return list;
	}

	@Override
	public List<Item> viewItemByRestaurant(Integer resId) throws ItemException, RestaurantException {
		Restaurant restaurant = restaurantRepo.findById(resId)
				.orElseThrow(() -> new RestaurantException("Please enter a valid restaurant id."));
		
		List<Item> list = itemRepo.findByRestaurant(restaurant);
		
		if (list.isEmpty())
			throw new ItemException("No item exist with restaurant name " + restaurant.getRestaurantName());
		
		return list;
	}

	@Override
	public List<Item> viewItemByName(String name) throws ItemException {
		List<Item> list = itemRepo.findByItemName(name);
		
		if (list.isEmpty())
			throw new ItemException("No item with name " + name + " exist.");
		
		return null;
	}

}
