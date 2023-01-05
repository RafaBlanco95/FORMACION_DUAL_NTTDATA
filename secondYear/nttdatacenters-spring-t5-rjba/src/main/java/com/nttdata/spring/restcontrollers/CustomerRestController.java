package com.nttdata.spring.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;


/**
 * 
 * Clase que representa al controlador rest de los clientes en Spring
 * 
 * @author RAFA
 *
 */
@RestController
@RequestMapping("/home/customers/")
public class CustomerRestController {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;
	
	/**
	 * 
	 * Solicitud Get con respuesta a la lista de clientes de la aplicación
	 * 
	 * @return La lista de clientes 
	 */
	@GetMapping("/")
	public List<Customer> showAll() {
		
		// Consumición del servicio de gestión de clientes para obtener la lista de clientes 
		return customerService.getAll();
	}
	
	/**
	 * 
	 * Solicitud Post en la que se añade un cliente a la lista 
	 * 
	 * @param newCustomer El cliente que se va a añadir 
	 * @return Mensaje de cliente añadido con éxito
	 */
	@PostMapping
	public String addCustomer(final @RequestBody Customer newCustomer){
		
		// Consumición del servicio de gestión de clientes para añadir un nuevo cliente con la información de la petición 
		customerService.createNewCustomer(newCustomer);
		return "Cliente Añadido a la Lista";
	}
	
	/**
	 * 
	 * Solicitud Delete en la que se elimina a un cliente de la lista
	 * 
	 * @param id El id del cliente que se va a eliminar
	 * @return Mensaje de cliente eliminado 
	 */
	@DeleteMapping(value="/{id}")
	public String deleteCustomer(final @PathVariable Long id) {
		
		// Consumición del servicio de gestión de clientes para eliminar un cliente por el id de la petición
		customerService.deleteCustomer(id);
		return "Cliente Eliminado de la lista";
	}
	
	/**
	 * 
	 * Solicitud Get en la que se va a consultar un cliente de la lista
	 * 
	 * @param customer El cliente que se quiere consultar 
	 * @return Los clientes que coinciden con la consula
	 */
	@RequestMapping(path="/customer", method=RequestMethod.GET, consumes="application/json")
	public List<Customer> searchByCustomer(@RequestBody Customer customer) {
		
		// Consumición del servicio de gestión de clientes para consultar un cliente por la información de la petición 
		return customerService.findByName(customer.getName());
	}

}
