package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.StudentModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repocitorios.StudentRepocitory;



@Service
public class StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepocitory StudentRepocitory;

	public StudentModel save(StudentModel studentModel) {
		
		return StudentRepocitory.save(studentModel);	
	}
	
	public List<StudentModel> getAll() {
		return (List<StudentModel>) StudentRepocitory.findAll();
	}

	public ResponseModel update(StudentModel studentModel) {
				
			try {
				 if (!studentExists(studentModel.getId())) {
				        return new ResponseModel(false,"Estudiante no existe");
				    }
				 	
				      StudentRepocitory.save(studentModel);		  
				    return new ResponseModel(true,"Estudiante actualizado");  
				    
			}catch(Exception ex){
				logger.error("Error updating student", ex);
				 return new ResponseModel(false,ex.getMessage());
			}
				   
		}
		
		public ResponseModel deleteStudent(int id) {
			
			try {
				 if (!studentExists(id)){
					 return new ResponseModel(false,"Estudiante no existe");
				 }
				 
					 StudentRepocitory.deleteById(id);
					 return new ResponseModel(true,"Estudiante eliminado");
				 
				
				
			}catch(Exception ex){
				logger.error("Error deleting student", ex);
				return new ResponseModel(false,ex.getMessage());
			}
			
		}
		
		private boolean studentExists(int id) {
		    return StudentRepocitory.findById(id).isPresent();
		}
		
			

}
