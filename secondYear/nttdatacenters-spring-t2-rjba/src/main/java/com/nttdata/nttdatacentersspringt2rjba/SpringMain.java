package com.nttdata.nttdatacentersspringt2rjba;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.nttdatacentersspringt2rjba.repository.Order;
import com.nttdata.nttdatacentersspringt2rjba.repository.Product;
import com.nttdata.nttdatacentersspringt2rjba.services.DeliveryManagementServiceI;

/**
 * 
 * Clase principal de la aplicación
 * 
 * @author RAFA
 *
 */
@SpringBootApplication
public class SpringMain implements CommandLineRunner {

	/** Inicialización de los servicios */
	@Autowired
	@Qualifier("peninsulaService")
	private DeliveryManagementServiceI peninsulaService;

	@Autowired
	@Qualifier("CMCService")
	private DeliveryManagementServiceI exteriorService;

	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	/** String builder que se va a mostrar en los logs */
	final StringBuilder sbu = new StringBuilder();

	/**
	 * 
	 * Método principal de la aplicación
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

		// Consumición de los servicios para generar dos pedidos diferentes
		sbu.append("Método: main() | Consumición de los servicios para generar pedidos");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Creación de un pedido que se entregará dentro de la península
		Order orderIn = peninsulaService.createOrder(0001L, "Juan Alejandro Téllez Rubio",
				"Calle Ave del Paraíso, nº2, 3ºC");

		sbu.append("Método: main() | Llamada al método createOrder() de peninsulaService");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Creación de un pedido que se entregará fuera de la península
		Order orderOut = exteriorService.createOrder(0002L, "Joaquín Matías Aguirre Oceja",
				"Calle Mirador de Montepinar, nº34, 5ºA");

		sbu.append("Método: main() | Llamada al método createOrder() de exteriorService");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Creación de productos
		Product productIn = new Product();
		productIn.setId(111L);
		productIn.setName("Bicicleta");
		productIn.setNoTaxCost(100d);

		Product productOut = new Product();
		productOut.setId(111L);
		productOut.setName("Melocotón");
		productOut.setNoTaxCost(1d);

		// Adición de un producto al pedido peninsular
		peninsulaService.addProductToOrder(productIn, orderIn);
		sbu.append("Método: main() | Llamada al método addProductToOrder() de peninsulaService");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Consulta del precio PVP del producto del pedido peninsular
		List<Product> productsOrderIn = orderIn.getProductos();
		for (Product product : productsOrderIn) {
			sbu.append(product.getName());
			sbu.append(" | ");
			sbu.append(product.getNoTaxCost());
			sbu.append(" | ");
			sbu.append(product.getPvpCost());
			LOG.info("{}", sbu);
			sbu.setLength(0);

		}

		// Adición de un producto al pedido extrapeninsular
		exteriorService.addProductToOrder(productOut, orderOut);
		sbu.append("Método: main() | Llamada al método addProductToOrder() de exteriorService");
		LOG.info("{}", sbu);
		sbu.setLength(0);

		// Consulta del precio PVP del producto del pedido peninsular
		List<Product> productsOrderOut = orderOut.getProductos();
		for (Product product : productsOrderOut) {
			sbu.append(product.getName());
			sbu.append(" | ");
			sbu.append(product.getNoTaxCost());
			sbu.append(" | ");
			sbu.append(product.getPvpCost());
			LOG.info("{}", sbu);
			sbu.setLength(0);

		}

	}

}
