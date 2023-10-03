package com.service.cart.services;

import com.service.cart.dtos.*;
import com.service.cart.exceptions.CartNotFoundException;
import com.service.cart.exceptions.CartServiceException;
import com.service.cart.mappers.CartMapper;
import com.service.cart.models.Cart;
import com.service.cart.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.Min;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    private final RestTemplate restTemplate;

    private static final String CATALOGUE_SERVICE_URL = "http://localhost:8082/products/";
    private static final String USER_SERVICE_URL = "http://localhost:8083/users/";

    public List<CartDto> getAllCarts() {
        return CartMapper.INSTANCE.cartListToCartDtoList(cartRepository.findAll());
    }

    public CartDto getCartById(@Min(1) Long id) {
        final Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
        return CartMapper.INSTANCE.cartToCartDto(cart);
    }

    public CartDto createCart(CartCreateDto cart) {
        try {
            ProductDto product = restTemplate.getForEntity(CATALOGUE_SERVICE_URL + cart.getProductId(), ProductDto.class).getBody();
            UserDto user = restTemplate.getForEntity(USER_SERVICE_URL + cart.getUserId(), UserDto.class).getBody();
            return CartMapper.INSTANCE.cartToCartDto(cartRepository.save(CartMapper.INSTANCE.cartCreateDtoToCart(cart)));
        } catch(Exception e) {
            throw new CartServiceException(e.getMessage(), e);
        }
    }

    public CartDto updateCart(@Min(1) Long id, CartUpdateDto cart) {
        Cart existingCart = cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

        existingCart.setUserId(cart.getUserId());
        existingCart.setProductId(cart.getProductId());
        existingCart.setQuantity(cart.getQuantity());

        return CartMapper.INSTANCE.cartToCartDto(cartRepository.save(existingCart));
    }

    public void deleteCart(@Min(1) Long id) {
        if (!cartRepository.existsById(id)) {
            throw new CartNotFoundException(id);
        }
        cartRepository.deleteById(id);
    }
}

