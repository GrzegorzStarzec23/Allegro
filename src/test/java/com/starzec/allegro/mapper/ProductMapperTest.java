package com.starzec.allegro.mapper;

import com.starzec.allegro.entity.Product;
import com.starzec.allegro.model.ProductDto;
import com.starzec.allegro.model.ProductEanDto;
import com.starzec.allegro.provider.ProductDtoProvider;
import com.starzec.allegro.provider.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    private ProductMapper productMapper;

    @BeforeEach
    void setUp() {
        productMapper = new ProductMapper();
    }

    @Test
    void toEntity() {
        //given
        ProductDto dto = new ProductDto();
        //when
        dto.setName("Doll");
        dto.setDescription("Safety");
        dto.setPrice(BigDecimal.ONE);
        dto.setQuantity(1L);
        Product product = productMapper.toEntity(dto);
        //then
        Product expected = new Product();
        expected.setName("Doll");
        expected.setDescription("Safety");
        expected.setPrice(BigDecimal.ONE);
        expected.setQuantity(1L);

        assertEquals(expected, product);
    }

    @Test
    void toDto() {
        //given
        Product product = new Product();
        //when
        product.setId(1L);
        product.setName("Doll");
        product.setDescription("Safety");
        product.setPrice(BigDecimal.ONE);
        product.setQuantity(1L);
        ProductDto dto = productMapper.toDto(product);
        //then
        ProductDto expected = new ProductDto();
        expected.setId(1L);
        expected.setName("Doll");
        expected.setDescription("Safety");
        expected.setPrice(BigDecimal.ONE);
        expected.setQuantity(1L);

        assertEquals(expected, dto);
    }

    @Test
    void toProductEanDto(){
        // given
        ProductResponse productResponse = new ProductResponse();
        productResponse.setCode("12345");
        productResponse.setCodeType("EAN");

        ProductDtoProvider productDtoProvider = new ProductDtoProvider();
        productDtoProvider.setName("Doll");
        productDtoProvider.setDescription("Safety");
        productDtoProvider.setRegion("Europe");
        productDtoProvider.setImageUrl("example.com/image.jpg");
        productDtoProvider.setBrand("ABC Toys");
        productDtoProvider.setCategory("Toys");
        productDtoProvider.setEan(987654321L);

        productResponse.setProduct(productDtoProvider);

        productResponse.setBarcodeUrl("example.com/barcode.jpg");

        // when
        ProductEanDto dto = productMapper.toProductEanDto(productResponse);

        // then
        ProductEanDto expected = ProductEanDto.builder()
                .code("12345")
                .codeType("EAN")
                .name("Doll")
                .description("Safety")
                .region("Europe")
                .imageUrl("example.com/image.jpg")
                .brand("ABC Toys")
                .ean(987654321L)
                .build();

        assertEquals(expected, dto);

    }
}