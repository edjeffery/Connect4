import java.util.ArrayList;

/**
 * Class for handling the Connect4/N game loop
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-12
 */
public class GameLogic {
	
	Board board;
	ArrayList<Player> players;
	View view;
	
	/**
	 * Constructor to set up objects needed to run the game
	 * @param board
	 * 			Board object
	 * @param players
	 * 			ArrayList of Player objects
	 * @param view
	 * 			View object
	 */
	public GameLogic(Board board, ArrayList<Player> players, View view) {
		this.board = board;
		this.players = players;
		this.view = view;
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
	public void runGame() {
		char colour;
		int move;
		int i = 0;

		boolean win = false;
		boolean draw = false;

		while(!win){
			Player player = players.get(i % players.size());
			colour = player.getColour();
			do {
				move = player.getNextMove(board);
			} while (board.isColumnFull(move));
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
