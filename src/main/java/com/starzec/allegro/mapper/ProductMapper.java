package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.Product;
import com.starzec.allegro.model.ProductDto;
import com.starzec.allegro.model.ProductEanDto;
import com.starzec.allegro.provider.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        return product;
    }

    ;

    public ProductDto toDto(Product product) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        return dto;
    }

    public ProductEanDto toProductEanDto(ProductResponse productResponse) {
        return ProductEanDto.builder()
                .code(productResponse.getCode())
                .codeType(productResponse.getCodeType())
                .name(productResponse.getProduct().getName())
                .description(productResponse.getProduct().getDescription())
                .region(productResponse.getProduct().getRegion())
                .imageUrl(productResponse.getProduct().getImageUrl())
                .brand(productResponse.getProduct().getBrand())
                .ean(productResponse.getProduct().getEan())
                .build();
    }
}
