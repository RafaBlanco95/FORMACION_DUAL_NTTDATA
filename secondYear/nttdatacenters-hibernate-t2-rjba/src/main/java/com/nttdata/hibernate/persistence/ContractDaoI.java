package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * 
 * DAO de la tabla Contrato
 * 
 * @author RAFA
 *
 */
public interface ContractDaoI extends CommonDaoI<Contract>{
	
	/**
	 * 
	 * @param customer El identificador numérico del cliente
	 * @return Lista de contratos asociados al cliente
	 */
	public List<Contract> searchByCustomerId(Customer customer);
}
