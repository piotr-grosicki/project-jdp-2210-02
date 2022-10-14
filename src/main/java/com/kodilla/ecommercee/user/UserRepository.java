package com.kodilla.ecommercee.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findById(Long userId);
    Optional<User> findByLogin(String login);
    Optional<User> findByPassword(String password);

    @Override
    boolean existsById(Long userId);

    @Override
    void deleteById(Long userId);
}
