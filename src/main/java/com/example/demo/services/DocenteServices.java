package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Docente;
import com.example.demo.repositories.DocenteRepository;

import java.util.Optional;


@Service
public class DocenteServices {

	@Autowired
    private DocenteRepository docenteRepository;

    //CREAR DOCENTE
    public Docente createDocente(Docente docente) {
        
    	//Regla 1
        Optional<Docente> existente = docenteRepository.findByDocumentNumberAndDocumentTypeId(
                docente.getDocumentNumber(), 
                docente.getDocumentTypeId()
        );

        if (existente.isPresent()) {
        	
            throw new RuntimeException("Ya existe un docente con ese tipo y número de documento.");
        }

        return docenteRepository.save(docente);
    }

    //Obtener Docentes
    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    //Actualizar Docente
    public Docente updateDocente(Integer id, Docente docenteDetalles) {
        Docente docenteExistente = docenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Docente no encontrado con id: " + id));

        if (docenteDetalles.getName() != null) {
            docenteExistente.setName(docenteDetalles.getName());
        }
        
        if (docenteDetalles.getLastName() != null) {
            docenteExistente.setLastName(docenteDetalles.getLastName());
        }
        
        if (docenteDetalles.getEmail() != null) {
            docenteExistente.setEmail(docenteDetalles.getEmail());
        }
        
        if (docenteDetalles.getPhone() != null) {
            docenteExistente.setPhone(docenteDetalles.getPhone());
        }
        

        if (docenteDetalles.getGenderId() != 0) {
            docenteExistente.setGenderId(docenteDetalles.getGenderId());
        }
        
        // El resto de campos (documentNumber, documentTypeId) NO deberían actualizarse.

        return docenteRepository.save(docenteExistente);
    }

    //Eliminar Docente
    public void deleteDocente(Integer id) {
        
        //Verificar que exista
        if (!docenteRepository.existsById(id)) {
            throw new RuntimeException("Docente no encontrado con id: " + id);
        }

        // Si existe se elimina
        docenteRepository.deleteById(id);
    }
	
}