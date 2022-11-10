package nttdata.javat1;

import nttdata.javat1.game.*;

/**
 * Clase principal donde se ejecuta el método main del taller 1 de programación
 * 
 * @author Rafael Blanco
 *
 */
public class T1MainRJBA {

	/**
	 * Método principal donde se simulan partidas de pinball haciendo uso de las clases Game, Ball y Player del paquete nttdata.javat1.game
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Declaración de Jugadores
		Player Alba = new Player("ALBA PARRÓN", 2, Strength.valueOf("prettyStrong"));
		Player Christian = new Player("CHRISTIAN LOBÓN", 4, Strength.valueOf("weak"));
		Player Juanma = new Player("JUAN MANUEL GIL", 10, Strength.valueOf("Hulk"));
		Player Santi = new Player("SANTIAGO LÓPEZ", 10, Strength.valueOf("strong"));
		Player Rafa = new Player("RAFAEL BLANCO", 0, Strength.valueOf("weakest"));
		
		// PARTIDA DE ALBA 
			
			// Selección de Jugador
			Game.setPlayer(Alba);
			
			Alba.insertCoin();
	
			Game.launchAndStart();
		
		// PARTIDA DE CHRISTIAN 
			
			// Selección de Jugador
			Game.setPlayer(Christian);
			
			Christian.insertCoin();
	
			Game.launchAndStart();
		
		// PARTIDA DE JUANMA 
			
			// Selección de Jugador
			Game.setPlayer(Juanma);
			
			Juanma.insertCoin();
	
			Game.launchAndStart();
		
		// PARTIDA DE SANTI 
			
			// Selección de Jugador
			Game.setPlayer(Santi);
	
			Santi.insertCoin();
	
			Game.launchAndStart();
		
		// PARTIDA DE RAFA *

			// Selección de Jugador
			Game.setPlayer(Rafa);
			
			// El jugador Rafa no tiene dinero suficiente, así que no podrá insertar una moneda de forma convencional
			Rafa.insertCoin();
			
			// Se hace uso del método shakeMachine para intentar trucar la máquina
			Rafa.shakeMachine();
	
			Game.launchAndStart();
		
	}
	
}
