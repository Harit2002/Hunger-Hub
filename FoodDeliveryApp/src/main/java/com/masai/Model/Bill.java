package com.masai.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    @Id
    private Integer billid;

    private LocalDateTime billDate;
    @OneToOne
    @JoinColumn(name = "orderId")
    private OrderDetails order;
}
