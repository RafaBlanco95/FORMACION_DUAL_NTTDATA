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
	
	/**
	 * 
	 * @param lastName El apellido del cliente 
	 * @param monthlyCost La fecha de inicio del contrato
	 * @return Una lista de clientes que cumplan con los requisitos de la consulta
	 */
	public List<Contract> searchByLastNameAndContractCost(String lastName, Float monthlyCost);
}
