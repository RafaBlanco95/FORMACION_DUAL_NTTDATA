package nttdata.javat1.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que define a los jugadores que van a lanzar la bola en las partidas del pinball
 * 
 * @author Rafael Blanco
 *
 */
public class Player {
	
	// ATRIBUTOS DE LA CLASE
	
	/** LOGGER */
	private static final Logger LOG = LoggerFactory.getLogger(Player.class);
	/** NOMBRE */
	private String name;
	/** DINERO */
	private double money;
	/** FUERZA */
	private Strength strength;
	/** PALANCA IZQUIERDA PULSADA */
	private boolean pressLeftButton;
	/** PALANCA DERECHA PULSADA  */
	private boolean pressRigthButton;

	
	// CONSTRUCTORES 
	
	/**
	 * Método Constructor vacío de un jugador
	 */
	public Player() {

	}
	
	/**
	 * Método Constructor de un jugador indicando su nombre, dinero y fuerza
	 * @param name
	 * @param money
	 * @param strength
	 */
	public Player(String name, double money, Strength strength) {
		
		this.name = name;
		this.money = money;
		this.strength = strength;
	}

	

	// MÉTODOS PRINCIPALES 


	/**
	 * Método para insertar una moneda en la máquina de pinball, crear una bola y
	 * poder jugar una partida
	 */
	public void insertCoin() {
		
		LOG.info("Método:  insertCoin() | TRAZA DE INICIO");
		
		// Inicialización del StringBuilder
		final StringBuilder sbuildInsertCoin = new StringBuilder();
				
		// Condicional para comprobar si el jugador tiene fondos suficientes
		if (this.money >= 1) {
			
			this.money -= 1;
			
			Game.setCoin(Boolean.TRUE);
			
		} else {
			
			// Si los fondos no son suficientes, se muestra por pantalla a través del StringBuilder
			sbuildInsertCoin.append("\n");
			
			sbuildInsertCoin.append("FONDOS INSUFICIENTES, AL JUGADOR ");
			
			sbuildInsertCoin.append(Game.getPlayer().getName());
			
			sbuildInsertCoin.append(" NO LE QUEDAN MÁS MONEDAS");
			
			System.out.println(sbuildInsertCoin.toString());
			
		}
		
		LOG.info("Método:  insertCoin() | TRAZA FIN");
	}

	/**
	 * Método que agita la máquina de pinball para intentar trucarla y poder jugar
	 * una partida sin insertar una moneda. No siempre funciona
	 */
	public void shakeMachine() {
		
		LOG.info("Método: shakeMachine() | TRAZA DE INICIO");
		
		// Inicialización del StringBuilder
		final StringBuilder sbuildshakeMachine = new StringBuilder();
		
		sbuildshakeMachine.append("(");
		
		sbuildshakeMachine.append(Game.getPlayer().getName());
		
		sbuildshakeMachine.append(" está agitando la máquina para intentar trucarla) \n");
		
		
		// Se inicializa una variable suerte
		int luck = (int) (Math.random() * 10);
		
		// Se comprueba si el valor de suerte es suficiente
		if (luck >= 7) {
			
			Game.setCoin(Boolean.TRUE);
			
			sbuildshakeMachine.append("¡Click! (Máquina Trucada)\n");
			
			sbuildshakeMachine.append("Moneda Introducida");
			
			System.out.println(sbuildshakeMachine.toString());
			
		} else {
			// Si no es suficiente, se llama a la función de insultar 
			System.out.println(sbuildshakeMachine.toString());
			
			randomInsultMachine();
		}
		
		LOG.info("Método: shakeMachine() | TRAZA FIN");
	}

	/**
	 * Método que genera un insulto hacia la máquina de pinball
	 */
	public void randomInsultMachine() {
		
		// Inicialización del StringBuilder
		final StringBuilder sbuildRandomInsultMachine = new StringBuilder();
				
		LOG.info("Método: randomInsultMachine() | TRAZA DE INICIO");
		
		String[] randomInsults = { "Maldita Máquina...", "No es justo...", "Bah, no es más que un juego estúpido...","¡Qué mala suerte!" };
		
		sbuildRandomInsultMachine.append(randomInsults[(int) (Math.random() * randomInsults.length+1)-1]);
		
		System.out.println(sbuildRandomInsultMachine.toString());
		
		LOG.info("Método: randomInsultMachine() | FIN DE TRAZA");
	}
	 // GETTERS Y SETTERS
	
	/**
	 * Método Get del atributo palanca izquierda pulsada
	 * @return boolean
	 */
	public boolean isLeftButtonPressed() {
		
		return pressLeftButton;
	}

	/**
	 * Método Get del atributo palanca derecha pulsada
	 * @return boolean
	 */
	public boolean isRigthButtonPressed() {
		
		return pressRigthButton;
	}
	

	/**
	 * Método Set del atributo palanca izquierda pulsada
	 * @param leftButtonPressed
	 */
	public void setLeftButtonPressed(boolean leftButtonPressed) {
		
		this.pressLeftButton = leftButtonPressed;
	}

	/**
	 * Método Set del atributo Palanca derecha pulsada
	 * @param rigthButtonPressed
	 */
	public void setRigthButtonPressed(boolean rigthButtonPressed) {
		
		this.pressRigthButton = rigthButtonPressed;
	}

	/**
	 * Método Set del atributo Nombre
	 * @return String
	 */
	public String getName() {
		
		return name;
	}

	/**
	 * Método Get del atributo Dinero
	 * @return double
	 */
	public double getMoney() {
		
		return money;
	}

	
	/**
	 * Método Get del atributo Fuerza
	 * @return Strength
	 */
	public Strength getStrength() {
		
		return strength;
	}

	/**
	 * Método Set del atributo Nombre
	 * @param name
	 */
	public void setName(String name) {
		
		this.name = name;
	}

	/**
	 * Método Set del atributo Dinero
	 * @param money
	 */
	public void setMoney(double money) {
		
		this.money = money;
	}


	/**
	 * Método Set del atributo Fuerza
	 * @param strength
	 */
	public void setStrength(Strength strength) {
		
		this.strength = strength;
	}

}
