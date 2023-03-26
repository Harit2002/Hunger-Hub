package com.masai.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;
    private String restaurantName;
    @OneToOne
    private Address address;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "resList")
    private List<Item> itemList = new ArrayList<>();
    private String managerName;
    private String contactNumber;
}
