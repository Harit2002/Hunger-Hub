package com.masai.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String firstName;
    private String lastName;
    private Integer age;
    @Size(min = 10, max = 10, message = "mobile number should be of 10 digits")
    private String mobNumb;
    
    @OneToOne
    private Address address;
    
    @NotNull(message = "email can't be null")
    @NotBlank(message = "email can't be blank")
    @NotEmpty(message = "email can't be empty")
    @Email(message = "Please enter valid email id")
    @Column(unique = true)
    private String email;
    
    @NotNull(message = "password can't be null")
    @NotBlank(message = "password can't be blank")
    @NotEmpty(message = "password can't be empty")
    private String password;
    
    @ManyToOne
    private Role role;
    
}
