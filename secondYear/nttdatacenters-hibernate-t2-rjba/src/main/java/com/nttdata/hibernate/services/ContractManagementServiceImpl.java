package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.persistence.ContractDaoI;
import com.nttdata.hibernate.persistence.ContractDaoImpl;
import com.nttdata.hibernate.persistence.Customer;


/**
 * 
 * Clase de implementación de la interfaz del servicio de gestión de Contratos
 * 
 * @author RAFA
 *
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI{
	
	/** DAO: T_HIBERNATE_CONTRACT */
	private ContractDaoI contractDao;

	/**
	 * Método Constructor 
	 * 
	 * @param session
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(final Contract newContract) {

		// Verificación de nulidad e inexistencia
		if (newContract != null && newContract.getContractId() == null) {

			// Insercción del nuevo contrato
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(final Contract updatedContract) {

		// Verificación de nulidad y existencia
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Actualización del contrato
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(final Contract deletedContract) {

		// Verificación de nulidad y existencia.
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Eliminación del contrato.
			contractDao.delete(deletedContract);
		}

	}

	@Override
	public Contract searchById(final Long contractId) {

		// Resultado.
		Contract contract = null;

		// Verificación de nulidad.
		if (contractId != null) {

			// Obtención del contrato por ID.
			contract = contractDao.searchById(contractId);
		}

		return contract;
	}

	@Override
	public List<Contract> searchAll() {
		
		// Obtención de todos los clientes.
		return contractDao.searchAll();
	}
	@Override
	public List<Contract> searchByCustomerId(Customer customer){
		
		//Obtención de los contratos por cliente asociado
		return contractDao.searchByCustomerId(customer);
	}
	
}
