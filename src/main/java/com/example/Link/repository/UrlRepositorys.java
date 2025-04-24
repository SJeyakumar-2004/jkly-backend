package com.example.Link.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Link.entity.Url;

public interface UrlRepositorys extends JpaRepository<Url, Long>
{
    Optional<Url> findByShortCode(String shortCode);

}
