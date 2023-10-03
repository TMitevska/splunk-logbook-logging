package com.service.cart.mappers;

import com.service.cart.dtos.CartCreateDto;
import com.service.cart.dtos.CartDto;
import com.service.cart.models.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CartMapper {
    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);

    List<CartDto> cartListToCartDtoList(List<Cart> cart);
    CartDto cartToCartDto(Cart cart);
    Cart cartCreateDtoToCart(CartCreateDto cart);
}
