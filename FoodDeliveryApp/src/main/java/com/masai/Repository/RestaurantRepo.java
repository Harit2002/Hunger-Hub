package com.masai.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {
	
	List<Restaurant> findByItemList(Item item);
	
}
