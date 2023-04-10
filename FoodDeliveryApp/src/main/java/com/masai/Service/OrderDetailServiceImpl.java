package com.masai.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.FoodCartException;
import com.masai.Exception.OrderDetailsException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.FoodCart;
import com.masai.Model.OrderDetails;
import com.masai.Model.User;
import com.masai.Repository.FoodCartRepo;
import com.masai.Repository.OrderDetailRepo;
import com.masai.Repository.RestaurantRepo;
import com.masai.Repository.UserRepo;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepo orderRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	FoodCartRepo cartRepo;
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public OrderDetails addOrder(OrderDetails orderDetails, Integer cartId) throws OrderDetailsException, FoodCartException {

		if (orderDetails == null)
			throw new OrderDetailsException("Please enter valid order details.");
		
		FoodCart cart = cartRepo.findById(cartId).orElseThrow(() -> new FoodCartException("Please enter valid cart id."));
		
		orderDetails.setFoodCart(cart);
		orderDetails.getItemList().addAll(cart.getItemList());
		
		cart.getItemList().clear();
		
		orderRepo.save(orderDetails);
		
		orderDetails.getItemList().forEach(el -> el.setOrder(orderDetails));
		
		orderRepo.save(orderDetails);
		
		cartRepo.save(cart);

		return orderRepo.save(orderDetails);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order, Integer id) throws OrderDetailsException {

		orderRepo.findById(id).orElseThrow(() -> new OrderDetailsException());

		orderRepo.save(order);

		return orderRepo.save(order);
	}

	@Override
	public OrderDetails removeOrder(Integer id) throws OrderDetailsException {

		OrderDetails order = orderRepo.findById(id).orElseThrow(() -> new OrderDetailsException());

		orderRepo.save(order);

		return order;
	}

	@Override
	public OrderDetails viewOrder(Integer id) throws OrderDetailsException {

		return orderRepo.findById(id).orElseThrow(() -> new OrderDetailsException());
	}

	@Override
	public List<OrderDetails> viewAllOrders(Integer resId) throws RestaurantException, OrderDetailsException {
		
		List<OrderDetails> list = orderRepo.findAll();
		
		restaurantRepo.findById(resId).orElseThrow(() -> new RestaurantException("No restaurant exist with id "+ resId ));
		
		List<OrderDetails> ans = new ArrayList<>();
		
		for(OrderDetails order : list) {
			order.getFoodCart().getItemList().forEach(el -> {
				if(el.getItem().getRestaurant().getResId() == resId) list.add(order);
			});
		}
		
		if(ans.isEmpty()) throw new OrderDetailsException("No order placed from this restaurant.");
		
		return ans;
	}

	@Override
	public List<OrderDetails> viewAllOrdersByCustomer(Integer userId) throws UserException, OrderDetailsException {
		
		User user = userRepo.findById(userId).orElseThrow(() -> new UserException("Please enter valid user id."));
		
		FoodCart cart = cartRepo.findByUser(user).get();
		
		List<OrderDetails> list =  orderRepo.findByFoodCart(cart);
		
		if(list.isEmpty()) throw new OrderDetailsException("No order placed by customer.");
		
		return null;
	}

}
