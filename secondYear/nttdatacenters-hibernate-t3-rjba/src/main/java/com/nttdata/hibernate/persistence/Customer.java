package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase que representa la Entidad (tabla) Cliente
 * 
 * @author RAFA
 *
 */
@Entity
@Table(name = "T_HIBERNATE_CUSTOMER")
public class Customer extends AbstractEntity implements Serializable {
	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Número del documento de identidad */
	private String customerDni;

	/** Identificador numérico del cliente (PK) */
	private Long customerId;

	/** Nombre del cliente */
	private String name;

	/** Primer Apellido del cliente */
	private String firstLastName;

	/** Segundo Apellido del cliente */
	private String secondLastName;

	/** Lista de contratos relacionados */
	private List<Contract> contractList;

	/**
	 * 
	 * @return customerDni
	 */
	@Column(name = "C_CUSTOMER_DNI", unique = true, nullable = false, length = 9)
	public String getCustomerDni() {
		return customerDni;
	}

	/**
	 * @param customerDni El dni del cliente
	 * 
	 */
	public void setCustomerDni(String customerDni) {
		this.customerDni = customerDni;
	}

	/**
	 * @return customerId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CUSTOMER_ID", nullable = false)
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId El identificador numérico del cliente
	 * 
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return name
	 */
	@Column(name = "C_CUSTOMER_NAME", nullable = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name El nombre del cliente
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return firstName
	 */
	@Column(name = "C_CUSTOMER_FIRST_LASTNAME", nullable = false)
	public String getFirstLastName() {
		return firstLastName;
	}

	/**
	 * 
	 * @param firstLastName El primer apellido del cliente
	 */
	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	/**
	 * @return secondLastName
	 */
	@Column(name = "C_CUSTOMER_SECOND_LASTNAME", nullable = false)
	public String getSecondLastName() {
		return secondLastName;
	}

	/**
	 * @param secondLastName El segundo apellido del cliente
	 * 
	 */
	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	/**
	 * @return contractList
	 */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList La lista de contratos asociados al cliente
	 * 
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	/**
	 * Método para obtener el tipo Cliente
	 * 
	 * @return Customer.class La clase Cliente
	 */
	@Transient
	public Class<?> getClase() {
		return Customer.class;
	}

	@Override
	@Transient
	public Long getId() {
		return this.customerId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.customerId = id;
	}

	@Override
	public String toString() {
		return "Cliente [Dni=" + customerDni + ", Id=" + customerId + ", Nombre=" + name + ", Primer Apellido="
				+ firstLastName + ", Segundo Apellido=" + secondLastName + "]";
	}

}
