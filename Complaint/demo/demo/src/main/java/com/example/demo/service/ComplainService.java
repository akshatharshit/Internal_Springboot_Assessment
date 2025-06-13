package com.example.demo.service;

import com.example.demo.model.Complain;
import com.example.demo.repository.ComplainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplainService {

    @Autowired
    private ComplainRepository complainRepo;

    // Create or Update
    public void saveComplain(Complain complain) {
        complainRepo.save(complain);
    }

    // Get all complains
    public List<Complain> getAllComplains() {
        return complainRepo.findAll();
    }

    // Get a complain by ID
    public Complain getComplainById(Long id) {
        Optional<Complain> optional = complainRepo.findById(id);
        return optional.orElse(null);
    }

    // Get complains by status
    public List<Complain> getComplainsByStatus(Complain.Status status) {
        return complainRepo.findByStatus(status);
    }

    // Delete complain by ID
    public void deleteComplain(Long id) {
        complainRepo.deleteById(id);
    }



}
