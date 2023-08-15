package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.Product;
import com.starzec.allegro.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto dto){
        Product product=new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    };

    public ProductDto toDto(Product product){
        ProductDto dto=new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }
}
