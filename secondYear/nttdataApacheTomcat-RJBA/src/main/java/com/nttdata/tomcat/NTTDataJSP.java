package com.nttdata.tomcat;

/**
 * Formación Apache Tomcat - JSP - Taller Práctico Guiado
 * 
 * Primer JSP
 * 
 * @author RAFA
 *
 */

public class NTTDataJSP {

	/*
	 * Constructor privado de la clase
	 */
	private NTTDataJSP() {

	}

	
	/**
	 * Método de la clase para saludar 
	 * @param name
	 * @return
	 */
	public static String helloNTTData(final String name) {
		return "Bienvenido al Proyecto FP Dual " + name;

	}

}
