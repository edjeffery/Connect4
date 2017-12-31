
/**
 * Class for handling output to console
 * @author edjeffery
 *
 * @version 1.0
 */
public class View {
	
	private char[][] board;
	
	/**
	 * Constructor
	 * @param board
	 */
	public View(char[][] board) {
		this.board = board;
		printBoard(board);
	}
	
	/**
	 * Method for printing board to console
	 * @param board
	 * 			2D array of Connect4/N board
	 */
	public void printBoard(char[][] board) {
		for(int i=0; i<board.length; i++){ 
			for(int j=0; j<board[i].length; j++){
				char c = board[i][j];
				if(c != 0){ 
					System.out.print("| " + c + " ");
				}
				/*else if(board[i][j] == 'y'){ 
					System.out.print("| y ");
				}*/
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7  ");
	}
	
}
