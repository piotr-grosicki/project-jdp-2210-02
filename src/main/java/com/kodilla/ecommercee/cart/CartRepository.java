package com.kodilla.ecommercee.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public interface CartRepository extends CrudRepository<Cart,Long> {

    Optional<Cart> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    boolean existsById(Long cartId);

}
