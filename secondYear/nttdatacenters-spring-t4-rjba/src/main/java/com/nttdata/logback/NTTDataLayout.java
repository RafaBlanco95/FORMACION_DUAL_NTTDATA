package com.nttdata.logback;

import java.util.Date;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

/**
 * Clase de creación de un layout personalizado para los logs que aparecen por consola
 * @author RAFA
 *
 */
public class NTTDataLayout  extends LayoutBase<ILoggingEvent>{
	private String prefix;	
	private boolean printThreadName = Boolean.TRUE;

	/**
	 * Generación del Layout
	 * 
	 * @param event Evento Logger
	 * @return String
	 */
	public String doLayout(ILoggingEvent event) {

		// Creación del StringBuilder.
		final StringBuilder sbuf = new StringBuilder(128);

		sbuf.append(new Date(event.getTimeStamp()));
		sbuf.append(" ");
		sbuf.append(prefix);
		sbuf.append(" ");
		sbuf.append(event.getLevel());

		if (printThreadName) {
			sbuf.append(" [");
			sbuf.append(event.getThreadName());
			sbuf.append("]");
		}

		sbuf.append(" ");
		sbuf.append(event.getLoggerName());
		sbuf.append(" - ");
		sbuf.append(event.getFormattedMessage());
		sbuf.append("\n");

		return sbuf.toString();
	}

	
	// Getters y Setters
	
	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix El prefijo del diseño
	 *            
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the printThreadName
	 */
	public boolean isPrintThreadName() {
		return printThreadName;
	}

	/**
	 * @param printThreadName El nombre del hilo que se va a mostrar en el log
	 *           
	 */
	public void setPrintThreadName(boolean printThreadName) {
		this.printThreadName = printThreadName;
	}

}
