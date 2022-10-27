package com.nttdata.tomcat;

/**
 * Formaci�n Apache Tomcat - JSP - Taller Pr�ctico Guiado
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
	 * M�todo de la clase para saludar 
	 * @param name
	 * @return
	 */
	public static String helloNTTData(final String name) {
		return "Bienvenido al Proyecto FP Dual " + name;

	}

}
