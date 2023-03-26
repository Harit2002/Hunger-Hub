package com.masai.Repository;

import com.masai.Model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartRepo extends JpaRepository<FoodCart, Integer> {
}
