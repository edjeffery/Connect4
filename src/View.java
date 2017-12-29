
public class View {
	
	private char[][] board;
	
	public View(char[][] board) {
		this.board = board;
	}
	
	public void printBoard(char[][] board) {
		for(int i=0; i<board.length; i++){ 
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == 'r'){ 
					System.out.print("| r ");
				}
				else if(board[i][j] == 'y'){ 
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7  ");
	}
	
}
