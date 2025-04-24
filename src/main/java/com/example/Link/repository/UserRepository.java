package com.example.Link.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Link.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByEmailAndPassword(String email, String password);
}

