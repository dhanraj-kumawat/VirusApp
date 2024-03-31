package com.example.virus.dao;

import com.example.virus.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalDao extends JpaRepository<Hospital, Long> {
}
