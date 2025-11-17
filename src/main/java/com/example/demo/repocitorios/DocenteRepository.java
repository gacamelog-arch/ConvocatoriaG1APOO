package com.example.demo.repocitorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DocenteModel;

@Repository
public interface DocenteRepository extends CrudRepository<DocenteModel, Integer> {
    Optional<DocenteModel> findByTipoDocumentoAndNumeroDocumento(int tipoDocumento, String numeroDocumento);
}
