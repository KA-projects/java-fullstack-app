package com.example.restservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.model.User;;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findById(long id);

    User findByFirstnameAndLastname(String name, String lastname);

    List<User> findAllByFirstname(String name);

    List<User> findAllByLastname(String lastname);

    User findByFirstname(String name);

    User findByLastname(String lastname);
}
