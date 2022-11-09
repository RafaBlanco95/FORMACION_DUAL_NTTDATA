package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * DAO genérico 
 * 
 * @author RAFA
 *
 */
public interface CommonDaoI<T> {
	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT
	 */
	public void delete(final T paramT);
	
	/**
	 * 
	 * @param id
	 * @return T
	 */
	public T searchById(final Long id);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return Lista de entidades
	 */
	public List<T> searchAll();

}
