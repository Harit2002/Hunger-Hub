package com.masai.Service;

import com.masai.Exception.FoodCartException;
import com.masai.Exception.ItemException;
import com.masai.Model.FoodCart;

public interface FoodCartService {
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws FoodCartException, ItemException;

	public FoodCart increaseQuantiity(Integer cartId, Integer itemId, Integer quantity)throws FoodCartException, ItemException;

	public FoodCart reduceQuantity(Integer cartId, Integer itemId,  Integer quantity) throws FoodCartException, ItemException;

	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException, ItemException;
	
	public FoodCart clearCart(Integer cartID) throws FoodCartException;
}
