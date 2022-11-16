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
	 * @param name El nombre del cliente
	 * @param firstLastName El primer apellido del cliente 
	 * @param secondLastName El segundo apellido del cliente 
	 * @return Una lista de clientes que cumplan con los requisitos de la consulta 
	 */
	public List<Customer> searchByNameAndLastName(String name, String firstLastName, String secondLastName);

}
