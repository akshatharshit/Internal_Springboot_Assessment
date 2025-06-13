package com.example.demo.repository;

import com.example.demo.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {
    List<Complain> findByStatus(Complain.Status status);
}
