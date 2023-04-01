package com.masai.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.Model.Category;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

	public List<Item> findByCategory(Category category);

	public List<Item> findByItemName(String name);
	
	public List<Item> findByRestaurant(Restaurant restaurant);
	

}
