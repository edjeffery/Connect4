
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
	public static final int ROWS = 6;
	public static final int COLS = 7;
	//private static final int N = 4;
	
	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		System.out.println("Please choose N: ");
		String chosenN = new UserInput().getUserInput();
		int N = Integer.parseInt(chosenN);
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
		Board board1 = new Board(rows, cols, n);
		Board board2 = new Board(rows, cols, n);
		Player player1 = new Player(board1, 1);
		Player player2 = new Player(board2, 2);
		UserInput uInput = new UserInput();
		BotInput botInput = new BotInput();
		String c;
		char[] colours = {'r', 'y', 'b', 'g'};
		char colour = colours[0];
		int i = 0;
		
		boolean win = false;
		boolean draw = false;
		while(!win){
			colour = colours[i % colours.length];
			if (colour == 'r') {
				c = uInput.getUserInput();
				player1.playGame('r', c);
			}
			else if (colour == 'b') {
				c = uInput.getUserInput();
				player2.playGame('b', c);
			}
			else if (colour == 'y') {
				c = botInput.getBestMove(board1.getBoard(), colour); 
				player1.playGame('y', c);
			}
			else if (colour == 'g') {
				c = botInput.getBestMove(board2.getBoard(), colour);
				player2.playGame('g', c);
			}
			else {
				// do nothing
			}
			
			//player.playGame(colour, c);
			win = player1.hasWon();
			draw = player1.hasDrawn();
			if (win) {
				System.out.println("Player " + colour + " has won!!!");
			}
			if (draw) {
				System.out.println("The game is a draw!!!");
				break;
			}
			i++;
		}
		return;
	}
	
	/*public void printWinMessage() {
		System.out.println("You Have Won!!!");
	}*/
	
}
