package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Model.Sailor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SailerRepository extends JpaRepository<Sailor, Integer> {
}
