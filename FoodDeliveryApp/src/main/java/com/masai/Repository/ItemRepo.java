package com.masai.Repository;

import com.masai.Model.Item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

	Optional<Item> findByItemName(String name);
}
