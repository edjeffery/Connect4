
public class Board {
	
	private char[][] board;
	private int row;
	private int col;
	
	public Board (int row, int col) {
		this.row = row;
		this.col = col;
		board = new char[row][col];
	}
	
	public boolean checkWin(char colour, char[][] board) {
		
		int count = 0;
		// check horizontal
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == colour){
					count = count + 1;
					if(count >= 4){ 
						return true;
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
					if(count >= 4){
						return true;
					}
				}
				else{
					count = 0;
				}
			}
			
		}
		return false;
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
	
	
	
}
