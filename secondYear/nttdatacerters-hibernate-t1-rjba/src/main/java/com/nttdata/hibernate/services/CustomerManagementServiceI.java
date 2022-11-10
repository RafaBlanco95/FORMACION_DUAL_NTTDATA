package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Customer;



/**
 * Interfaz del servicio de Clientes
 * 
 * @author RAFA
 *
 */
public interface CustomerManagementServiceI {
	
	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newCustomer Nuevo cliente
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente
	 * 
	 * @param updatedCustomer Cliente actualizado
	 */
	public void updateCustomer(final Customer updatedCustomer);

	/**
	 * Elimina un cliente existente
	 * 
	 * @param deletedCustomer Cliente eliminado
	 */
	public void deleteCustomer(final Customer deletedCustomer);

	/**
	 * Devuelve un cliente mediante su ID
	 * 
	 * @param customerId Identificador del cliente 
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Devuelve todos los clientes existentes
	 * 
	 * @return Lista de todos los clientes presentes en la BBDD
	 */
	public List<Customer> searchAll();
	
	/**
	 * 
	 * @param name Nombre del cliente
	 * @param firstLastName Primer apellido del cliente 
	 * @param secondLastName Segundo apellido del cliente
	 * @return Lista de clientes 
	 */
	public List<Customer> searchByNameAndLastName(final String name, String firstLastName, String secondLastName);
}
