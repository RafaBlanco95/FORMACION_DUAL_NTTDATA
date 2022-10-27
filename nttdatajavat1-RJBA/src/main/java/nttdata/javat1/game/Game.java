package nttdata.javat1.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que recoge los métodos de la partida del pinball 
 * @author Rafael Blanco
 *
 */
public class Game {

    // ATRIBUTOS DE LA CLASE
	
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(Game.class);
	/** JUGADOR */
	private static Player player;
	/** BOLA */
	private static Ball ball;
	/** MONEDA INTRODUCIDA */
	private static boolean coin;



	// MÉTODOS PRINCIPALES (NUMERADOS DEL 1 AL 8//
	
	

	/**
	 * MÉTODO 1: Método que comienza la partida y lanza la bola en la máquina
	 */
	public static void launchAndStart() {
		
		LOG.info("  ");
		LOG.info("JUGADOR DE LA PARTIDA: {}", Game.player.getName());
		LOG.info("-------------------------------------------------");
		LOG.info("Método: launchAndStart() | TRAZA DE INICIO");
	
		LOG.debug("Método: launchAndStart | ¿MONEDA INTRODUCIDA? {}", coin);
		
		if (coin) {
			
			// Si se ha introducido una moneda, se lanza la bola y empieza la partida
			throwBall();
	
		} else {
			
			LOG.debug("Método: launchAndStart | EL JUGADOR NO HA INTRODUCIDO MONEDA EN LA MÁQUINA (InsertCoin()) ");

		}
	
		LOG.info("Método: launchAndStart() | FIN DE TRAZA");
	
	}
	
	/**
	 * 
	 * MÉTODO 2: Método que lanza la bola hacia el tablero del pinball, en concreto, a la zona de rebotes.
	 * La bola se lanza con una velocidad incial que depende del atrbuto de fuerza del jugador que la 
	 * lanza
	 * 
	 */
	public static void throwBall() {
	
		LOG.info("Método: throwBall() | TRAZA DE INICIO");
		
		Game.ball = new Ball();
		
		LOG.debug("Método: throwBall() | Color de la bola: {}", Game.ball.getColour());
		
		// Se toma la fuerza del jugador para establecer la velocidad que va a tener la bola al principio de la partida
		switch (Game.player.getStrength()) {
		
		case weakest:
			ball.setSpeed(50);
			break;
			
		case weak:
			ball.setSpeed(100);
			break;
			
		case strong:
			ball.setSpeed(200);
			break;
			
		case prettyStrong:
			ball.setSpeed(350);
			break;
			
		case Hulk:
			ball.setSpeed(500);
			break;
			
		default:
			ball.setSpeed(150);
			break;
	
		}
	
		LOG.info("Método: throwBall() | FIN DE TRAZA");
		
		// Se dirige la bola a la zona de rebotes
		reboundZone();
	}
	
	/**
	 * MÉTODO 3: Método que simula una zona de rebotes. La bola obtiene puntos en función de
	 * su velocidad en el momento de entrar en la zona.
	 * 
	 */
	public static void reboundZone() {
	
		LOG.info("Método: reboundZone() | TRAZA DE INICIO");
		
		 
		for (int i = 0; i < ball.getSpeed(); i++) {
			
			// Se suman 50 puntos por cada punto de velocidad de la bola
			ball.setScore(ball.getScore() + 50);
		}
		
		LOG.info("Método: reboundZone() | FIN DE TRAZA");
		
		// Se vuelve a elegir el camino a seguir
		chooseWay();
	
	}
	
	/**
	 * MÉTODO 4: Método que simula una zona de un tunel que provoca que la bola se pinte de
	 * otro color en su interior.
	 */
	public static void tunnelZone() {
		
		LOG.info("Método: tunnelZone() | TRAZA DE INICIO");
		
		// La bola cambia de color al salir del túnel 
		changeBallColour();
		
		LOG.debug("Método: tunnelZone() | Ahora la bola es de color {}", Game.ball.getColour());
		
		// Se incrementa la puntuación en 100 puntos
		ball.setScore(ball.getScore() + 100);
	
		LOG.info("Método: tunnelZone() | FIN DE TRAZA");
		
		// Se vuelve a elegir el camino a seguir
		chooseWay();
	
	}
	
