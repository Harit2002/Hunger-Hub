package com.masai.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.Pattern;
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
    
    @Pattern(regexp = "^[6-9][0-9]{9}", message = "Mobile number must have 10 digits.")
    private String mobNumb;
    
    @OneToOne(cascade = CascadeType.ALL)
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
    //@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Please ensure that password is at least 8 characters long and contains at least one digit, one lowercase letter, one uppercase letter.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @ManyToOne
    private Role role;
    
}
