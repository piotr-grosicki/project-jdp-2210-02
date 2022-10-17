package com.kodilla.ecommercee.product;

import com.kodilla.ecommercee.group.GroupNotFoundException;
import com.kodilla.ecommercee.group.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    private final GroupService groupService;

    ProductMapper(final GroupService groupService) {
        this.groupService = groupService;
    }

    public Product mapToProduct(ProductDto productDto) throws GroupNotFoundException {
        return new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getQuantity(),
                productDto.getPrice(),
                groupService.getGroup(productDto.getGroupId()));
    }


    public ProductDto mapToProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice(),
                product.getGroup().getId());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public Product mapToUpdatedProduct(ProductDto productDto) throws GroupNotFoundException {
        return new Product(productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getQuantity(),
                productDto.getPrice(),
                groupService.getGroup(productDto.getGroupId()));
    }
}
