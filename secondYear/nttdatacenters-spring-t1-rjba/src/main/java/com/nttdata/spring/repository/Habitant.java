package com.nttdata.spring.repository;

import java.io.Serializable;

/**
 * 
 * Clase que representa a cada uno de los habitantes de los apartamentos de las distintas plantas del edificio que se está emulando
 * 
 * @author RAFA
 *
 */
public class Habitant implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Nombre de la persona */
	private String name;
	
	/** Apellidos de la persona */
	private String surname;

	

	/**
	 * 
	 * Getter del nombre de la persona
	 * 
	 * @return el nombre de la persona 
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Setter del nombre de la persona 
	 * 
	 * @param name el nombre de la persona
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Getter de los apellidos de la persona 
	 * 
	 * @return los apellidos de la persona 
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * 
	 * Setter de los apellidos de la persona 
	 * 
	 * @param surname los apellidos de la persona 
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

}
