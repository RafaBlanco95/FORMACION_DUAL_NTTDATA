package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * Clase que representa a la entidad (tabla) Contrato
 * 
 * @author RAFA
 *
 */
@Entity
@Table(name = "T_HIBERNATE_CONTRACT")
public class Contract extends AbstractEntity implements Serializable{
	
	/**Serial Version */
	private static final long serialVersionUID = 1L;
	
	/*Identificador numérico del contrato (PK)*/
	private Long contractId;
	
	/**Fecha de vigencia*/
	private Date startingDate;
	
	/**Fecha de caducidad*/
	private Date expirationDate;
	
	/**Precio mensual del contrato */
	private Double monthlyCost;
	
	/**Cliente del contrato*/
	private Customer customer;
	
	/**
	 * 
	 * @return contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_CONTRACT_ID", nullable = false)
	public Long getContractId() {
		return contractId;
	}
	
	/**
	 * 
	 * @param contractId El Identificador numérico del contrato
	 */
	public void setContractId(Long contractId){
		this.contractId=contractId;
	}
	
	/**
	 * 
	 * @return startingDate
	 */
	@Column(name = "C_STARTING_DATE", nullable = false)
	public Date getStartingDate() {
		return startingDate;
	}
	
	/**
	 * 
	 * @param startingDate La fecha de inicio del contrato
	 */
	public void setStartingDate(Date startingDate) {
		this.startingDate=startingDate;
	}
	
	/**
	 * 
	 * @return expirationDate
	 */
	@Column(name = "C_EXPIRATION_DATE", nullable = false)
	public Date getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * 
	 * @param expirationDate La fecha de caducidad del contrato
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate=expirationDate;
	}
	
	/**
	 * 
	 * @return monthlyCost
	 */
	@Column(name = "C_MONTHLY_COST", nullable = false)
	public Double getMonthlyCost() {
		return monthlyCost;
	}
	
	/**
	 * 
	 * @param monthlyCost El precio mensual del contrato 
	 */
	public void setMonthlyCost(Double monthlyCost) {
		this.monthlyCost=monthlyCost;
	}
	
	/**
	 * @return customer El cliente asociado al contrato
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "C_CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer El cliente asociado al contrato 
	 *            
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Método para obtener el tipo Contrato 
	 * 
	 * @return Contract.class La clase Contrato
	 */
	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	@Transient
	public Long getId() {
		return this.contractId;
	}

	@Override
	@Transient
	public void setId(Long id) {
		this.contractId = id;
	}
}
