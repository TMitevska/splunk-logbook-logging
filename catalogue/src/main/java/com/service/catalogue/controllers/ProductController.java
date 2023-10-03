package com.service.catalogue.controllers;

import com.service.catalogue.dtos.ProductCreateDto;
import com.service.catalogue.dtos.ProductDto;
import com.service.catalogue.dtos.ProductUpdateDto;
import com.service.catalogue.exceptions.ProductNotFoundException;
import com.service.catalogue.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @Operation(summary = "Get product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") @NotNull @Min(1) Long id) throws ProductNotFoundException {
        log.info("Getting product by id: {}", id);
        final ProductDto product = productService.getProductById(id);
        log.info("Successful fetch of all products");
        return ResponseEntity.ok(product);
    }

    @Operation(summary = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        log.info("Getting all products");
        final List<ProductDto> products = productService.getAllProducts();
        log.info("Successful fetch of product");
        return ResponseEntity.ok(products);
    }

    @Operation(summary = "Create new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody @NotNull ProductCreateDto product) {
        log.info("Adding product: {}", product);
        final ProductDto savedProduct = productService.addProduct(product);
        log.info("Successful product creation");
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @Operation(summary = "Update product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") @NotNull @Min(1) Long id, @Valid @RequestBody @NotNull ProductUpdateDto product) throws ProductNotFoundException {
        log.info("Updating product with id {}: {}", id, product);
        final ProductDto updatedProduct = productService.updateProduct(id, product);
        log.info("Successful update of product");
        return ResponseEntity.ok(updatedProduct);
    }

    @Operation(summary = "Delete product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request"),
            @ApiResponse(responseCode = "204", description = "Successful request, no content"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") @NotNull @Min(1) Long id) throws ProductNotFoundException {
        log.info("Deleting product with id: {}", id);
        productService.deleteProduct(id);
        log.info("Successful delete of product");
        return ResponseEntity.noContent().build();
    }
}

