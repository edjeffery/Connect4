
/**
 * Class for handling the running of Connect4/N
 * @author edjeffery
 *
 */
public class GameLogic {
	
	// Not sure how to use enum yet
	/*public enum Colour {
		RED,
		YELLOW
	}*/ 
	
	String c;
	UserInput uInput;
	Player player;
	private static final int ROWS = 6;
	private static final int COLS = 7;
	private static final int N = 4;
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		runGame(ROWS, COLS, N);
	}	
	
	/**
	 * Method for running the game
	 * @param rows
	 * 			Number of rows of board
	 * @param cols
	 * 			Number of columns of board
	 * @param n
	 * 			Number of pieces in a row needed to win
	 */
	private static void runGame(int rows, int cols, int n) {
		Board board = new Board(rows, cols, n);
		Player player = new Player(board);
		UserInput uInput = new UserInput();
		BotInput botInput = new BotInput();
		String c;
		char[] colours = {'r', 'y'};
		char colour = colours[0];
		int i = 0;
		
		boolean win = false;
		boolean draw = false;
		while(!win){
			colour = colours[i % 2];
			if (i % 2 == 0) {
				c = uInput.getUserInput();
			}
			else {
				c = botInput.getBestMove(board.getBoard(), colour); 
			}
			player.playGame(colour, c);
			win = player.hasWon();
			draw = player.hasDrawn();
			if (draw) {
				System.out.println("The game is a draw!!!");
				break;
			}
			i++;
		}
		System.out.println("Player " + colour + " has won!!!");
		return;
	}
	
	/*public void printWinMessage() {
		System.out.println("You Have Won!!!");
	}*/
	
}
