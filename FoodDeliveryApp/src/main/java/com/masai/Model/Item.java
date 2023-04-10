package com.masai.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resId")
	private Restaurant restaurant;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "catid")
	private Category category;
}
