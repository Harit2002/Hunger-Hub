package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.FoodCart;
import com.masai.Model.OrderDetails;

@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
	public List<OrderDetails> findByFoodCart(FoodCart foodCart);
}
