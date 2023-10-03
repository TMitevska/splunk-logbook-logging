package com.service.cart.controllers;

import com.service.cart.dtos.CartCreateDto;
import com.service.cart.dtos.CartDto;
import com.service.cart.dtos.CartUpdateDto;
import com.service.cart.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Logger;

@Validated
@RestController
@RequestMapping("/carts")
@Slf4j
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Get all carts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        log.info("Getting all carts");
        final List<CartDto> carts = cartService.getAllCarts();
        log.info("Successful fetch of all carts");
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @Operation(summary = "Get cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") @Min(1) Long id) {
        log.info("Getting cart with id {}", id);
        final CartDto cart = cartService.getCartById(id);
        log.info("Successful fetch of cart");
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @Operation(summary = "Create new cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created cart"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody @Valid @NotNull CartCreateDto cart) {
        log.info("Creating cart {}", cart);
        final CartDto newCart = cartService.createCart(cart);
        log.info("Successful cart creation");
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    @Operation(summary = "Update existing cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PutMapping("/{id}")
    public ResponseEntity<CartDto> updateCart(
            @PathVariable("id") @Min(1) Long id,
            @RequestBody @Valid @NotNull CartUpdateDto cart
    ) {
        log.info("Updating cart with id {} to {}", id, cart);
        final CartDto updatedCart = cartService.updateCart(id, cart);
        log.info("Successful update of cart");
        return new ResponseEntity<>(updatedCart, HttpStatus.OK);
    }

    @Operation(summary = "Delete cart by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successful request, no content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") @Min(1) Long id) {
        log.info("Deleting cart with id {}", id);
        cartService.deleteCart(id);
        log.info("Successful delete of cart");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

