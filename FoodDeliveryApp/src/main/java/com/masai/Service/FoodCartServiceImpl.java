package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.Exception.FoodCartException;
import com.masai.Exception.ItemException;
import com.masai.Model.FoodCart;
import com.masai.Model.Item;
import com.masai.Model.ItemQuantity;
import com.masai.Repository.FoodCartRepo;
import com.masai.Repository.ItemQuantityRepository;
import com.masai.Repository.ItemRepo;

@Service
public class FoodCartServiceImpl implements FoodCartService{

	@Autowired
	FoodCartRepo cartRepo;

	@Autowired
	ItemRepo itemRepo;
	
	@Autowired
	ItemQuantityRepository quantityRepository;

	@Override
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws FoodCartException, ItemException {
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Cart with id "+cartId));
		
		Item item1  = itemRepo.findById(itemId).orElseThrow(() -> new ItemException("Item does not exist in your cart."));
		
		ItemQuantity item = new ItemQuantity();
		item.setItem(item1);
		item.setQuantity(1);
		
		quantityRepository.save(item);
		
		cart.getItemList().add(item);
		
		cartRepo.save(cart);
		
		return cart;
	}

	@Override
	public FoodCart increaseQuantiity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Cart with id "+cartId));
		
		boolean flag = false;
		
		for(ItemQuantity quan : cart.getItemList()) {
			if(quan.getItem().getItemId() == itemId) {
				flag = true;
				quan.setQuantity(quan.getQuantity() + quantity);
				break;
			}
		}
		
		if(!flag) throw new ItemException("Item does not exist in your cart please add it first.");
		
		return cartRepo.save(cart);
	}

	@Override
	public FoodCart reduceQuantity(Integer cartId, Integer itemId, Integer quantity) throws FoodCartException, ItemException {
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Cart with id "+cartId));
		
		boolean flag = false;
		
		for(ItemQuantity quan : cart.getItemList()) {
			if(quan.getItem().getItemId() == itemId) {
				flag = true;
				int n = quan.getQuantity() + quantity;
				if(n < 0) n = 0;
				quan.setQuantity(n);
				break;
			}
		}
		
		if(!flag) throw new ItemException("Item does not exist in your cart please add it first.");
		
		return cartRepo.save(cart);

	}

	@Override
	public FoodCart removeItem(Integer cartId, Integer itemId) throws FoodCartException, ItemException {
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Invalid cart id."));
		
		ItemQuantity item = quantityRepository.findById(itemId).orElseThrow(() -> new ItemException("Item does not exist in your cart please add it first."));
	
		cart.getItemList().remove(item);
		
		quantityRepository.delete(item);
		
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
