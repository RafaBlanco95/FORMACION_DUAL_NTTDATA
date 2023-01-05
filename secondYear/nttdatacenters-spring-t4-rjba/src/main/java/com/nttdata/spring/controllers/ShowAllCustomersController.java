package com.nttdata.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.services.CustomerManagementServiceI;

/**
 * 
 * Controlador de la parte de la aplicación que se encarga de mostrar los
 * clientes
 * 
 * @author RAFA
 *
 */
@Controller
@RequestMapping("/home/customers/showCustomer/")
public class ShowAllCustomersController {

	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;

	/**
	 * 
	 * Solicitud Get con respuesta a la vista de mostrar todos los clientes
	 * 
	 * @param modelAndView El modelo
	 * @return La vista de mostrar todos los clientes
	 */
	@GetMapping("/")
	public String showAllCustomer(Model modelAndView) {

		// Consumición del servicio de gestión de clientes para encontrar todos los
		// clientes
		List<Customer> customers = customerService.getAll();

		// Se actualiza el modelo
		modelAndView.addAttribute("customers", customers);

		// Se retorna la vista que muestra todos los clientes
		return "/showAllCustomer";
	}
}
