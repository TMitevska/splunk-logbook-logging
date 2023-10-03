package com.service.catalogue.services;

import com.service.catalogue.dtos.ProductCreateDto;
import com.service.catalogue.dtos.ProductDto;
import com.service.catalogue.dtos.ProductUpdateDto;
import com.service.catalogue.exceptions.ProductNotFoundException;
import com.service.catalogue.mappers.ProductMapper;
import com.service.catalogue.models.Product;
import com.service.catalogue.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto getProductById(@NotNull @Min(1) Long id) throws ProductNotFoundException {
        return ProductMapper.INSTANCE.productToProductDto(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    public List<ProductDto> getAllProducts() {
        return ProductMapper.INSTANCE.productListToProductDtoList(productRepository.findAll());
    }

    public ProductDto addProduct(@Valid ProductCreateDto product) {
        return ProductMapper.INSTANCE.productToProductDto(productRepository.save(ProductMapper.INSTANCE.productCreateDtoToProduct(product)));
    }

    public ProductDto updateProduct(@NotNull @Min(1) Long id, @Valid ProductUpdateDto product) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        return ProductMapper.INSTANCE.productToProductDto(productRepository.save(existingProduct));
    }

    public void deleteProduct(@NotNull @Min(1) Long id) throws ProductNotFoundException {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(existingProduct);
    }
}

