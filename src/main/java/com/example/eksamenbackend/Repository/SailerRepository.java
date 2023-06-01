package com.example.eksamenbackend.Repository;

import com.example.eksamenbackend.Model.Sailor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SailerRepository extends JpaRepository<Sailor, Integer> {
     List<Sailor> findAllByContestId(int contestId);

}
