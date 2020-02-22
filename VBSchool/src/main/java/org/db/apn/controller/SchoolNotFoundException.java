package org.db.apn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SchoolNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object id;
	
	SchoolNotFoundException(Object id){
		super(String.format("School with the id : '%s' does not Exists!!!!",id));
		
		this.id=id;
	}
	
	public Object getId() {
		return this.id;
	}

}
