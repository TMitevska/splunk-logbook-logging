package com.service.cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartCreateDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @NotNull
    private LocalDate date;
    @Positive
    private int quantity;
}
