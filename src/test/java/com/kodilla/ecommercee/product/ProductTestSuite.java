package com.kodilla.ecommercee.product;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllProducts() {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        List<Product> testList = productRepository.findAll();
        //Then
        Assertions.assertEquals(testList.get(0).getId(), product1.getId());
        Assertions.assertEquals(testList.get(1).getId(), product2.getId());
        Assertions.assertEquals(testList.get(2).getId(), product3.getId());
        //CleanUp
        productRepository.deleteById(product1.getId());
        productRepository.deleteById(product2.getId());
        productRepository.deleteById(product3.getId());
    }

    @Test
    public void testFindProductById() {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        Long product1Id = product1.getId();
        Long product2Id = product2.getId();
        Long product3Id = product3.getId();
        Optional<Product> testProduct1 = productRepository.findById(product1Id);
        Optional<Product> testProduct2 = productRepository.findById(product2Id);
        Optional<Product> testProduct3 = productRepository.findById(product3Id);
        //Then
        Assertions.assertEquals(testProduct1.get().getId(), product1Id);
        Assertions.assertEquals(testProduct2.get().getId(), product2Id);
        Assertions.assertEquals(testProduct3.get().getId(), product3Id);
        //CleanUp
        productRepository.deleteById(product1.getId());
        productRepository.deleteById(product2.getId());
        productRepository.deleteById(product3.getId());
    }

    @Test
    public void testDeleteProductById() {
        //Given
        Product product1 = new Product("product1", "description1", 5, 24.30);
        Product product2 = new Product("product2", "description2", 12, 7.55);
        Product product3 = new Product("product3", "description3", 2, 112.47);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.deleteById(product1.getId());
        productRepository.deleteById(product2.getId());
        productRepository.deleteById(product3.getId());
        List<Product> testList = productRepository.findAll();
        //Then
        Assertions.assertEquals(testList.size(), 0);


    }
}
