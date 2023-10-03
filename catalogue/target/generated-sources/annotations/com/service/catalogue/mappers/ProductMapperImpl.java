package com.service.catalogue.mappers;

import com.service.catalogue.dtos.ProductCreateDto;
import com.service.catalogue.dtos.ProductDto;
import com.service.catalogue.models.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-22T11:19:36+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductDto> productListToProductDtoList(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( product.size() );
        for ( Product product1 : product ) {
            list.add( productToProductDto( product1 ) );
        }

        return list;
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setId( product.getId() );
        productDto.setName( product.getName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );

        return productDto;
    }

    @Override
    public Product productCreateDtoToProduct(ProductCreateDto product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setName( product.getName() );
        product1.setDescription( product.getDescription() );
        product1.setPrice( product.getPrice() );

        return product1;
    }
}
