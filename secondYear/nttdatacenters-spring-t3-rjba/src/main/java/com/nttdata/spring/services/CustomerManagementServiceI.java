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
}
