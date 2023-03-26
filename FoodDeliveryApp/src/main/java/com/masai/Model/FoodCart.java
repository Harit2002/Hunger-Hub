package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "foodCart")
@AllArgsConstructor
@NoArgsConstructor
public class FoodCart {
    @Id
    private String cartId;
    @OneToOne
    private User user;
    
    @OneToMany
    @JoinColumn(name = "itemId")
    private List<Item> itemList = new ArrayList<>();
}
