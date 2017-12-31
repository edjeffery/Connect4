
public class Board {
	
	public char[][] board;
	private int row;
	private int col;
	private int n;
	
	public Board (int row, int col, int n) {
		this.row = row;
		this.col = col;
		this.n = n;
		board = new char[row][col];
	}
	
	public Board (char[][] board) {
		this.board = board;
	}
	
	public void placeCounter(char player, int position){
		boolean placed = false;
		for(int i=board.length-1; i>=0; i--){ 
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
	}
	
	public boolean checkWin(char colour) {
		if (checkCount(colour) >= n) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public char[][] getBoard() {
		return board;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public int checkCount(char colour) {
		
		int count = 0;
		int max = 0;
		// check horizontal
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
			
		}
		// check vertical 
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
