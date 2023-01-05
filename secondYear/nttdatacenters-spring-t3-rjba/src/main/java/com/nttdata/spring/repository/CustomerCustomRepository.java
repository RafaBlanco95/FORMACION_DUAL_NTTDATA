package com.nttdata.spring.repository;

import java.util.List;

/**
 * 
 * Repositorio con métodos personalizados para la clase Cliente
 * 
 * @author RAFA
 *
 */
public interface CustomerCustomRepository {

	/**
	 * 
	 * Método que busca un cliente por su nombre completo
	 * 
	 * @param name El nombre del cliente
	 * @param lastName Los apellidos del cliente
	 * @return La lista de clientes qeu cumplen los requisitos de la consulta
	 */
	public List<Customer> findByNameAndLastName(final String name,final String lastName);
}
