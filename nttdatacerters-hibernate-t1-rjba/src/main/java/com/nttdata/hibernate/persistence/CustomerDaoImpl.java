package com.nttdata.hibernate.persistence;


import java.util.List;

import org.hibernate.Session;

/**
 * 
 * Clase de implementación del DAO de Cliente 
 * 
 * @author RAFA
 *
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDaoI{
	
	/** Sesión de conexión a BBDD */
	private Session session;

	/**
	 * 
	 * @param session
	 */
	public CustomerDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> searchByNameAndLastName(String name, String firstLastName, String secondLastName){
		
		return session.createQuery("FROM Customer WHERE name='"+name+"'AND firstLastName='"+firstLastName +"'AND secondLastName='"+ secondLastName+"'").list();
		
}

	
}