	/**
	 * MÉTODO 5: Método que simula una zona de multiplicadores. La puntuación de la pelota se
	 * verá aumentada dos o tres veces su valor.
	 */
	public static void multiplyScoreZone() {
		
		LOG.info("Método: multiplyScoreZone() | TRAZA DE INICIO");
		
		
		if (ball.getScore() < 10000) {
			
			// En el caso de tener una puntuación inferior a 10.000, la triplica
			ball.setScore(ball.getScore() * 3);
			
		
		} else {
			// En caso contrario, la duplica
			ball.setScore(ball.getScore() * 2);
		}
		
		LOG.info("Método: multiplyScoreZone() | FIN DE TRAZA");
		
		// Se vuelve a elegir el camino a seguir
		chooseWay();
	}
	
	/**
	 * MÉTODO 6: Método que simula una zona de frenado. Añade más puntos a la bola cuanto más
	 * tenga que frenar
	 */
	public static void brakeZone() {
		
		LOG.info("Método: brakeZone() | TRAZA DE INICIO");
		
		// La puntuación aumenta tantos puntos como disminuye la velocidad de la bola 
		while (ball.getSpeed() > 100) {
			
			ball.setScore(ball.getScore() + 100);
			ball.setSpeed(ball.getSpeed() - 100);
		}
		
		LOG.info("Método: brakeZone() | FIN DE TRAZA");
		
		// Se vuelve a elegir el camino a seguir
		chooseWay();
	}
	
	/**
	 * MÉTODO 7: Método que simula una zona de aceleración. Duplica la velocidad de la bola
	 */
	public static void hyperSpeedZone() {
		
		LOG.info("Método: hyperSpeedZone() | TRAZA DE INICIO");
		
		// Se duplica la velocidad de la bola
		ball.setSpeed(ball.getSpeed() * 2);
		
		LOG.info("Método: hyperSpeedZone() | FIN DE TRAZA");
		
		// Se vuelve a elegir el camino a seguir
		chooseWay();
	}
	
	/**
	 * Método 8: Método que finaliza la partida y muestra la puntuación
	 */
	public static void finishAndShowResult() {
	
		LOG.info("Método:  finishAndShowResult() | TRAZA DE INICIO");
		
		// Inicialización de variable con el resultado final de la puntuación de la bola
		double result = ball.getScore();
		
		LOG.debug("Método: finishAndShowResult() | resultado {}", ball.getScore());
	
		// Se imprime el ticket con la puntuación de la bola que ha obtenido el jugador
		printTicket(result);
		
		// Se libera la ranura de introducir una moneda
		Game.setCoin(Boolean.FALSE);
	
	}

	   

	   // MÉTODOS REFACTORIZADOS

	/**
	 * Método que genera un número aleatorio entre el 1 y el 4
	 * 
	 * @return el número aleatorio generado
	 */
	private static int randomOneToFour() {

		// Se genera un número aleatorio entre el 1 y el 4 incluidos
		int oneTwoThreeFour = (int) (Math.random() * 4 + 1);

		return oneTwoThreeFour;

	}

	/**
	 * Método que modifica el estado de las palancas izquierda (pressLeftButton) y
	 * derecha (pressRightButton) que tiene la clase jugador como atributos
	 */
	private static void playerPressButton() {
		
		LOG.info("Método:  playerPressButton() | TRAZA DE INICIO");
		
		int random=randomOneToFour();
		
		LOG.info("Método:  playerPressButton() | Número aleatorio generado: {}", random);
		
		switch (random) {
		
		// El jugador pulsa la palanca derecha
		case 1:
			player.setRigthButtonPressed(Boolean.TRUE);
			player.setLeftButtonPressed(Boolean.FALSE);
			break;
			
		// El jugador pulsa la palanca izquierda
		case 2:
			player.setLeftButtonPressed(Boolean.TRUE);
			player.setRigthButtonPressed(Boolean.FALSE);
			break;
			
	    // El jugador pulsa las dos palancas 	
		case 3:
			player.setLeftButtonPressed(Boolean.TRUE);
			player.setRigthButtonPressed(Boolean.TRUE);
			break;
			
		// El jugador no pulsa ninguna palanca 	
		default:
			player.setRigthButtonPressed(Boolean.FALSE);
			player.setLeftButtonPressed(Boolean.FALSE);
			break;
		}
		
		LOG.info("Método:  playerPressButton() | TRAZA FIN ");

	}

