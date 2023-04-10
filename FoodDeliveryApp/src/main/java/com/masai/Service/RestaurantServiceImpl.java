package com.masai.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Item;
import com.masai.Model.Restaurant;
import com.masai.Repository.ItemRepo;
import com.masai.Repository.RestaurantRepo;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepo respo;
	
	@Autowired
	ItemRepo itemRepo;
	
	
	@Override
	public Restaurant addRestaurant(Restaurant res) throws RestaurantException {
		

		if(res==null) throw new RestaurantException("Please enter valid details");
		

		
		return respo.save(res);
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException {
		
		respo.findById(res.getResId()).orElseThrow(()->  new RestaurantException("Restaurent is not registered"));
		
		return respo.save(res);
	}

	@Override
	public String removeRestaurant(Integer resId) throws RestaurantException {
		
		Restaurant res = respo.findById(resId).orElseThrow(()->  new RestaurantException("Restaurent is not registered"));
		respo.delete(res);
		
		return "Restaurant "+res.getRestaurantName()+" has been deleted successfully";
	}

	@Override
	public Restaurant viewRestaurant(Integer id) throws RestaurantException {
			
		return respo.findById(id).orElseThrow(() -> new RestaurantException("Restaurant with id "+id+" does not exist."));
	}

	@Override
	public List<Restaurant> viewRestaurantByLocation(String location) throws RestaurantException {
		
		List<Restaurant> li = respo.findAll();
		
		List<Restaurant> list = li.stream().filter(el -> (el.getAddress() != null && el.getAddress().getArea().equalsIgnoreCase(location))).collect(Collectors.toList());		
		
		if(list.isEmpty()) throw new RestaurantException("No restaurant exist with this location.");
		
		return list;
	}

	@Override
	public Restaurant viewRestaurantByItem(Integer id) throws ItemException {
		
		Item item = itemRepo.findById(id).orElseThrow(() -> new ItemException("Item with id " + id + " does not exist."));
		
		Restaurant res = item.getRestaurant();
		
		if(res == null) throw new ItemException("This item is not registered with any restaurant.");
		
		return res;
	}

}
