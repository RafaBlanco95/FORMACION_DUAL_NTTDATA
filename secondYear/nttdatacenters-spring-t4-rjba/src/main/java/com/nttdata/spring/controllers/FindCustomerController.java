package com.nttdata.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * 
 * Controlador de la búsqueda de clientes
 * 
 * @author RAFA
 *
 */
@Controller
@RequestMapping("/home/customers/findCustomer/")
public class FindCustomerController {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * 
	 * Solicitud Get con respuesta a la vista del menú de encontrar clientes por su
	 * nombre
	 * 
	 * @return La vista del menú de búsqueda de clientes por su nombre
	 */
	@GetMapping("/")
	public String newCustomerMenu() {
		return "/findCustomerByNameMenu";
	}

	/**
	 * 
	 * Solicitud Post con respuesta a la vista de los clientes encontrados
	 * 
	 * @param newCustomer El cliente que se busca
	 * @param model       El modelo
	 * @param br          El binding result
	 * @return La vista que muestra los clientes encontrados en la búsqueda
	 */
	@PostMapping("/customerFounded")
	public String saveCustomer(@Valid @ModelAttribute("clienteConNombre") Customer newCustomer, Model model,
			BindingResult br) {

		// Consumición del servicio de gestión de clientes para buscar clientes por su
		// nombre
		List<Customer> namedCustomers = customerService.findByName(newCustomer.getName());

		// Se actualiza el modelo
		model.addAttribute("namedCustomers", namedCustomers);

		// Se retorna la vista que muestra a los clientes encontrados en la búsqueda
		return "/customerFoundedList";
	}

	/**
	 * 
	 * Método que comprueba las excepciones, retornando la vista de error
	 * 
	 * @param br El binding result
	 * @return La vista de errores
	 */
	@ExceptionHandler(BindException.class)
	public String checkExceptions(BindingResult br) {

		// Resultado
		String output = "";

		// Verificación de errores.
		if (br.hasErrors()) {

			output = "/showErrorView";

		}

		return output;
	}

}
