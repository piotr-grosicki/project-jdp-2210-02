package com.kodilla.ecommercee.cart;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long cartId);
}