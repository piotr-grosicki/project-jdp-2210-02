package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.product.ProductNotFoundException;
import com.kodilla.ecommercee.product.ProductRepository;
import com.kodilla.ecommercee.user.NoFoundUserException;
import com.kodilla.ecommercee.user.User;
import com.kodilla.ecommercee.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CartMapper cartMapper;

    CartService(final CartRepository cartRepository, final UserRepository userRepository, final ProductRepository productRepository, final CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.cartMapper = cartMapper;
    }
    public List<CartDto> getAllCarts(){
        return cartMapper.mapToCartDtoList(cartRepository.findAll());
    }
    public Cart getCart(Long cartId) throws NoFoundCartException {
        return cartRepository.findById(cartId).orElseThrow(NoFoundCartException::new);
    }

    boolean createEmptyCart(Long userId) throws NoFoundUserException {
        if (userRepository.existsById(userId)){
            User user = userRepository.findById(userId).orElseThrow(NoFoundUserException::new);
            Cart cart = new Cart(
                    user,
                    null,
                    new ArrayList<>()
            );
            user.setCart(cart);
            cartRepository.save(cart);
            return true;
        }
        return false;
    }

    boolean addProductToCart(Long cartId, Long productId) throws NoFoundCartException, ProductNotFoundException {
        if (cartRepository.existsById(cartId) && productRepository.existsById(productId)){
            Cart cart = cartRepository.findById(cartId).orElseThrow(NoFoundCartException::new);
            cart.getProducts().add(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
            cartRepository.save(cart);
            return true;
        }
        return false;
    }

    @Transactional
    boolean deleteProductFromCartById(Long cartId, Long productId) throws NoFoundCartException, ProductNotFoundException {
        if (!cartRepository.existsById(cartId) && productRepository.existsById(productId))
            throw new IllegalArgumentException("Cart or Product doesn't exist");
        Cart cart = cartRepository.findById(cartId).orElseThrow(NoFoundCartException::new);
        Product productToDelete = cart.getProducts().stream()
                .filter(product1 -> product1.getId().equals(productId))
                .findFirst().orElseThrow(ProductNotFoundException::new);
        cart.getProducts().remove(productToDelete);
        return true;
    }
}