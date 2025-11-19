package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="docente")
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false , unique = true)
	private int id;
	
	private String documentNumber;
	private int documentTypeId;
	private String document;
	private String name;
	private String lastName;
	private String email;
	private String phone;
	private int genderId;
	
	// get set
	
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public String getDocumentNumber() {
	    return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
	    this.documentNumber = documentNumber;
	}
	
	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public int getDocumentTypeId() {
	    return documentTypeId;
	}

	public void setDocumentTypeId(int documentTypeId) {
	    this.documentTypeId = documentTypeId;
	}
	
	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public String getLastName() {
	    return lastName;
	}

	public void setLastName(String lastName) {
	    this.lastName = lastName;
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