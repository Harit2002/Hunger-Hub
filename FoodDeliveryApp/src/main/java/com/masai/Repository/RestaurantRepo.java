package com.masai.Repository;

import com.masai.Model.Item;
import com.masai.Model.Restaurant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	
	List<Restaurant> findByItemList(Item item);
	
}
