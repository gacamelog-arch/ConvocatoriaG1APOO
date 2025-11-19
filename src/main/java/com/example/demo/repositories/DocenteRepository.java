package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.example.demo.models.Docente;

import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    
    Optional<Docente> findByDocumentNumberAndDocumentTypeId(String documentNumber, int documentTypeId);
    
}
