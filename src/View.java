
/**
 * Class for handling output to console
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-08
 */
public class View {
	
	private char[][] board;
	
	/**
	 * Constructor
	 * @param board
	 */
	public View(Board b) {
		this.board = b.getBoard();
		printBoard(board);
	}
	
	/**
	 * Method for printing board to console
	 * @param board
	 * 			2D array of Connect4/N board
	 */
	public void printBoard(char[][] board) {
		for (int i = 0; i < Main.ROWS; i++) { 
			for (int j = 0; j < Main.COLS; j++) {
				char c = board[i][j];
				if (c != 0) { 
					System.out.print("| " + c + " ");
				}
				else {
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7  ");
	}
	
}