	/**
	 * Método que modifica el color de la bola
	 */
	private static void changeBallColour() {
		
		String[] newColours = Ball.getCOLOURS();
		String lastColor = ball.getColour();
		
		do {
			// Se cambia el color de la bola, si sale el mismo color, lo vuelve a cambiar
			ball.setColour(newColours[(int) (Math.random() * newColours.length + 1)-1]);
			
		} while (lastColor.equals(ball.getColour()));
	}

	/**
	 * Método que selecciona la siguiente zona a la que se va a dirigir la bola
	 */
	private static void chooseWay() {
		
		LOG.info("Método: chooseWay() | TRAZA DE INICIO");
		
		// Se simula que la pelota está cayendo y el jugador debe pulsar una palanca
		playerPressButton();
		
		LOG.info("Método: chooseWay() | El valor de la palanca izquierda es {}", player.isLeftButtonPressed());
		LOG.info("Método: chooseWay() | El valor de la palanca derecha es {}", player.isRigthButtonPressed());
		
		if (player.isLeftButtonPressed() && !player.isRigthButtonPressed()) {
			
			// Se ejecuta si el jugador ha pulsado sólo la palanca izquierda
			switch (randomOneToFour()) {
			
			case 1:
				multiplyScoreZone();
				break;
				
			case 2:
				brakeZone();
				break;
				
			default:
				tunnelZone();
				break;

			}
		
		}else if (player.isRigthButtonPressed() && !player.isLeftButtonPressed()) {
			
			// Se ejecuta si el jugador ha pulsado sólo la palanca derecha
			switch (randomOneToFour()) {
			
			case 1:
				reboundZone();
				break;
				
			case 2:
				hyperSpeedZone();
				break;
				
			default:
				multiplyScoreZone();
				break;
			}
		
		}else if (!player.isRigthButtonPressed() && !player.isLeftButtonPressed()) {
			
			// Si el jugador no ha pulsado ninguna palanca, se acaba la partida
			finishAndShowResult();
			
		}else {
			
			// Si las dos palancas están pulsadas, la bola se dirige siempre hacia un tunel
			tunnelZone();
		}
		
		LOG.info("Método: chooseWay() | FIN DE TRAZA");
	}

	/**
	 * Método que muestra el ticket generado por el pinball con la información de la
	 * partida
	 * 
	 * @param result
	 */
	private static void printTicket(double result) {
		
		// Inicialización del StringBuilder
		final StringBuilder sbu = new StringBuilder(10000);
		sbu.append("\n");
		sbu.append("//////////////////////////////////////////////////////////\n");
		sbu.append("//-----------------------------------------------------|//\n");
		sbu.append("//|                                                    |//\n");
		sbu.append("  //|                                                  |//\n");
		sbu.append("    //| Puntuación de    ");
		sbu.append(Game.player.getName());
		sbu.append(": ");
		sbu.append(result);
		sbu.append(" \n");
		sbu.append("  //|                                                  |//\n");
		sbu.append("//|                                                    |//\n");
		sbu.append("//-----------------------------------------------------|//\n");
		sbu.append("/////////////////////////////////////////////////////////");

		System.out.println(sbu.toString());
	}
	

	// MÉTODOS GETTERS Y SETTERS

		/**
		 * Método Get del atributo jugador
		 * 
		 * @return El jugador
		 */
		public static Player getPlayer() {

			return player;
		}

		/**
		 * Método Get del atributo bola
		 * 
		 * @return La bola
		 */
		public static Ball getBall() {

			return ball;
		}

		/**
		 * Método Get del atributo que indica si se puede empezar la partida
		 * 
		 * @return coin (Es decir, si hay una moneda dentro de la máquina o no)
		 */
		public static boolean isCoin() {

			return coin;
		}

		/**
		 * Método Set del atributo jugador
		 * 
		 * @param player
		 */
		public static void setPlayer(Player player) {

			Game.player = player;
		}

		/**
		 * Método Set del atributo bola
		 * 
		 * @param ball
		 */
		public static void setBall(Ball ball) {
			Game.ball = ball;
		}

		/**
		 * Método Set del atributo coin
		 * 
		 * @param coin
		 */
		public static void setCoin(boolean coin) {

			Game.coin = coin;
		}

}
