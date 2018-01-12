import java.util.ArrayList;

/**
 * Main class from which game is run
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-12
 */
public class Main {
	
	// Number of rows in the board
	public static final int ROWS = 6;
	// Number of columns in the board
	public static final int COLS = 7;
	// Number of pieces needed in a row to win
	public static final int N = 4;
	
	/**
	 * Main method. Prints starting text, instantiates all necessary objects and injects them into GameLogic
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		
		Board board = new Board(ROWS, COLS, N);
		ArrayList<Player> players = new ArrayList<Player>();
		View view = new View(board);
		User user = new User('r');
		Bot bot = new Bot('y');
		
		players.add(user);
		players.add(bot);
		
		GameLogic gameLogic = new GameLogic(board, players, view);
		gameLogic.runGame();
	}

}
