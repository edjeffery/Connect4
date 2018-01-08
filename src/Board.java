
/**
 * Class for dealing with the board of the game
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-08
 */
public class Board {
	
	private char[][] board;
	private int row;
	private int col;
	private int n;
	
	/**
	 * Constructor
	 * @param row	
	 * 			Number of rows in the board
	 * @param col
	 * 			Number of columns in the board
	 * @param n
	 * 			Number of pieces in a row needed to win
	 */
	public Board(int row, int col, int n) {
		this.row = row;
		this.col = col;
		this.n = n;
		board = new char[row][col];
	}
	
	/**
	 * Constructor 
	 * @param board
	 * 			2D array of Connect4/N board
	 */
	public Board(char[][] board) {
		this.board = board;
	}
	
	/**
	 * Method for placing counter into the board
	 * @param player
	 * 			Character identifying player's colour
	 * @param position
	 * 			Column in which counter should be placed
	 */
	public boolean placeCounter(char player, int position) {
		boolean placed = false;
		for(int i = board.length - 1; i >= 0; i--){ 
			if(!placed){
				if(board[i][position-1] == 0){ 
					board[i][position-1] = player;
					placed = true; 
				}
				else { 
					// skip
				}
			}
		}
		return placed;
	}
	
	/**
	 * Method for checking whether a column is full on the board
	 * @param column
	 * 			Column of board
	 * 
	 * @return True if full, false if not
	 */
	private boolean isColumnFull(int column) {
		if (board[0][column] != 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method for checking whether game is a draw (i.e. all columns are full)
	 * 
	 * @return True if draw, false if not
	 */
	public boolean checkDraw() {
		for (int i = 0; i < col; i++) {
			if (!isColumnFull(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Method for checking whether player has won the game
	 * @param colour
	 * 			Player's counter colour
	 * 
	 * @return True if won, false if not
	 */
	public boolean checkWin(char colour) {
		if (checkCount(colour) >= n) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Accessor
	 * 
	 * @return 2D array board 
	 */
	public char[][] getBoard() {
		return board;
	}
	
	/**
	 * Accessor
	 * 
	 * @return Number of rows in board 
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Accessor
	 * 
	 * @return Number of columns in board 
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Method for checking the max. count of pieces in a row for a player
	 * @param colour
	 * 			Character identifying player's colour
	 * 
	 * @return Max. count of pieces in a row
	 */
	public int checkCount(char colour) {
		
		int count = 0;
		int max = 0;
		// check horizontal
		// - - - -
		// 0 0 0 0
		// - - - -
		// - - - -
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == colour){
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else{
					count = 0;
				}
			}
			count = 0;
		}
		// check vertical 
		// - 0 - -
		// - 0 - -
		// - 0 - -
		// - 0 - -		
		count = 0;
		for(int i=0; i<board[0].length; i++){
			for(int j=0; j<board.length; j++){
				if(board[j][i] == colour){
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else{
					count = 0;
				}
			}
			count = 0;
		}
		
		//check down-right (bottom)
		// 0 - - -
		// 0 0 - -
		// 0 0 0 -
		// 0 0 0 0
		for (int i = 0; i < board.length; i++) {
			count = 0;
			for (int j = i, k = 0; j < board.length && k < board[0].length; j++, k++) {
				if (board[j][k] == colour) {
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		//check down-right (top)
		// - 0 0 0
		// - - 0 0
		// - - - 0
		// - - - -
		for (int i = 1; i < board[0].length; i++) {
			count = 0;
			for (int j = 0, k = i; j < board.length && k < board[0].length; j++, k++) {
				if (board[j][k] == colour) {
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		//check up-right (bottom)
		// - - - 0
		// - - 0 0
		// - 0 0 0
		// 0 0 0 0
		for (int i = 0; i < board[0].length; i++) {
			count = 0;
			for (int j = board.length - 1, k = i; j >= 0 && k < board[0].length; j--, k++) {
				if (board[j][k] == colour) {
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else {
					count = 0;
				}
			}
		}
		
		//check up-right (top)
		// 0 0 0 -
		// 0 0 - -
		// 0 - - -
		// - - - -
		for (int i = board.length - 2; i >= 0; i--) {
			count = 0;
			for (int j = i, k = 0; j >= 0 && k < board[0].length; j--, k++) {
				if (board[j][k] == colour) {
					count = count + 1;
					if(count >= max){ 
						max = count;
					}
				}
				else {
					count = 0;
				}
			}
		}
				
		return max;
	}
	
}
