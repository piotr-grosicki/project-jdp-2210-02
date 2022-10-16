package com.kodilla.ecommercee.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(mapper.mapToProductDtoList(products));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(mapper.mapToProductDto(service.getProduct(productId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        Product product = mapper.mapToProduct(productDto);
        service.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        Product product = mapper.mapToProduct(productDto);
        Product savedProduct = service.saveProduct(product);
        return ResponseEntity.ok(mapper.mapToProductDto(savedProduct));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        service.deleteProduct(service.getProduct(productId));
        return ResponseEntity.ok().build();
    }


}
