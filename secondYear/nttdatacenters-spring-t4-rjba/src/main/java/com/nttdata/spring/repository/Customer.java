package com.nttdata.spring.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Clase que representa a la entidad Cliente en Spring Data
 * 
 * @author RAFA
 *
 */
@Entity
@Table(name="T_CUSTOMER")
public class Customer implements Serializable  {

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** ID (PrimaryKey) */
	private Long id;
	
	/** Nombre del Cliente */
	private String name;
	
	/** Apellidos del Cliente */
	private String lastName;
	
	/** Fecha de nacimiento del Cliente */
	private String birthDate;
	
	/** DNI del Cliente */
	private int dni;

	/**
	 * 
	 * Getter del Id del cliente 
	 * 
	 * @return El Id del cliente 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_ID")
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * Setter del Id del cliente
	 * 
	 * @param id El id del cliente
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 
	 * Setter del nombre del cliente
	 * 
	 * @return el nombre del cliente 
	 */
	@Column(name = "C_NAME")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Getter del nombre del cliente
	 * 
	 * @param name El nombre del cliente
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Getter de los apellidos del cliente
	 * 
	 * @return Los apeliidos del cliente
	 */
	@Column(name = "C_LASTNAME")
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * Setter de los apellidos del cliente
	 * 
	 * @param lastName Los apellidos del cliente
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * Getter de la fecha de nacimiento del cliente
	 * 
	 * @return La fecha de nacimiento del cliente
	 */
	@Column(name = "C_BIRTHDATE")
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * 
	 * Setter de la fecha de nacimiento del cliente 
	 * 
	 * @param birthDate La fecha de nacimiento del cliente
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * 
	 * Getter del DNI del cliente
	 * 
	 * @return El DNI del cliente
	 */
	@Column(name = "C_DNI")
	public int getDni() {
		return dni;
	}

	/**
	 * 
	 * Setter del DNI del cliente 
	 * 
	 * @param dni El DNI del cliente
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

}
