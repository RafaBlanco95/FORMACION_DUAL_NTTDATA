package nttdata.javat1.game;

/**
 * Clase para instanciar la bola o pelota del pinball 
 * 
 * @author Rafael Blanco
 *
 */
public class Ball {
	
	// ATRIBUTOS DE LA CLASE
	
	/** PUNTUACIÓN */
	private double score;
	/** COLOR */
	private String colour;
	/** COLORES POSIBLES */
	private final static String[] COLOURS = { "Green", "Blue", "Red", "Yellow", "White", "Black", "Gray", "Purple", "Brown","Pink", "Orange" };
	/** VELOCIDAD */
	private double speed;

	
	// CONSTRUCTOR 
	
	/**
	 * Constructor de la bola, se asigna un color aleatorio
	 */
	public Ball() {
		
		this.colour = COLOURS[(int) (Math.random() * (COLOURS.length-1))];
	}

	// GETTERS Y SETTERS 
	
	/**
	 * Método Get del atributo Score
	 * 
	 * @return double
	 */
	public double getScore() {
		
		return score;
	}

	/**
	 * Método Get del atributo Colour
	 * 
	 * @return String
	 */
	public String getColour() {
		
		return colour;
	}

	/**
	 * Método Get del atributo estático Colours
	 * 
	 * @return String
	 */
	public static String[] getCOLOURS() {
		
		return COLOURS;
	}

	/**
	 * Método Get del aributo Speed
	 * 
	 * @return double
	 */
	public double getSpeed() {
		
		return speed;
	}

	/**
	 * Método Set del atributo Score
	 * 
	 * @param score
	 */
	public void setScore(double score) {
		
		this.score = score;
	}

	/**
	 * Método Set del atributo Colour
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		
		this.colour = colour;
	}

	/**
	 * Método Set del atributo Speed
	 * 
	 * @param speed
	 */
	public void setSpeed(double speed) {
		
		this.speed = speed;
	}
}
