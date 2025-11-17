package com.example.demo.repocitorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.StudentModel;

@Repository
public interface StudentRepocitory extends CrudRepository<StudentModel,Integer>{

	
	
	
}
