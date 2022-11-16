package com.nttdata.hibernate;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;
import com.nttdata.hibernate.services.ContractManagementServiceI;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.hibernate.services.CustomerManagementServiceI;
import com.nttdata.hibernate.services.CustomerManagementServiceImpl;

/**
 * Clase Principal
 * 
 * @author RAFA
 *
 */
public class HibernateMain {
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(HibernateMain.class);

	/**
	 * Método principal desde el que se genera la conexión a la base de datos
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		// Log de inicio
		LOG.info("Método: main() | TRAZA DE INICIO");

		// Apertura de sesión.
		final Session session = HibernateUtil.getSessionFactory().openSession();

		LOG.info("Método: main() | SESIÓN ABIERTA CON LA BBDD");

		// Inicialización del servicio.
		final CustomerManagementServiceI customerService = new CustomerManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Inicialización del String builder que se va a mostrar en los logs
		final StringBuilder sbu = new StringBuilder();

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

		// Consumición del Servicio para Insertar los Clientes
		sbu.append("Método: main() | Llamada al método insertNewCustomer() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		customerService.insertNewCustomer(customer1);
		customerService.insertNewCustomer(customer2);
		customerService.insertNewCustomer(customer3);

		// Consumición del Servicio para Mostrar todos los Clientes de la tabla
		List<Customer> allCustomers = customerService.searchAll();
		sbu.append("Método: main() | Llamada al método searchAll() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		for (Customer customer : allCustomers) {
			sbu.append(customer.getCustomerId());
			sbu.append(" | ");
			sbu.append(customer.getName());
			sbu.append(" | ");
			sbu.append(customer.getFirstLastName());
			sbu.append(" | ");
			sbu.append(customer.getSecondLastName());
			sbu.append(" | ");
			sbu.append(customer.getCustomerDni());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Consumición del Servicio para Actualizar un Cliente
		sbu.append("Método: main() | Llamada al método updateCustomer() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		customer2.setFirstLastName("Blanco");
		customer2.setSecondLastName("Aranda");
		customerService.updateCustomer(customer2);

		// Consumición del Servicio para Buscar un Cliente por su Id
		sbu.append("Método: main() | Llamada al método searchById() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		Customer customerSearchedById = customerService.searchById(2L);
		sbu.append(customerSearchedById.getCustomerId());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getFirstLastName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getSecondLastName());
		sbu.append(" | ");
		sbu.append(customerSearchedById.getCustomerDni());
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Consumición del Servicio para Buscar un Cliente por su Nombre, Primer
		// Apellido y Segundo Apellido
		sbu.append("Método: main() | Llamada al método searchByNameAndLastName() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		List<Customer> searchedByNameCustomers = customerService.searchByNameAndLastName("Rafael Jaime", "Blanco",
				"Aranda");
		for (Customer customer : searchedByNameCustomers) {
			sbu.append(customer.getCustomerId());
			sbu.append(" | ");
			sbu.append(customer.getName());
			sbu.append(" | ");
			sbu.append(customer.getFirstLastName());
			sbu.append(" | ");
			sbu.append(customer.getSecondLastName());
			sbu.append(" | ");
			sbu.append(customer.getCustomerDni());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Consumición del Servicio para Eliminar un Cliente
		customerService.deleteCustomer(customer1);

		// Consumición del Servicio para Mostrar todos los Clientes de la tabla
		sbu.append("Método: main() | Llamada al método searchAll() de customerService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		List<Customer> allUpdatedCustomers = customerService.searchAll();
		for (Customer customer : allUpdatedCustomers) {
			sbu.append(customer.getCustomerId());
			sbu.append(" | ");
			sbu.append(customer.getName());
			sbu.append(" | ");
			sbu.append(customer.getFirstLastName());
			sbu.append(" | ");
			sbu.append(customer.getSecondLastName());
			sbu.append(" | ");
			sbu.append(customer.getCustomerDni());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Generación de Contratos
		Contract contract1 = new Contract();
		contract1.setStartingDate(
				Date.from(LocalDate.of(2021, Month.APRIL, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract1.setExpirationDate(
				Date.from(LocalDate.of(2025, Month.MARCH, 31).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract1.setMonthlyCost(100d);
		contract1.setCustomer(customer2);
		contract1.setUpdatedDate(updatedDate);
		contract1.setUpdatedUser(updatedUser);

		Contract contract2 = new Contract();
		contract2.setStartingDate(
				Date.from(LocalDate.of(2020, Month.JUNE, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract2.setExpirationDate(
				Date.from(LocalDate.of(2022, Month.DECEMBER, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract2.setMonthlyCost(200d);
		contract2.setCustomer(customer2);
		contract2.setUpdatedDate(updatedDate);
		contract2.setUpdatedUser(updatedUser);

		Contract contract3 = new Contract();
		contract3.setStartingDate(
				Date.from(LocalDate.of(2017, Month.SEPTEMBER, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract3.setExpirationDate(
				Date.from(LocalDate.of(2024, Month.OCTOBER, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contract3.setMonthlyCost(300d);
		contract3.setCustomer(customer3);
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);

		// Consumición del Servicio para Insertar los Contratos
		sbu.append("Método: main() | Llamada al método insertNewContract() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);

		// Consumición del Servicio para Mostrar todos los Clientes de la tabla
		sbu.append("Método: main() | Llamada al método searchAll() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		List<Contract> allContracts = contractService.searchAll();
		for (Contract contract : allContracts) {
			sbu.append(contract.getContractId());
			sbu.append(" | ");
			sbu.append(contract.getStartingDate());
			sbu.append(" | ");
			sbu.append(contract.getExpirationDate());
			sbu.append(" | ");
			sbu.append(contract.getMonthlyCost());
			sbu.append(" | ");
			sbu.append(contract.getCustomer());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Consumición del Servicio para Actualizar un Contrato
		sbu.append("Método: main() | Llamada al método updateContract() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		contract2.setMonthlyCost(500d);
		contract2.setStartingDate(
				Date.from(LocalDate.of(1995, Month.JULY, 4).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		contractService.updateContract(contract2);

		// Consumición del Servicio para Buscar un Contrato por su Id
		sbu.append("Método: main() | Llamada al método searchById() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		Contract contractSearchedById = contractService.searchById(4L);
		sbu.append(contractSearchedById.getContractId());
		sbu.append(" | ");
		sbu.append(contractSearchedById.getStartingDate());
		sbu.append(" | ");
		sbu.append(contractSearchedById.getExpirationDate());
		sbu.append(" | ");
		sbu.append(contractSearchedById.getMonthlyCost());
		sbu.append(" | ");
		sbu.append(contractSearchedById.getCustomer());
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Consumición del Servicio para Buscar un Contrato por el Identificador
		// numérico del cliente
		sbu.append("Método: main() | Llamada al método searchByCustomerId() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		List<Contract> contractSearchedByCustomerId = contractService.searchByCustomerId(customer2);
		for (Contract contract : contractSearchedByCustomerId) {
			sbu.append(contract.getContractId());
			sbu.append(" | ");
			sbu.append(contract.getStartingDate());
			sbu.append(" | ");
			sbu.append(contract.getExpirationDate());
			sbu.append(" | ");
			sbu.append(contract.getMonthlyCost());
			sbu.append(" | ");
			sbu.append(contract.getCustomer().toString());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Consumición del Servicio para Eliminar un Contrato

		contractService.deleteContract(contract3);

		// Consumición del Servicio para Mostrar todos los Contratos de la tabla
		sbu.append("Método: main() | Llamada al método searchAll() de contractService");
		LOG.info("{}", sbu);
		sbu.setLength(0);
		List<Contract> allContract = contractService.searchAll();
		for (Contract contract : allContract) {
			sbu.append(contract.getContractId());
			sbu.append(" | ");
			sbu.append(contract.getStartingDate());
			sbu.append(" | ");
			sbu.append(contract.getExpirationDate());
			sbu.append(" | ");
			sbu.append(contract.getMonthlyCost());
			sbu.append(" | ");
			sbu.append(contract.getCustomer());
			LOG.info("{}", sbu);
			sbu.setLength(0);
		}

		// Cierre de sesión.
		session.close();

		// Log de final de traza
		LOG.info("Método: main() | FIN DE TRAZA");
	}
}
