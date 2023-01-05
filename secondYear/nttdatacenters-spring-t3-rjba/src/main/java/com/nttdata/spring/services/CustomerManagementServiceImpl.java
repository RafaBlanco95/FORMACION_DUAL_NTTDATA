package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;

/**
 * 
 * Clase de implementación de la interfaz del servicio de clientes 
 * 
 * @author RAFA
 *
 */
@Service
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {
	
	/* Inyección del Repositorio de Clientes */
	@Autowired
	private CustomerRepositoryI customerRepo;
	
	@Override
	public List<Customer> findByNameAndLastName(String name, String lastName) {
		
		return customerRepo.findByNameAndLastName(name, lastName);
	}

}
