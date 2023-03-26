package com.masai.Model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	private String itemName;
	private Integer quantity;

	private double cost;

	@ManyToMany
	
	@JoinTable(name = "Item_restaurant", 
	joinColumns = { @JoinColumn(name = "itemID") },
	inverseJoinColumns = { @JoinColumn(name = "restaurantID") 
	})
	private List<Restaurant> resList = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "catid")
	private Category category;
}
