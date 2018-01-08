
/**
 * Abstract class for handling player functionality
 * @author edjeffery
 * 
 * @version 1.0
 */
public abstract class Player {
	
	//private char[][] board;
	//boolean hasWon = false;
	//boolean hasDrawn = false;
	//Board b;
	//View view; 
	//String userInput;
	//int move;
	//boolean placed;
	char colour;
	
	/**
	 * Constructor
	 * @param b
	 * 		Board object
	 */
	public Player(char colour){
		this.colour = colour;
		//this.b = b;
		//board = b.board;
		//view = new View(board);
	}
	
	/**
	 * Abstract method 
	 * @param board
	 * 
	 * @return Move in integer form
	 */
	public abstract int getNextMove(Board board);
	
	
	/*
	*//**
	 * Method for checking whether player has won or not
	 * 
	 * @return True if won, false if not 
	 *//*
	public boolean hasWon() {
		if (hasWon) {
			return true;
		}
		else {
			return false;
		}
	}
	
	*//**
	 * Method for checking whether the game is drawn or not
	 * 
	 * @return True if drawn, false if not 
	 *//*
	public boolean hasDrawn() {
		if (hasDrawn) {
			return true;
		}
		else {
			return false;
		}
	}
	
	*/
	

	
}
