package com.service.cart.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartUpdateDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    @Positive
    private int quantity;
}
