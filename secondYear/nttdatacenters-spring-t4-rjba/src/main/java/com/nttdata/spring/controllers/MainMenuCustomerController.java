package com.nttdata.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Clase que representa al controlador de clientes encargado del menú principal
 * de la aplicación
 * 
 * @author RAFA
 *
 */
@Controller
@RequestMapping("/home/customers/")
public class MainMenuCustomerController {

	/**
	 * 
	 * Solicitud con respuesta hacia la vista de Menú
	 * 
	 * @return La vista del menú principal
	 */
	@GetMapping("/")
	public String customerMain() {
		return "/mainMenu";
	}

}
