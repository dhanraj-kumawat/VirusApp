package com.example.virus.dao;

import com.example.virus.model.Virus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirusDao extends JpaRepository<Virus, Long> {
}
