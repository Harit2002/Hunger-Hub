package com.masai.Service;

import java.util.List;

import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Restaurant;


public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant res)throws  RestaurantException;
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException;
	public String removeRestaurant(Integer resId) throws RestaurantException;
	public Restaurant viewRestaurant(Integer id) throws RestaurantException;
	public List<Restaurant> viewRestaurantByLocation(String location) throws RestaurantException;

	public Restaurant viewRestaurantByItem(Integer itemId) throws ItemException;

}
