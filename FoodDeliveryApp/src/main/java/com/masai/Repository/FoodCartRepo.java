package com.masai.Repository;

import com.masai.Model.FoodCart;
import com.masai.Model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartRepo extends JpaRepository<FoodCart, Integer> {
	public Optional<FoodCart> findByUser(User user);
}
