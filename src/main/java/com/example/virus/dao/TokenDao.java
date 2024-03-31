package com.example.virus.dao;

import com.example.virus.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenDao extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
}
