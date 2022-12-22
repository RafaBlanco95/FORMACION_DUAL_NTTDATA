package com.nttdata.nttdatacentersspringt2rjba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.nttdatacentersspringt2rjba.repository.Order;
import com.nttdata.nttdatacentersspringt2rjba.repository.Product;

/**
 * 
 * Clase de implementación del servicio de envíos fuera de la península ibérica
 * 
 * @author RAFA
 *
 */
@Service("CMCService")
public class DeliveryManagementCMCServiceImpl implements DeliveryManagementServiceI{

	@Override
	public Order createOrder(Long id, String destinatary, String adress) {
		Order order= new Order();
		List <Product> productos = new ArrayList<>();
		order.setId(id);
		order.setAdress(adress);
		order.setDestinatary(destinatary);
		order.setToPeninsula(false);
		order.setProductos(productos);
		return order;
		
	}

	@Override
	public void addProductToOrder(Product product, Order order) {
		product.setPvpCost((product.getNoTaxCost()*4/100)+product.getNoTaxCost());
		List<Product> oldProducts=order.getProductos();
		oldProducts.add(product);
		order.setProductos(oldProducts);
	}


}
