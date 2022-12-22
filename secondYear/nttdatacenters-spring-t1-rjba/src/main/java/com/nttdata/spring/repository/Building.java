package com.nttdata.spring.repository;

import java.io.Serializable;

/**
 * 
 * Clase que representa a la entidad edificio en este proyecto de simulación 
 * 
 * @author RAFA
 *
 */
public class Building implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Lista de plantas */
	private Floor[] floors;

	/**
	 * 
	 * Getter de la lista de plantas
	 * 
	 * @return la lista de las plantas 
	 */
	public Floor[] getFloors() {
		return floors;
	}

	/**
	 * 
	 * Setter de la lista de plantas
	 * 
	 * @param floors La lista de las plantas 
	 */
	public void setFloors(Floor[] floors) {
		this.floors = floors;
	} 
}
