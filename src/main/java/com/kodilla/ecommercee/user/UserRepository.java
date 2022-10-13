package com.kodilla.ecommercee.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Optional<User> findById(Long id);

    @Override
    List<User> findAll();

    @Override
    void deleteById(Long id);
}