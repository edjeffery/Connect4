import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour {
	
	private BufferedReader input;
	private char[][] board;
	boolean hasWon = false;
	Board b;
	View view = new View(board);
	
	public MyConnectFour(Board b){
		this.b = b;
		board = b.board;
		input = new BufferedReader(new InputStreamReader(System.in));
		playGame();
	}
	
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		view.printBoard(board);
		boolean win = false;
		while(!win){
			// player 1
			String userInput = getUserInput();
			int move = Integer.parseInt(userInput);
			placeCounter('r', move);
			checkWin('r');
			view.printBoard(board);
			if(hasWon){
				win = true;
				System.out.println("You Have Won!!!");
			}
			else{
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter('y', move);
				hasWon = false;
				
				checkWin('y');
				view.printBoard(board);
				if(hasWon){
					win = true;
					System.out.println("You Have Won!!!"); //TODO move this statement DONE
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
	
	private String getUserInput(){
		String toReturn = null;
		try{			
			toReturn = input.readLine(); //TODO duplicate local variable TODO and missing semi-colon DONE
		}
		catch(Exception e){
			System.out.println(e.getMessage()); //TODO print exception to console DONE
		}
		return toReturn;
	}
	
	private void placeCounter(char player, int position){
		boolean placed = false;
		for(int i=board.length-1; i>=0; i--){ 
			if(!placed){
				if(board[i][position-1] == 0){ 
					board[i][position-1] = player;
					placed = true; 
				}
				else if(board[i][position-1] != 'r'){ 
					// skip
				}
			}
		}
	}
}
