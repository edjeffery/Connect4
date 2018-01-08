
/**
 * Abstract class for handling player functionality
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-08
 */
public abstract class Player {
	
	char colour;
	
	/**
	 * Constructor. Sets the player's colour.
	 * @param colour
	 * 			Colour (ID) of player
	 */
	public Player(char colour) {
		this.colour = colour;
	}
	
	/**
	 * Abstract method 
	 * @param board
	 * 			Board object
	 * 
	 * @return Move in integer form
	 */
	public abstract int getNextMove(Board board);
	
	/**
	 * Accessor
	 * 
	 * @return Colour of player
	 */
	public char getColour() {
		return colour;
	}
	
}
