import java.util.ArrayList;

/**
 * Class for handling the running of Connect4/N
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-08
 */
public class GameLogic {
	
	Board board;
	ArrayList<Player> players;
	View view;
	
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
