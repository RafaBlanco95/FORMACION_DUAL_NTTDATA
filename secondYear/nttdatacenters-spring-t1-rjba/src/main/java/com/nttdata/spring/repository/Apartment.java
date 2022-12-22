package com.nttdata.spring.repository;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Clase que representa los apartamentos de las plantas del edificio que se está simulando
 * 
 * @author RAFA
 *
 */
public class Apartment implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Lista de habitantes del apartamento */
	private List<Habitant> habitants;

	/**
	 * 
	 * Getter de la lista de habitantes
	 * 
	 * @return la lista de habitantes
	 */
	public List<Habitant> getHabitants() {
		return habitants;
	}

	/**
	 * 
	 * Setter de la lista de habitantes
	 * 
	 * @param habitants la lista de habitantes
	 */
	public void setHabitants(List<Habitant> habitants) {
		this.habitants = habitants;
	}

}
