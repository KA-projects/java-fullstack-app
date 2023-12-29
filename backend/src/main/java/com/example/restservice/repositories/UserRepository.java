package com.example.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.model.User;;

public interface UserRepository extends JpaRepository<User, Long> {

}
