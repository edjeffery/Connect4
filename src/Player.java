
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
		// Testing a simple AI for the bot's move
		if (player == 'y') {
			//char[][] testBoard = board;
			char[][] testBoard = new char[6][7];
			for(int i=0; i<board.length; i++){
				for(int j=0; j<board[i].length; j++){
					testBoard[i][j] = board[i][j];
				}
			}
			BotInput bi = new BotInput();
			//System.out.println("Best move = " + bi.getBestMove(testBoard, player)); 
			move = generateMove(bi.getBestMove(testBoard, player)); 
		}
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
