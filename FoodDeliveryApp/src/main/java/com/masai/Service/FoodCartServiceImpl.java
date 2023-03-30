package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exception.FoodCartException;
import com.masai.Exception.ItemException;
import com.masai.Model.FoodCart;
import com.masai.Model.Item;
import com.masai.Repository.FoodCartRepo;
import com.masai.Repository.ItemRepo;

@Service
public class FoodCartServiceImpl implements FoodCartService{

	@Autowired
	FoodCartRepo cartRepo;

	@Autowired
	ItemRepo itemRepo;

	@Override
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart increaseQuantiity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		
		
		return null;

	}

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException, ItemException {
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Invalid cart id."));

		Item item = itemRepo.findById(itemId).orElseThrow(() -> new ItemException("Invalid cart id."));

		cart.getItemList().remove(item);

		cartRepo.save(cart);

		return cart;
	}

	@Override
	public FoodCart clearCart(Integer cartID) throws FoodCartException {
		FoodCart cart = cartRepo.findById(cartID).orElseThrow(() -> new FoodCartException("Invalid cart id."));

		cart.getItemList().clear();

		cartRepo.save(cart);

		return cart;
	}

}
