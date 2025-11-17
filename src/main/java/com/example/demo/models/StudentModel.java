package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Student")
public class StudentModel {
  
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(nullable = false, unique = true)
	private int id;
  private String DocumentNumber;
  private int documentType;
  private String name;
  private String lastname;
  private String email;
  private String phone;
  private int genderId;
  
  //Get and Set
  
  
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public String getDocumentNumber() {
	return DocumentNumber;
  }
  public void setDocumentNumber(String documentNumber) {
	DocumentNumber = documentNumber;
  }
  public int getDocumentType() {
	return documentType;
  }
  public void setDocumentType(int documentType) {
	this.documentType = documentType;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public String getLastname() {
	return lastname;
  }
  public void setLastname(String lastname) {
	this.lastname = lastname;
  }
  public String getEmail() {
	return email;
  }
  public void setEmail(String email) {
	this.email = email;
  }
  public String getPhone() {
	return phone;
  }
  public void setPhone(String phone) {
	this.phone = phone;
  }
  public int getGenderId() {
	return genderId;
  }
  public void setGenderId(int genderId) {
	this.genderId = genderId;
  }


  
}

