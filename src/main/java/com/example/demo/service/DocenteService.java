package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.DocenteModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repocitorios.DocenteRepository;

@Service
public class DocenteService {
    private static final Logger logger = LoggerFactory.getLogger(DocenteService.class);

    @Autowired
    private DocenteRepository docenteRepository;

    public ResponseModel save(DocenteModel docente) {
        try {
            if (docenteRepository.findByTipoDocumentoAndNumeroDocumento(docente.getTipoDocumento(), docente.getNumeroDocumento()).isPresent()) {
                return new ResponseModel(false, "Docente con ese tipo y número ya existe");
            }
            docenteRepository.save(docente);
            return new ResponseModel(true, "Docente creado");
        } catch (Exception ex) {
            logger.error("Error creando docente", ex);
            return new ResponseModel(false, ex.getMessage());
        }
    }

    public List<DocenteModel> getAll() {
        return StreamSupport.stream(docenteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ResponseModel update(DocenteModel docente) {
        try {
            Optional<DocenteModel> existingById = docenteRepository.findById(docente.getId());
            if (!existingById.isPresent()) {
                return new ResponseModel(false, "Docente no existe");
            }
            Optional<DocenteModel> other = docenteRepository.findByTipoDocumentoAndNumeroDocumento(docente.getTipoDocumento(), docente.getNumeroDocumento());
            if (other.isPresent() && other.get().getId() != docente.getId()) {
                return new ResponseModel(false, "Otro docente con mismo tipo y número ya existe");
            }
            docenteRepository.save(docente);
            return new ResponseModel(true, "Docente actualizado");
        } catch (Exception ex) {
            logger.error("Error actualizando docente", ex);
            return new ResponseModel(false, ex.getMessage());
        }
    }

    public ResponseModel deleteDocente(int id) {
        try {
            if (!docenteRepository.findById(id).isPresent()) {
                return new ResponseModel(false, "Docente no existe");
            }
            docenteRepository.deleteById(id);
            return new ResponseModel(true, "Docente eliminado");
        } catch (Exception ex) {
            logger.error("Error eliminando docente", ex);
            return new ResponseModel(false, ex.getMessage());
        }
    }
}
