package com.nttdata.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;



/**
 *Clase Principal  
 * 
 * @author RAFA
 *
 */
public class HibernateMain 
{
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(HibernateMain.class);
	
	/**
	 * Método principal desde el que se genera la conexión a la base de datos
	 * @param args
	 */
    public static void main( String[] args )
    {
    	LOG.info("Método: main() | TRAZA DE INICIO");
    	
    	// Apertura de sesión.
    	final Session session = HibernateUtil.getSessionFactory().openSession();
    	
    	LOG.info("Método: main() | SESIÓN ABIERTA CON LA BBDD");
    	
    	// Inicialización del servicio.
    	final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);
    	
    	// Auditoría.
    	final String updatedUser = "SYSTEM";
    	final Date updatedDate = new Date();
    	
    	// Generación de clientes.
    	Customer customer1 = new Customer();
    	customer1.setCustomerDni("77889911A");
    	customer1.setName("Juan Alejandro");
    	customer1.setFirstLastName("Téllez");
    	customer1.setSecondLastName("Rubio");
    	customer1.setUpdatedDate(updatedDate);
    	customer1.setUpdatedUser(updatedUser);
    	
    	Customer customer2 = new Customer();
    	customer2.setCustomerDni("77817070C");
    	customer2.setName("Rafael Jaime");
    	customer2.setFirstLastName("Blando");
    	customer2.setSecondLastName("Naranja");
    	customer2.setUpdatedDate(updatedDate);
    	customer2.setUpdatedUser(updatedUser);
    	
    	Customer customer3 = new Customer();
    	customer3.setCustomerDni("12345678T");
    	customer3.setName("Joaquín Matías");
    	customer3.setFirstLastName("Aguirre");
    	customer3.setSecondLastName("Oceja");
    	customer3.setUpdatedDate(updatedDate);
    	customer3.setUpdatedUser(updatedUser);
    	
    	
    	// Consumición del Servicio	para Insertar los Clientes
    	customerService.insertNewCustomer(customer1);
    	customerService.insertNewCustomer(customer2);
    	customerService.insertNewCustomer(customer3);
    	
    	// Consumición del Servicio	para Mostrar todos los Clientes de la tabla 
    	List<Customer> allCustomers=customerService.searchAll();
    	final StringBuilder sbu = new StringBuilder(80);
    	for(Customer customer:allCustomers) {
    		sbu.append(customer.getName());
    		sbu.append(" | ");
    		sbu.append(customer.getFirstLastName());
    		sbu.append(" | ");
    		sbu.append(customer.getSecondLastName());
    		sbu.append(" | ");
    		sbu.append(customer.getCustomerDni());
    		LOG.info("{}",sbu);
    		sbu.setLength(0);
    	}
    	
    	
    	// Consumición del Servicio	para Actualizar un Cliente
    	customer2.setFirstLastName("Blanco");
    	customer2.setSecondLastName("Aranda");
    	customerService.updateCustomer(customer2);
    	
    	// Consumición del Servicio	para Buscar un Cliente por su Id
    	Customer customerSearchedById=customerService.searchById(2L);
    	sbu.append(customerSearchedById.getName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getFirstLastName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getSecondLastName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getCustomerDni());
    	LOG.info("{}",sbu);
    	sbu.setLength(0);
    	
    	// Consumición del Servicio	para Buscar un Cliente por su Id
    	List<Customer> searchedByNameCustomers=customerService.searchByNameAndLastName("Rafael Jaime", "Blanco", "Aranda");
    	for(Customer customer:searchedByNameCustomers) {
    		sbu.append(customer.getCustomerId());
    		sbu.append(" | ");
    		sbu.append(customer.getCustomerDni());
    		LOG.info(sbu.toString());
    		sbu.setLength(0);
    	}

    	// Consumición del Servicio	para Eliminar un Cliente
    	customerService.deleteCustomer(customer1);
    	
    	// Cierre de sesión.
    	session.close();
    	
    	LOG.info("Método: main() | FIN DE TRAZA");
    }
}
