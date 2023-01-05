package com.nttdata.spring.controllers;

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
 * Controlador de la adición de clientes a la aplicación
 * 
 * @author RAFA
 *
 */
@Controller
@RequestMapping("/home/customers/createNewCustomer/")
public class NewCustomerController {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * 
	 * Solicitud Get con respuesta a la vista del menú de adición de nuevos clientes
	 * 
	 * @return La vista del menú de adición de nuevos clientes
	 */
	@GetMapping("/")
	public String newCustomerMenu() {
		return "/newCustomerMenu";
	}

	/**
	 *
	 * Solicitud Post con respuesta a la vista de mostrar el nuevo cliente
	 * 
	 * @param newCustomer El cliente que se va a añadir 
	 * @param model El modelo
	 * @param br El binding result
	 * @return La vista de mostrar un nuevo cliente 
	 */
	@PostMapping("/createCustomer")
	public String saveCustomer(@Valid @ModelAttribute("clienteNuevito") Customer newCustomer, Model model,
			BindingResult br) {

		// Se actualiza el modelo 
		model.addAttribute("newCustomer", newCustomer);

		// Consumición del servicio de gestión de clientes 
		customerService.createNewCustomer(newCustomer);
		
		// Se retorna la vista de mostrar un nuevo cliente
		return "/showCustomer";
	}

	/**
	 * 
	 * Método que controla las excepciones, retornando la vista de error
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