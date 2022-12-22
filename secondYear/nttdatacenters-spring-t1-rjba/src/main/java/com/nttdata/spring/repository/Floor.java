package com.nttdata.spring.repository;

import java.io.Serializable;

/**
 * 
 * Clase que representa las plantas del edificio en la simulación 
 * 
 * @author RAFA
 *
 */
public class Floor  implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Lista de apartamentos */
	private Apartment[] apartments;

	/**
	 * 
	 * Getter de la lista de apartamentos
	 * 
	 * @return la lista de apartamentos 
	 */
	public Apartment[] getApartments() {
		return apartments;
	}

	/**
	 * 
	 * Setter de la lista de apartamentos 
	 * 
	 * @param apartaments la lista de apartamentos
	 */
	public void setApartaments(Apartment[] apartments) {
		this.apartments = apartments;
	}

	
}
