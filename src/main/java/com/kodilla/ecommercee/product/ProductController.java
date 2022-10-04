package com.kodilla.ecommercee.product;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDto>> getProducts() {
        //code connected with service, repository and mapper
        return ResponseEntity.ok(new ArrayList<>());
    }

    @GetMapping(value = "{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        //code connected with service, repository and mapper
        if (productId == 1)
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody ProductDto productDto) {
        //code connected with service, repository and mapper
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto) {
        //code connected with service, repository and mapper
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        //code connected with service, repository and mapper
        if (productId != 3)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }


}
