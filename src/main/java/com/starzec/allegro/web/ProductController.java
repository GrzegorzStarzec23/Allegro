package com.starzec.allegro.web;

import com.starzec.allegro.entity.Product;
import com.starzec.allegro.model.ProductDto;
import com.starzec.allegro.service.ProductService;
import com.starzec.allegro.web.request.CreateAndUpdateProductRequest;
import com.starzec.allegro.web.responce.GetProductDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDto> fetchAllProduct() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public GetProductDetails findProductById(@PathVariable Long id) {
        final Optional<Product> productDto = productService.findIdProduct(id);
        return productDto.map(product -> new GetProductDetails(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getQuantity(), product.getWareHouse()))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Product with given id" + id + "not found "));
    }

    @PostMapping
    public void addNewProduct(@RequestBody @Valid CreateAndUpdateProductRequest request) {
        ProductDto productDto = new ProductDto(request.getName(), request.getDescription(), request.getPrice(), request.getQuantity(), request.getWareHouseId());
        productService.createNewProduct(productDto);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody @Valid CreateAndUpdateProductRequest request) {
        productService.updateProduct(id, request.getName(), request.getDescription(), request.getPrice(), request.getQuantity(), request.getWareHouseId());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        if (productService.existId(id)) {
            productService.deleteProduct(id);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Product with given id " + id + "not found");
        }
    }


}
