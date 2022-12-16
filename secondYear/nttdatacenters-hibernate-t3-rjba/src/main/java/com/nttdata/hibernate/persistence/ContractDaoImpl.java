package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	@Override
	public List<Contract> searchByLastNameAndContractCost(String lastName, Float monthlyCost) {

		// Query.
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Contract> cquery = cb.createQuery(Contract.class);
		final Root<Contract> rootC = cquery.from(Contract.class);
		final Join<Contract, Customer> coJoinCu = rootC.join("customer");

		// Cláusula Where.
		final Predicate predicate1 = cb.like(coJoinCu.<String>get("firstLastName"), lastName);
		final Predicate predicate2 = cb.le(rootC.<Float>get("monthlyCost"), monthlyCost);

		// Construcción de la Consulta.
		cquery.select(rootC).where(cb.and(predicate1, predicate2));

		// Ordenación por el nombre del cliente.
		cquery.orderBy(cb.desc(coJoinCu.get("name")));

		// Ejecución de consulta.
		return session.createQuery(cquery).getResultList();
	}
}
