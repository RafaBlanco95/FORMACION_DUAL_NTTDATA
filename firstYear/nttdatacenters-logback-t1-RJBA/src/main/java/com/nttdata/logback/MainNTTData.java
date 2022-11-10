package com.nttdata.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase Principal
 * 
 * @author Rafa
 *
 */
public class MainNTTData {

	private static final Logger LOG = LoggerFactory.getLogger(MainNTTData.class);

	/**
	 * Método principal de la clase
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		LOG.info("Método: main() | TRAZA DE INICIO");

		// Inicialización de variables
		String devil = "Break";
		String angel = "Flag";

		// Llamada a la función devilLoop()
		System.out.println(devilLoop(devil));
		System.out.println(devilLoop(angel));

		LOG.info("Método: main() | FIN DE TRAZA");
	}

	/**
	 * Método de comprobación de una cadena de caracteres con la palabra "Break"
	 * 
	 * @param isDevil
	 * @return
	 */
	private static boolean checkBreak(final String isDevil) {

		LOG.info("Método: checkBreak() | TRAZA DE INICIO");

		// Declaración de la variable de retorno

		boolean result = Boolean.FALSE;

		LOG.debug("Método: checkBreak() | Parámetro de entrada: {}", isDevil);

		// Condicional que comprueba si el parámetro de entrada es "break"

		if (isDevil.equals("Break")) {
			result = Boolean.TRUE;
		}

		LOG.info("Método: checkBreak() | FIN DE TRAZA");
		return result;
	}

	/**
	 * Método para realizar muchas iteraciones y rellenar un acumulador
	 * 
	 * @param devilOrAngel
	 * @return long
	 */
	private static long devilLoop(final String devilOrAngel) {

		LOG.info("Método: devilLoop() | TRAZA DE INICIO");

		// Declaración de la variable de retorno

		long result = 0;

		// Llamada a la función "checkBreak" y entrada en un bucle

		if (checkBreak(devilOrAngel)) {
			for (int i = 0; i < 666666; i++) {
				result += 1;
				LOG.debug("Iteración: {}", i);
			}
			
		}else{
			for (int j = 0; j < 500000; j++) {
				result += 1;
				LOG.debug("Iteración: {}", j);
			}
		}

		// Fin del bucle

		LOG.info("Método: devilLoop() | FIN DE TRAZA");
		return result;

	}
}
