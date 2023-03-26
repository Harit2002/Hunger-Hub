package com.masai.Service;

import java.util.List;

import com.masai.Exception.RestaurantException;
import com.masai.Model.Restaurant;


public interface RestaurantService {
	public Restaurant addRestaurant(Restaurant res);
	public Restaurant updateRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant removeRestaurant(Restaurant res) throws RestaurantException;
	public Restaurant viewRestaurant(Integer id) throws RestaurantException;;
	public List<Restaurant> viewRestaurantByLocatoin(String location);
	public List<Restaurant> viewRestaurantByItem(String item);
}
