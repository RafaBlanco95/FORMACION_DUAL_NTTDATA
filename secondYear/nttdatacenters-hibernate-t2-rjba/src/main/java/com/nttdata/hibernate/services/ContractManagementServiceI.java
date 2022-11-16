package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.Customer;

/**
 * 
 * Interfaz del servicio de Contratos
 * 
 * @author RAFA
 *
 */
public interface ContractManagementServiceI {
	/**
	 * Inserta un nuevo contrato
	 * 
	 * @param newContract Nuevo contrato
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Actualiza un contrato existente.
	 * 
	 * @param updatedContract Contrato actualizado
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Elimina un contrato existente.
	 * 
	 * @param deletedContract Contrato eliminado
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Devuelve un contrato a través de su ID.
	 * 
	 * @param contractId Identificador numérico del contrato 
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Devuelve todos los contratos existentes.
	 * 
	 * @return Lista de todos los contratos presentes en la BBDD
	 */
	public List<Contract> searchAll();
	
	/**
	 * 
	 * @param customer El identificador numérico del cliente
	 * @return Lista de contratos asociados al cliente
	 */
	public List<Contract> searchByCustomerId(Customer customer);
}
