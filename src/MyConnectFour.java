
public class MyConnectFour {
	
	private char[][] board;
	boolean hasWon = false;
	Board b;
	View view; 
	UserInput uInput;
	String userInput;
	int move;
	
	public MyConnectFour(Board b){
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
			checkWin('r');
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
				
				checkWin('y');
				view.printBoard(board);
				if(hasWon){
					win = true;
					printWinMessage();
				}
			}
		}
		
	}
	
	private void checkWin(char colour) {
		
		int count = 0;
		// check horizontal
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == colour){
					count = count + 1;
					if(count >= 4){ 
						hasWon = true;
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
						hasWon = true;
					}
				}
				else{
					count = 0;
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
