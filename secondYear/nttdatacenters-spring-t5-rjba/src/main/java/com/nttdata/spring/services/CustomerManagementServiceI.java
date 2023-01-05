package com.nttdata.spring.services;

import java.util.List;


import com.nttdata.spring.repository.Customer;

/**
 * 
 * Interfaz del servicio de gestión de Clientes
 * 
 * @author RAFA
 *
 */
public interface CustomerManagementServiceI {
	
	/**
	 * 
	 * Método que buca clientes por su nombre completo (nombre y apellidos)
	 * 
	 * @param name El nombre del Cliente
	 * @param lastName Los apellidos del Cliente
	 * @return La lista de clientes que cumplen con las condiciones de la consulta
	 */
	List<Customer> findByNameAndLastName(final String name, final String lastName);
	
	/**
	 * 
	 * Método que crea nuevos clientes en el repositorio
	 * 
	 * @param customer El nuevo cliente 
	 */
	void createNewCustomer(final Customer customer);
	
	/**
	 * 
	 * Método para obtener todos los clientes del repositorio
	 * 
	 * @return La lista de clientes del repositorio
	 */
	List<Customer> getAll();
	

	/**
	 * 
	 * Método para eliminar un cliente por su id
	 * 
	 * @param customerId El id del cliente que se va a eliminar
	 */
	void deleteCustomer(final Long customerId);
	
	/**
	 * 
	 * Método para encontrar los clientes que comparten el nombre
	 * 
	 * @param name El nombre de los clientes
	 * @return La lista de clientes con el nombre especificado
	 */
	List<Customer> findByName(final String name);
	


}
