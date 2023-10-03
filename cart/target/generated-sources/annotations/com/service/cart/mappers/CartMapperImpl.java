package com.service.cart.mappers;

import com.service.cart.dtos.CartCreateDto;
import com.service.cart.dtos.CartDto;
import com.service.cart.models.Cart;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T11:19:11+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class CartMapperImpl implements CartMapper {

    @Override
    public List<CartDto> cartListToCartDtoList(List<Cart> cart) {
        if ( cart == null ) {
            return null;
        }

        List<CartDto> list = new ArrayList<CartDto>( cart.size() );
        for ( Cart cart1 : cart ) {
            list.add( cartToCartDto( cart1 ) );
        }

        return list;
    }

    @Override
    public CartDto cartToCartDto(Cart cart) {
        if ( cart == null ) {
            return null;
        }

        CartDto cartDto = new CartDto();

        cartDto.setId( cart.getId() );
        cartDto.setUserId( cart.getUserId() );
        cartDto.setProductId( cart.getProductId() );
        cartDto.setDate( cart.getDate() );
        cartDto.setQuantity( cart.getQuantity() );

        return cartDto;
    }

    @Override
    public Cart cartCreateDtoToCart(CartCreateDto cart) {
        if ( cart == null ) {
            return null;
        }

        Cart cart1 = new Cart();

        cart1.setUserId( cart.getUserId() );
        cart1.setProductId( cart.getProductId() );
        cart1.setDate( cart.getDate() );
        cart1.setQuantity( cart.getQuantity() );

        return cart1;
    }
}
