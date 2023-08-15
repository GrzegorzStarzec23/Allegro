package com.starzec.allegro.service;

import com.starzec.allegro.entity.Product;
import com.starzec.allegro.entity.WareHouse;
import com.starzec.allegro.mapper.ProductMapper;
import com.starzec.allegro.model.ProductDto;
import com.starzec.allegro.repository.ProductRepository;
import com.starzec.allegro.repository.WareHouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final WareHouseRepository wereHouseRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<Product> findIdProduct(Long id) {
        return productRepository.findById(id);
    }

    public void createNewProduct(ProductDto productDto) {
        WareHouse wareHouse = wereHouseRepository.findById(productDto.getWareHouseId())
                .orElseThrow(() -> new RuntimeException("Not found warehouse with " + productDto.getWareHouseId() + " id"));

        Product product = productMapper.toEntity(productDto);
        product.setWareHouse(wareHouse);

        productRepository.save(product);
    }

    public void updateProduct(Long id, String name, String description, BigDecimal price, Long quantity, Long wareHouseId) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found product with " + id + " id"));

        WareHouse wereHouse = wereHouseRepository.findById(wareHouseId)
                .orElseThrow(() -> new RuntimeException("Not found warehouse with " + wareHouseId + " id"));

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setWareHouse(wereHouse);

        productRepository.save(product);
    }

    public boolean existId(Long id) {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .anyMatch(product -> product.getId().equals(id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
