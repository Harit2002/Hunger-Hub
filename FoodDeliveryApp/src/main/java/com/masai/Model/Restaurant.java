package com.masai.Model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resId;
    
    @NotNull(message = "Name of restaurent should not be null.")
    @NotEmpty(message = "Name of restaurent should not be empty.")
    @NotBlank(message = "Name of restaurent should not be blank.")
    private String restaurantName;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();
    
    private String managerName;
    
    @NotNull(message = "Contact number is mandatory.")
	@Pattern(regexp = "^[6-9][0-9]{9}", message = "Mobile number must have 10 digits.")
    private String contactNumber;
}
