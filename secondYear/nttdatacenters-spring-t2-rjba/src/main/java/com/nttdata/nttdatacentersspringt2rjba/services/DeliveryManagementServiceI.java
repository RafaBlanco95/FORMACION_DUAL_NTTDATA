package com.nttdata.nttdatacentersspringt2rjba.services;

import com.nttdata.nttdatacentersspringt2rjba.repository.Order;
import com.nttdata.nttdatacentersspringt2rjba.repository.Product;

/**
 * 
 * Interfaz del servicio de envío de los pedidos
 * 
 * @author RAFA
 *
 */
public interface DeliveryManagementServiceI {


	/**
	 * 
	 * Método para crear un pedido
	 * 
	 * @param id El Id del pedido
	 * @param destinatary El destinatario del pedido
	 * @param adress La dirección de envío del pedido
	 * @return el pedido generado
	 */
	public Order createOrder(Long id, String destinatary, String adress);

	/**
	 * 
	 * Método para asociar un producto a un pedido
	 * 
	 * @param product el producto que se va a añadir al método
	 * @param order   el pedido donde se va a añadir el método
	 */
	public void addProductToOrder(Product product, Order order);
}
