package com.cvictor.fashionblogapi.repository;

import com.cvictor.fashionblogapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByEmailAndPassword(String email, String password);

    User findUserByUserid(Long userid);

   Optional <User> findByEmail(String email);
}
