package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Docente;
import com.example.demo.services.DocenteServices;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")
public class DocenteController {

    @Autowired
    private DocenteServices docenteServices;

    // Crear Docente
    @PostMapping
    public ResponseEntity<Docente> createDocente(@RequestBody Docente docente) {
    	
        try {
            Docente nuevoDocente = docenteServices.createDocente(docente);
            return new ResponseEntity<>(nuevoDocente, HttpStatus.CREATED); 
            
        } catch (RuntimeException e) {
        	
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    //Obtener los Docentes
    @GetMapping
    public ResponseEntity<List<Docente>> getAllDocentes() {
        List<Docente> docentes = docenteServices.getAllDocentes();
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }

    //Actualizar Docente
    @PutMapping("/{id}")
    public ResponseEntity<Docente> updateDocente(@PathVariable Integer id, @RequestBody Docente docenteDetails) {
        try {
            Docente docenteActualizado = docenteServices.updateDocente(id, docenteDetails);
            return new ResponseEntity<>(docenteActualizado, HttpStatus.OK);
            
        } catch (RuntimeException e) {
        	
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //Eliminar Docente
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocente(@PathVariable Integer id) {
        try {
            docenteServices.deleteDocente(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (RuntimeException e) {
        	
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}