package com.nttdata.hibernate.services;

import java.util.List;
import org.hibernate.Session;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.persistence.CustomerDaoI;
import com.nttdata.hibernate.persistence.CustomerDaoImpl;


/**
 * Clase de implementación de la interfaz del servicio de gestión de los clientes 
 * @author RAFA
 *
 */
public class CustomerManagementServiceImpl implements CustomerManagementServiceI {
	
	/** DAO: HIBERNATE_CUSTOMER */
	private CustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public CustomerManagementServiceImpl(final Session session) {
		this.customerDao = new CustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(final Customer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo cliente.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(final Customer updatedCustomer) {

		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del cliente.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(final Customer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminación del cliente.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public Customer searchById(final Long customerId) {

		// Resultado.
		Customer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del cliente por ID.
			customer = customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<Customer> searchAll() {
		
		// Obtención de todos los clientes.
		return customerDao.searchAll();
	}
	
	@Override
	public List<Customer> searchByNameAndLastName(final String name, String firstLastName, String secondLastName){
		
		// Obtención de clientes por nombre y apellidos.
		return customerDao.searchByNameAndLastName(name,firstLastName,secondLastName);
	}
}
