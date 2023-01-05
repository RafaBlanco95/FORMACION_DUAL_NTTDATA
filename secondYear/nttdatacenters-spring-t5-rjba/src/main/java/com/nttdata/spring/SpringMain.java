package com.nttdata.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Customer;
import com.nttdata.spring.repository.CustomerRepositoryI;
import com.nttdata.spring.services.CustomerManagementServiceI;


/**
 * 
 * Clase principal de la aplicación 
 * 
 * @author RAFA
 *
 */
@SpringBootApplication
public class SpringMain implements CommandLineRunner{

	/** Repositorio de Clientes */
	@Autowired
	private CustomerRepositoryI customerRepository;
	
	/** Servicio de gestión de clientes */
	@Autowired
	private CustomerManagementServiceI customerService;
	
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	/** String builder que se va a mostrar en los logs */
	final StringBuilder sbu = new StringBuilder();
	
	/**
	 * 
	 * Método principal de la clase 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Log de inicio
		LOG.info("Método: main() | TRAZA DE INICIO");
		
		SpringApplication.run(SpringMain.class, args);
		
		// Log de final de traza
		LOG.info("Método: main() | FIN DE TRAZA");
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Declaración e inicialización de los clientes
		sbu.append("Método: main() | Generación de clientes para incluirlos al repositorio");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		
		final Customer c1 = new Customer();
		c1.setName("Rafael Jaime");
		c1.setLastName("Blanco Aranda");
		c1.setBirthDate("04-07-1995");
		c1.setDni(77817070);
		

		final Customer c2 = new Customer();
		c2.setName("Juan Alejandro");
		c2.setLastName("Téllez Rubio");
		c2.setBirthDate("09-11-1990");
		c2.setDni(70707070);

		// Consumición del repositorio para guardar los registros de clientes 
		sbu.append("Método: main() | Llamada al método save() del repositorio customerRepository");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		customerRepository.save(c1);
		customerRepository.save(c2);

		// Consumición del repositorio para contabilizar el número de registros que se han añadido  
		sbu.append("Método: main() | Llamada al método count() del repositorio customerRepository");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		sbu.append("Método: main() | Hay añadidos: " + customerRepository.count() + " registros.");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		
		// Consulta de los clientes cuyo nombre es "Rafael Jaime"
		sbu.append("Método: main() | Llamada al método findByName() del repositorio customerRepository");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		final List<Customer> customers = customerRepository.findByName("Rafael Jaime");
		for (final Customer customer : customers) {
			sbu.append(customer.getName());
			sbu.append(" | ");
			sbu.append(customer.getLastName());
			sbu.append(" | ");
			sbu.append(customer.getBirthDate());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}
		
		// Consulta de los clientes cuyo nombre es "Juan Alejandro" y sus apellidos "Téllez Rubio"
		sbu.append("Método: main() | Llamada al método findByNameAndLastName() del servicio customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		final List<Customer> customersFromService=customerService.findByNameAndLastName("Juan Alejandro", "Téllez Rubio");
		for (Customer customer: customersFromService) {
			sbu.append(customer.getName());
			sbu.append(" | ");
			sbu.append(customer.getLastName());
			sbu.append(" | ");
			sbu.append(customer.getBirthDate());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}
	}

}
