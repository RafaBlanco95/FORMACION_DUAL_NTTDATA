package com.nttdata.logback;

import java.util.Date;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;

/**
 * Taller práctico de Logback: Creación de un layout personalizado
 * @author Rafa
 *
 */
public class LayoutNTTData extends LayoutBase<ILoggingEvent> {

	
	private String prefix;	
	private boolean printThreadName = Boolean.TRUE;

	/**
	 * Generación del Layout
	 * 
	 * @param event
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
	 * @param prefix
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
	 * @param printThreadName
	 *           
	 */
	public void setPrintThreadName(boolean printThreadName) {
		this.printThreadName = printThreadName;
	}

}
