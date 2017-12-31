
/**
 * Class for handling player functionality
 * @author edjeffery
 * 
 * @version 1.0
 */
public class Player {
	
	private char[][] board;
	boolean hasWon = false;
	Board b;
	View view; 
	String userInput;
	int move;
	boolean placed;
	
	/**
	 * Constructor
	 * @param b
	 * 		Board object
	 */
	public Player(Board b){
		this.b = b;
		board = b.board;
		view = new View(board);
	}
	
	/**
	 * Method for playing a move in the game
	 * @param player
	 * 			Character identifying player's colour
	 * @param input
	 * 			Move in String format
	 */
	public void playGame(char player, String input){
		move = generateMove(input);
		placed = b.placeCounter(player, move);
		if (!placed) {
			System.out.println("A counter cannot be placed here. Please try again.");
			playGame(player, new UserInput().getUserInput());
		}
		hasWon = b.checkWin(player);
		view.printBoard(board);
	}
	
	/**
	 * Method for checking whether player has won or not
	 * 
	 * @return True if won, false if not 
	 */
	public boolean hasWon() {
		if (hasWon) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method for generating a proper move from input
	 * @param userInput
	 * 			Move in String format
	 * 
	 * @return Move in integer format
	 */
	private int generateMove(String userInput) {
		int move = Integer.parseInt(userInput);
		return move;
	}
	
}
