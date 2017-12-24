import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyConnectFour { //TODO bad class naming DONE
	
	public static void main(String[] args){
		new MyConnectFour();
	}
	
	private BufferedReader input; //TODO Good practice to put variables at start of class
	private char[][] board;
	
	public MyConnectFour(){
		board = new char[6][7]; //TODO Check char 2D arrays
		input = new BufferedReader(new InputStreamReader(System.in));
		playGame();
	}
	
	private void playGame(){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in"); //TODO missing semi-colon DONE
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		printBoard();
		boolean win = false;
		while(!win){
			// player 1
			String userInput = getUserInput(); //TODO no camel case DONE
			int move = Integer.parseInt(userInput);
			placeCounter('r', move); //TODO takes wrong data types
			boolean hasWon = false;
			int count = 0;
			// check horizontal
			for(int i=0; i<board.length; i++){ //TODO very similar to the block below - refactor? And also player 1 vs player 2 blocks
				for(int j=0; j<board[i].length; j++){
					if(board[i][j] == 'r'){
						count = count + 1;
						if(count > 4){
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
			for(int i=0; i<board.length; i++){ //TODO using row length rather than column DONE
				for(int j=0; j<board[i].length; j++){ //TODO using column length rather than row DONE
					if(board[i][j] == 'r'){ //TODO i and j the wrong way around DONE
						count = count + 1;
						if(count > 4){
							hasWon = true;
						}
					}
					else{
						count = 0;
					}
				}
				
			}
			printBoard();
			if(hasWon){
				win = true;
			}
			else{
				//player 2
				userInput = getUserInput();
				move = Integer.parseInt(userInput);
				placeCounter('y',move);
				hasWon = false;
				count = 0;
				// check horizontal
				for(int i=0; i<board.length; i++){
					for(int j=0; j<board[i].length; j++){
						if(board[i][j] == 'y'){
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							
						}
					}
					count = 0;
				}
				// check vertical 
				count = 0;
				for(int i=0; i<board.length; i++){ //TODO using row length rather than column DONE
					for(int j=0; j<board[i].length; j++){ //TODO using column length rather than row DONE
						if(board[i][j] == 'y'){ //TODO i and j the wrong way around DONE
							count = count + 1;
							if(count >= 4){
								hasWon = true;
							}
						}
						else{
							 
						}
					}
					count = 0;
				}
				printBoard(); //TODO missing semi-colon DONE
				if(hasWon){
					win = true;
				}
			}
			System.out.println("You Have Won!!!"); //TODO move this statement
		}
		
	}
	
	private String getUserInput(){
		String toReturn = null;
		try{			
			toReturn = input.readLine(); //TODO duplicate local variable TODO and missing semi-colon DONE
		}
		catch(Exception e){
			
		}
		return toReturn;
	}
	
	private void printBoard(){
		for(int i=0; i<board.length; i++){ //TODO semi-colon makes this first part a statement so 'i' is not recognised below DONE //TODO either less than length or less than or equal to length-1
			for(int j=0; j<board[i].length-1; j++){ //TODO spelling error DONE
				if(board[i][j] == 'r'){ //TODO i and j the wrong way around DONE
					System.out.print("| r ");
				}
				else if(board[i][j] == 'y'){ //TODO i and j the wrong way around DONE
					System.out.print("| y ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		System.out.println("  1   2   3   4   5   6   7");
	}
	
	private void placeCounter(char player, int position){
		boolean placed = false;
		if(player == 'r'){
			for(int i=board.length-1; i>=0; i--){ //TODO should be i-- DONE
				if(!placed){
					if(board[i][position-1] == 'y'){ //TODO array starts at 0 so need to do -1 DONE
						// skip
					}
					else if(board[i][position-1] != 'r'){ //TODO array starts at 0 so need to do -1
						board[i][position-1] = 'r'; //TODO array starts at 0 so need to do -1
						placed = true; //TODO spelling error on true DONE
					}
					//TODO need an else statement here
				}
			}
		}
		else{
			for(int i=board.length-1; i>=0; i--){
				if(!placed){
					if(board[i][position-1] == 'r'){ //TODO incorrect data type DONE
						// skip
					}
					else if(board[i][position-1] != 'y'){
						board[i][position-1] = 'y'; //TODO missing semi-colon DONE
						placed = true;
					} 
				}
			}
		}
	}
}
