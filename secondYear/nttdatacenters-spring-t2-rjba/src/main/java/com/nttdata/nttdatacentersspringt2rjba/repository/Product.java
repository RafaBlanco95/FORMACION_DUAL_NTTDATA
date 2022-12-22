package com.nttdata.nttdatacentersspringt2rjba.repository;

import java.io.Serializable;

/**
 * 
 * Clase que representa a una entidad de producto simulada 
 * 
 * @author RAFA
 *
 */
public class Product implements Serializable{

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador del producto */
	private Long id;
	
	/** Nombre del producto */
	private String name;
	
	/** Precio PVP del producto */
	private Double pvpCost;
	
	/** Precio sin impuestos del producto */
	private Double noTaxCost;

	
	/**
	 * 
	 * Getter del Id del producto
	 * 
	 * @return id del producto
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Setter del Id del producto
	 * 
	 * @param id Id del producto
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Getter del nombre del producto 
	 * 
	 * @return nombre del producto
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Setter del nombre del producto
	 * 
	 * @param name nombre del producto 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Getter del precio PVP del producto 
	 * 
	 * @return el precio PVP del producto 
	 */
	public Double getPvpCost() {
		return pvpCost;
	}

	/**
	 * 
	 * Setter del precio PVP del prodcuto
	 * 
	 * @param pvpCost el precio PVP del producto
	 */
	public void setPvpCost(Double pvpCost) {
		this.pvpCost = pvpCost;
	}

	/**
	 * 
	 * Getter del precio sin impuestos
	 * 
	 * @return el precio sin impuestos del producto 
	 */
	public Double getNoTaxCost() {
		return noTaxCost;
	}

	/**
	 * 
	 * Setter del precio sin impuestos
	 * 
	 * @param noTaxCost el precio sin impuestos del producto
	 */
	public void setNoTaxCost(Double noTaxCost) {
		this.noTaxCost = noTaxCost;
	}
}
