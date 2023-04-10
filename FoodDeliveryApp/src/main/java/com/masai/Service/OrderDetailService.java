package com.masai.Service;

import java.util.List;

import com.masai.Exception.FoodCartException;
import com.masai.Exception.OrderDetailsException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.OrderDetails;

public interface OrderDetailService {
	public OrderDetails addOrder(OrderDetails orderDetails, Integer cartId) throws OrderDetailsException, FoodCartException;

	public OrderDetails updateOrder(OrderDetails order, Integer id) throws OrderDetailsException;

	public OrderDetails removeOrder(Integer id) throws OrderDetailsException;

	public OrderDetails viewOrder(Integer id) throws OrderDetailsException;

	public List<OrderDetails> viewAllOrders(Integer resId) throws RestaurantException, OrderDetailsException;

	public List<OrderDetails> viewAllOrdersByCustomer(Integer userId) throws UserException,OrderDetailsException;
	
}
