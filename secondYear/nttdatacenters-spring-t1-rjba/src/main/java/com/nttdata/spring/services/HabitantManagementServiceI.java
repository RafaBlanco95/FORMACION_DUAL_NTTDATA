package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.Apartment;
import com.nttdata.spring.repository.Building;
import com.nttdata.spring.repository.Habitant;

/**
 * 
 * Interfaz del servicio de Habitantes
 * 
 * @author RAFA
 *
 */
public interface HabitantManagementServiceI {
	
	/**
	 * 
	 * Inserta un nuevo habitante en un apartamento
	 * 
	 * @param habitant el habitante que se va a insertar 
	 * @param apartment el apartamento donde se va a insertar el habitante
	 */
	public void insertNewHabitant(Habitant habitant, Apartment apartment);
	
	/**
	 * 
	 * Busca todos los habitantes de un edificio
	 * 
	 * @param building el edificio donde se va a buscar
	 * @return La lista de habitantes encontrados
	 */
	public List<Habitant> searchAll(Building building);
	/**
	 * 
	 * Busca habitantes por nombre y apellidos
	 * 
	 * @param name el nombre del habitante 
	 * @param surname los apellidos del habitante
	 * @param building el edificio donde se va a buscar 
	 * @return la lista de los habitantes que cumplen los requisitos de la consulta
	 */
	public List<Habitant> searchByNameAndSurname(String name, String surname, Building building);
}
