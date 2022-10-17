package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.product.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest()
@RunWith(SpringRunner.class)
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testAddNewCart() {
        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);

        //Then
        assertEquals(1, cartRepository.findAll().size());

        //Clean up
        cartRepository.deleteAll();
    }

    @Test
    public void testGetCartById() {
        //Given
        Cart cart = new Cart();

        //When
        cartRepository.save(cart);
        Optional<Cart> foundCart = cartRepository.findById(cart.getId());

        //Then
        assertEquals(cart.getId(), foundCart.get().getId());

        //Clean up
        cartRepository.deleteAll();
    }

    @Test
    public void testAddProductToCart() {
        //Given
        Product product = new Product("product", "description", 2, 2.5);
        Cart cart = new Cart();

        cartRepository.save(cart);
        productRepository.save(product);

        //When
        cart.getProducts().add(product);

        //Then
        assertEquals(1, cart.getProducts().size());

        //Clean up
        cartRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testDeleteProductFromCart() {
        //Given
        Product product1 = new Product("product", "description", 2, 2.5);
        Product product2 = new Product("product2", "description2", 4, 2.8);
        Cart cart = new Cart();

        cartRepository.save(cart);
        productRepository.save(product1);
        productRepository.save(product2);

        //When
        cart.getProducts().remove(product1);
        //Then
        assertEquals(1, cartRepository.findAll().size());

        //Clean up
        cartRepository.deleteAll();
        productRepository.deleteAll();
    }

    @Test
    public void testDeleteCartById() {
        //Given
        Cart cart = new Cart();
        cartRepository.save(cart);

        //When
        Long cartId = cart.getId();
        cartRepository.deleteById(cartId);

        //Then
        assertEquals(0, cartRepository.findAll().size());
    }
}
