package com.kodilla.ecommercee.cart;

import com.kodilla.ecommercee.product.Product;
import com.kodilla.ecommercee.product.ProductRepository;
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

    /**
     * EXCEPTION CHANGE TO USERNOTFOUND
     */

    boolean createEmptyCart(Long userId){
        if (userRepository.existsById(userId)){
            User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
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

    /**
     * EXCEPTION CHANGE TO PRODUCTNOTFOUND
     */

    boolean addProductToCart(Long cartId, Long productId) throws NoFoundCartException{
        if (cartRepository.existsById(cartId) && productRepository.existsById(productId)){
            Cart cart = cartRepository.findById(cartId).orElseThrow(NoFoundCartException::new);
            cart.getProducts().add(productRepository.findById(productId).orElseThrow(IllegalArgumentException::new));
            cartRepository.save(cart);
            return true;
        }
        return false;
    }

    /**
     * EXCEPTION CHANGE TO PRODUCTNOTFOUND
     */

    @Transactional
    boolean deleteProductFromCartById(Long cartId, Long productId) throws NoFoundCartException{
        Cart cart = cartRepository.findById(cartId).orElseThrow(NoFoundCartException::new);
        Product productToDelete = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
        List<Product> products = cart.getProducts();

        for (Product p: products){
            if (p == productToDelete) {
                cart.getProducts().remove(productToDelete);
                cartRepository.save(cart);
                return true;
            }
        }
        throw new IllegalArgumentException();
    }
}