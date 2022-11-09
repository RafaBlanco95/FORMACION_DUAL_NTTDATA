package com.nttdata.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Clase Principal
 *
 */
public class App {
	
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/**
	 * 
	 * Método principal en el que se llama a la función que hace la conexión con BBDD y genera la consulta 
	 * 
	 * @param args
	 */
    public static void main( String[] args ){
    	LOG.info("Método: main() | TRAZA DE INICIO");
    	
    	//Llamada al método que realiza la conexión y realiza la consulta 
    	getConnectionAndSearchSevillaFcPlayers();
    	
    	LOG.info("Método: main() | FIN DE TRAZA");
    }
    
    /**
     * Método estático que establece la conexión y realiza la consulta
     * 
     */
    private static void getConnectionAndSearchSevillaFcPlayers() {
    	
    	// Apertura de conexión con BBDD (URL / Usuario / Contraseña)
    	try( Connection dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "rootroot")){
    		
    		//Consulta que permite mostrar por los logs la información de los jugadores de la base de datos que están en el equipo SEVILLA FÚTBOL CLUB
    		try(final Statement sentence = dbConnection.createStatement()){
    			final String query = "SELECT spl.name AS playerName, ste.name AS teamName, spl.first_rol AS firstRol, spl.second_rol AS secondRol, spl.birth_date AS birthD FROM nttdata_oracle_soccer_player spl JOIN nttdata_oracle_soccer_team ste ON spl.id_soccer_team = ste.id_soccer_team WHERE ste.name='SEVILLA FÚTBOL CLUB'";
    			final ResultSet queryResult = sentence.executeQuery(query);

    			// Iteración de resultados.
    			StringBuilder playerInfo = new StringBuilder();
    			playerInfo.append("\n");
    			while (queryResult.next()) {

    				playerInfo.append("Nombre: ");
    				playerInfo.append(queryResult.getString("playerName"));

    				playerInfo.append(" | Equipo: ");
    				playerInfo.append(queryResult.getString("teamName"));

    				playerInfo.append(" | Posición: ");
    				playerInfo.append(queryResult.getString("firstRol"));

    				playerInfo.append(" | Posición alternativa: ");
    				playerInfo.append(queryResult.getString("secondRol"));

    				playerInfo.append(" | Fecha nacimiento: ");
    				playerInfo.append(queryResult.getDate("birthD"));

    				playerInfo.append("\n");

    			}
    			LOG.info("{}", playerInfo);
			}
    	}catch(SQLException e) {
    		final StringBuilder sbu = new StringBuilder();
			sbu.append("[ERROR] Connection Failed: ");
			sbu.append(e);
			LOG.error("{}",sbu);
    	}

    }
}
