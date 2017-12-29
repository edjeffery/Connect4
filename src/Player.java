
public class Player {
	
	private char[][] board;
	boolean hasWon = false;
	Board b;
	View view; 
	UserInput uInput;
	String userInput;
	int move;
	
	public Player(Board b){
		this.b = b;
		board = b.board;
		view = new View(board);
		uInput = new UserInput();
		playGame();
	}
	
	private void playGame(){
		
		view.printBoard(board);
		boolean win = false;
		while(!win){
			// player 1
			userInput = uInput.getUserInput();
			move = generateMove(userInput);
			b.placeCounter('r', move);
			hasWon = b.checkWin('r');
			view.printBoard(board);
			if(hasWon){
				win = true;
				printWinMessage();
			}
			else{
				//player 2
				userInput = uInput.getUserInput();
				move = generateMove(userInput);
				b.placeCounter('y', move);
				hasWon = false;
				hasWon = b.checkWin('y');
				view.printBoard(board);
				if(hasWon){
					win = true;
					printWinMessage();
				}
			}
		}
		
	}
	
	private int generateMove(String userInput) {
		int move = Integer.parseInt(userInput);
		return move;
	}
	
	private void printWinMessage() {
		System.out.println("You Have Won!!!");
	}
	
}
