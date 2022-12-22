package com.nttdata.nttdatacentersspringt2rjba.repository;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * Clase que representa a una entidad de pedido simulada
 * 
 * @author RAFA
 *
 */
public class Order implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** El id del pedido */
	private Long id;
	
	/** El destinatario del pedido */
	private String destinatary;
	
	/** La dirección de entrega del pedido */
	private String adress;
	
	/** Atributo que indica si el pedido se realiza en la península o no */
	private boolean toPeninsula;
	
	/** Lista de productos del pedido */
	private List<Product> productos;

	/**
	 * 
	 * Getter del Id del pedido
	 * 
	 * @return el id del pedido
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Setter del Id del pedido
	 * 
	 * @param id el Id del pedido
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Getter del Destinatario del pedido
	 * 
	 * @return el destinatario del pedido
	 */
	public String getDestinatary() {
		return destinatary;
	}

	/**
	 * 
	 * Setter del Destinatario del pedido
	 * 
	 * @param destinatary el destinatario del pedido
	 */
	public void setDestinatary(String destinatary) {
		this.destinatary = destinatary;
	}

	/**
	 * 
	 * Getter de la dirección de entrega del pedido
	 * 
	 * @return la dirección de entgrega del pedido
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * 
	 * Setter de la dirección de entrega del pedido
	 * 
	 * @param adress La dirección de entrega del pedido
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * 
	 * Getter de si el pedido se hace o no en la península
	 * 
	 * @return Si el pedido se hace o no el la península 
	 */
	public boolean isToPeninsula() {
		return toPeninsula;
	}

	/**
	 * 
	 * Setter de si el pedido se hace o no en la península
	 * 
	 * @param toPeninsula Si el pedido se hace o no en la península
	 */
	public void setToPeninsula(boolean toPeninsula) {
		this.toPeninsula = toPeninsula;
	}

	/**
	 * 
	 * Getter de la lista de productos que tiene el pedido 
	 * 
	 * @return la lista de productos que tiene el pedido
	 */
	public List<Product> getProductos() {
		return productos;
	}

	/**
	 * 
	 * Setter de la lista de productos que tiene el pedido
	 * 
	 * @param productos la lista de productos que tiene el pedido
	 */
	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

}
