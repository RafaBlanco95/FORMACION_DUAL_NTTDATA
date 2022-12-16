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
	 * @param paramT Abstract Entity son
	 */
	public void insert(final T paramT);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param paramT Abstract Entity son
	 */
	public void update(final T paramT);
	
	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param paramT Abstract Entity son
	 */
	public void delete(final T paramT);
	
	/**
	 * 
	 * Busca un registro a través de su Identificador
	 * 
	 * @param id The Entity Id
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
