package com.kodilla.ecommercee.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product mapToProduct(ProductDto productDto) {
        return new Product(productDto.getName(),
                productDto.getDescription(),
                productDto.getQuantity(),
                productDto.getPrice());
    }

    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }
}
