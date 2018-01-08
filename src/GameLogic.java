import java.util.ArrayList;

/**
 * Class for handling the running of Connect4/N
 * @author edjeffery
 *
 */
public class GameLogic {
	
	String c;
	//User user;
	//Bot bot;
	ArrayList<> = new ArrayList<>();
	public static final int ROWS = 6;
	public static final int COLS = 7;
	public static final int N = 4;
	
	/**
	 * Main method
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
		//Player player = new Player(board);
		View view;
		User user = new User('r');
		Bot bot = new Bot('y');
		String c;
		int move;
		char[] colours = {'r', 'y'}; // Change to array list of player objects
		char colour = colours[0];
		int i = 0;
		
		boolean win = false;
		boolean draw = false;
		while(!win){
			colour = colours[i % colours.length];
			if (i % colours.length == 0) {
				move = user.getNextMove(board);
			}
			else {
				move = bot.getNextMove(board); 
			}
			board.placeCounter(colour, move);
			view.printBoard(board.getBoard());
			//playGame(colour, c);
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
			playGame(player, new UserInput(b).getUserInput());
		}
		hasWon = b.checkWin(player);
		hasDrawn = b.checkDraw();
		view.printBoard(board);
	}
	
}
