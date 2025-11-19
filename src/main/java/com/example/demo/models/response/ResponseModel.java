package com.example.demo.models.response;

public class ResponseModel {
	
	private boolean Successfully;
	private String Message;
	
	
	
	
	
	public ResponseModel(boolean successfully, String message) {
		Successfully = successfully;
		Message = message;
	}
	
	
	public boolean isSuccessfully() {
		return Successfully;
	}
	public void setSuccessfully(boolean successfully) {
		Successfully = successfully;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	

	
}


