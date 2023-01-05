package com.nttdata.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * Clase que actúa como Repositorio de Spring Data de la entidad Cliente
 * 
 * @author RAFA
 *
 */
@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long>, CustomerCustomRepository {

	/**
	 * 
	 * Método para encontrar a un cliente por su nombre 
	 * 
	 * @param name El nombre del cliente
	 * @return La lista de clientes que cumplen los requisitos de la consulta
	 */
	List<Customer> findByName(final String name);
	
	/**
	 * 
	 * Método para encontrar a un cliente por su fecha de nacimiento
	 * 
	 * @param birthDate La fecha de nacimiento del cliente
	 * @return La lista de clientes que cumplen los requisitos de la consulta 
	 */
	List<Customer> findByBirthDate(final String birthDate);
	


}
