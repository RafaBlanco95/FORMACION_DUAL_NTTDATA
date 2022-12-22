package com.nttdata.nttdatacentersspringt2rjba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.nttdatacentersspringt2rjba.repository.Order;
import com.nttdata.nttdatacentersspringt2rjba.repository.Product;

/**
 * 
 * Clase de implementación de la interfaz del servicio de envíos a la península
 * 
 * @author RAFA
 *
 */
@Service("peninsulaService")
public class DeliveryManagementPeninsulaServiceImpl implements DeliveryManagementServiceI{

	@Override
	public Order createOrder(Long id, String destinatary, String adress) {
		Order order= new Order();
		List <Product> productos = new ArrayList<>();
		order.setId(id);
		order.setAdress(adress);
		order.setDestinatary(destinatary);
		order.setToPeninsula(true);
		order.setProductos(productos);
		return order;
	}

	@Override
	public void addProductToOrder(Product product, Order order) {
		product.setPvpCost((product.getNoTaxCost()*21/100)+product.getNoTaxCost());
		List<Product> oldProducts=order.getProductos();
		oldProducts.add(product);
		order.setProductos(oldProducts);
	}



}
