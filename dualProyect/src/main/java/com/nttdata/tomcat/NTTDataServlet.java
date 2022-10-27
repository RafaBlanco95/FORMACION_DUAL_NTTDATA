package com.nttdata.tomcat;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class NTTDataServlet
 */
public class NTTDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * M�todo constructor del Servlet
	 * 
	 * @see HttpServlet#HttpServlet()
	 */
	public NTTDataServlet() {
		super();

	}

	/**
	 * M�todo que responde ante una petici�n GET
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("NTT Data | GET | PRIMER SERVLET OK");
	}

	/**
	 * 
	 * M�todo qeu responde ante una petici�n POST
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
