
public class Player {
	
	private char[][] board;
	boolean hasWon = false;
	Board b;
	View view; 
	String userInput;
	int move;
	
	public Player(Board b){
		this.b = b;
		board = b.board;
		view = new View(board);
	}
	
	public void playGame(char player, String input){
		
		move = generateMove(input);
		b.placeCounter(player, move);
		hasWon = b.checkWin(player);
		view.printBoard(board);
			
	}
		
	public boolean hasWon() {
		if (hasWon) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private int generateMove(String userInput) {
		int move = Integer.parseInt(userInput);
		return move;
	}
	
}
