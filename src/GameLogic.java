import java.util.ArrayList;

/**
 * Class for handling the running of Connect4/N
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-08
 */
public class GameLogic {
	
	public static final int ROWS = 6;
	public static final int COLS = 7;
	public static final int N = 4;
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		GameLogic gameLogic = new GameLogic();
		gameLogic.runGame();
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
	private void runGame() {
		Board board = new Board(ROWS, COLS, N);
		ArrayList<Player> players = new ArrayList<Player>();
		View view = new View(board);
		User user = new User('r');
		Bot bot = new Bot('y');

		char colour;
		int move;
		int i = 0;

		boolean win = false;
		boolean draw = false;
		
		players.add(user);
		players.add(bot);

		while(!win){
			Player player = players.get(i % players.size());
			colour = player.getColour();
			move = player.getNextMove(board);
			board.placeCounter(colour, move);
			view.printBoard(board.getBoard());
			win = board.checkWin(colour);
			draw = board.checkDraw();
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
	
}
