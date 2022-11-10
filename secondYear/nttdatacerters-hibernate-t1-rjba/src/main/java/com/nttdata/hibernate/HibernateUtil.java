package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase de configuración
 * @author RAFA
 *
 */
public class HibernateUtil {
	
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
	
	/** Generador de Sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Constructor Privado.
	 */
	private HibernateUtil() {

	}

	/**
	 * Generación de las sesiones.
	 */
	static {

		try {

			// Generación de la Configuración.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {
			
			// Creación del StringBuilder para mostrar en el LOG
			final StringBuilder sbu = new StringBuilder();
			sbu.append("[ERROR] Session Factory Configuration Failed at Initialization ");
			sbu.append(ex);
			LOG.error(sbu.toString());
			
			// Error de Inicialización.
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Función que devuelve el Generador de Sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
