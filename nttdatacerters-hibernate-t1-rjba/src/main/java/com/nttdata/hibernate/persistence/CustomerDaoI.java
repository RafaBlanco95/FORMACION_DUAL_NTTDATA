package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO de la tabla Cliente 
 * 
 * @author RAFA
 *
 */
public interface CustomerDaoI extends CommonDaoI<Customer>{
	/**
	 * 
	 * Método para buscar los Clientes por Nombre y Apellidos
	 * 
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndLastName(String name, String firstLastName, String secondLastName);

}
