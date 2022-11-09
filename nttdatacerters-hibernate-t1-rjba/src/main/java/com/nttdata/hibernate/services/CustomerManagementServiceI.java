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
	 * @param newCustomer
	 */
	public void insertNewCustomer(final Customer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedCustomer
	 */
	public void updateCustomer(final Customer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedCustomer
	 */
	public void deleteCustomer(final Customer deletedCustomer);

	/**
	 * Devuelve un cliente mediante su ID.
	 * 
	 * @param customerId
	 */
	public Customer searchById(final Long customerId);

	/**
	 * Devuelve todos los clientes existentes.
	 * 
	 * @return List<Customer>
	 */
	public List<Customer> searchAll();
	
	/**
	 * 
	 * @param name
	 * @param firstLastName
	 * @param secondLastName
	 * @return List<Customer>
	 */
	public List<Customer> searchByNameAndLastName(final String name, String firstLastName, String secondLastName);
}
