package com.kodilla.ecommercee.product;

import com.kodilla.ecommercee.group.GroupNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    private final ProductRepository repository;

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(mapper.mapToProductDtoList(products));
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        return ResponseEntity.ok(mapper.mapToProductDto(service.getProduct(productId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {

        Product product = mapper.mapToProduct(productDto);
        service.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable Long productId) throws GroupNotFoundException {
        Product productToUpdate = mapper.mapToUpdatedProduct(productDto);
        Long id = repository.findById(productId).get().getId();
        productToUpdate.setId(id);
        return ResponseEntity.ok(mapper.mapToProductDto(repository.save(productToUpdate)));
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deletebyId(@PathVariable Long productId) throws ProductNotFoundException {
        repository.deleteById(productId);
        return ResponseEntity.ok().build();
    }


}
