package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * 
 * Clase de implementación del DAO de Contrato
 * 
 * @author RAFA
 *
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {
	
	/** Sesión de conexión a BBDD */
	private Session session;

	/**
	 * 
	 * @param session La sesión de conexión a BBDD
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByCustomerId(Customer customer){
		
		return session.createQuery("FROM Contract WHERE customer='"+ customer.getCustomerId()+"'").list();
		
}
}
