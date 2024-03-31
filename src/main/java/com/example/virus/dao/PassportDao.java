package com.example.virus.dao;

import com.example.virus.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportDao extends JpaRepository<Passport,Long> {
}
