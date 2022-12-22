package com.nttdata.spring.repository;

import java.util.List;

/**
 * 
 * DAO del habitante
 * 
 * @author RAFA
 *
 */
public interface HabitantDaoI {

	/**
	 * 
	 * Método para buscar los habitantes por su nombre y apellidos
	 * 
	 * @param name el nombre del habitante
	 * @param surname los apellidos del habitante 
	 * @param building el edificio donde se quiere buscar a la persona
	 * @return la lista de habitantes que concuerdan con los requisitos de la consulta
	 */
	public List<Habitant> searchByNameAndSurname(String name, String surname, Building building);
	
	/**
	 * 
	 * Método para insertar un habitante en un apartamento en la simulación ddel edificio
	 * 
	 * @param habitant el habitante a insertar
	 * @param apartment el apartamento donde se va a insertar al habitante
	 */
	public void insertHabitant(Habitant habitant, Apartment apartment);
	
	/**
	 * 
	 * Método para mostrar a todos los habiutantes del edificio
	 * 
	 * @param building el edificio del que se quieren obtener los habitantes 
	 * @return la lista de habitantes del edificio
	 */
	public List<Habitant> showAllHabitants(Building building);
}
