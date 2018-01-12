import java.util.ArrayList;
import java.util.Scanner;

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
	
	Scanner scanner;
	
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
		
		Main main = new Main();
		int N = main.getUserN();
		
		Board board = new Board(ROWS, COLS, N);
		ArrayList<Player> players = new ArrayList<Player>();
		View view = new View(board);
		User user = new User('r');
		Bot bot1 = new Bot('y');
		Bot bot2 = new Bot('g');
		
		players.add(user);
		players.add(bot1);
		players.add(bot2);
		
		GameLogic gameLogic = new GameLogic(board, players, view);
		gameLogic.runGame();
		
		main.scanner.close();
	}
	
	/**
	 * Method for getting the ConnectN input from the user.
	 * 
	 * @return Integer N, which specifies the number of counters needed in a row to win
	 */
	private int getUserN() {
		scanner = new Scanner(System.in);
		int N = 0;
		do {
			System.out.println("Please enter a number between 3 and 6 (inclusive): ");
			try {
				N = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
				scanner.next();
			}
		} while (N <= 2 || N >= 7);
		return N;
	}

}
