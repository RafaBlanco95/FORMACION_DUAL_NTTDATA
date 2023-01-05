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
 * Controlador de la eliminación de clientes 
 * 
 * @author RAFA
 *
 */
@Controller
@RequestMapping("/home/customers/showCustomer/deleteCustomer/")
public class DeleteCustomerController {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * 
	 * Solicitud Get con respuesta a la vista de eliminación de clientes 
	 * 
	 * @return La vista del menu de eliminación de clientes
	 */
	@GetMapping("/")
	public String deleteCustomer() {
		return "/deleteCustomerMenu";
	}

	/**
	 * 
	 * Solicitud Post con respuesta a la vista de cliente eliminado
	 * 
	 * @param newCustomer El cliente que se va a eliminar
	 * @param model El modelo
	 * @param br El binding result
	 * @return La vista de cliente eliminado
	 */
	@PostMapping("/deleteConfirmed")
	public String customerDeleted(@Valid @ModelAttribute("clienteConId") Customer newCustomer, Model model,
			BindingResult br) {

		// Se actualiza el modelo.
		model.addAttribute("newCustomer", newCustomer);

		// Consumición del servicio de gestión de clientes para eliminar un cliente por el id 
		customerService.deleteCustomer(newCustomer.getId());
		
		// Retorno de la vista de cliente eliminado
		return "/customerDeleted";
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
