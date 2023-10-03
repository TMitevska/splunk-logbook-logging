package com.service.cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private Long id;
    private Long userId;
    private Long productId;
    private LocalDate date;
    private int quantity;
}
