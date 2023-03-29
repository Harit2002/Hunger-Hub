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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
	
	@NotBlank(message = "Item name can't be blank, please enter valid item name.")
	@NotEmpty(message = "Item name can't be empty, please enter valid item name.")
	@NotNull(message = "Item name is mendatory.")
	private String itemName;
	
	@Min(value = 1, message = "Minimum quantity can't be less then 1 rupee.")
	private Integer quantity;
	
	@NotNull(message = "Item cost is mendatory.")
	@Min(value = 50, message = "Minimum value can't be less then 50 rupee.")
	private double cost;

	@ManyToMany
	@JoinTable(name = "Item_restaurant", 
	joinColumns = { @JoinColumn(name = "itemID") },
	inverseJoinColumns = { @JoinColumn(name = "restaurantId") 
	})
	private List<Restaurant> resList = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "catid")
	private Category category;
}
