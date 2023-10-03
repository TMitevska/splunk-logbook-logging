package com.service.catalogue.mappers;


import com.service.catalogue.dtos.ProductCreateDto;
import com.service.catalogue.dtos.ProductDto;
import com.service.catalogue.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    List<ProductDto> productListToProductDtoList(List<Product> product);
    ProductDto productToProductDto(Product product);
    Product productCreateDtoToProduct(ProductCreateDto product);
}
