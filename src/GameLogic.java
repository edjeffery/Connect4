
public class GameLogic {
	
	// Not sure how to use enum yet
	/*public enum Colour {
		RED,
		YELLOW
	}*/ 
	
	boolean hasWon = false;
	String c;
	UserInput uInput;
	Player player;
	
	
	public static void main(String[] args){
		System.out.println("Welcome to Connect 4");
		System.out.println("There are 2 players red and yellow");
		System.out.println("Player 1 is Red, Player 2 is Yellow");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");
		runGame();
	}	
	
	private static void runGame() {
		Board board = new Board(6, 7, 4);
		Player player = new Player(board);
		UserInput uInput = new UserInput();
		String c;
		char[] colours = {'r', 'y'};
		char colour = colours[0];
		int i = 0;
		
		boolean win = false;
		while(!win){
			colour = colours[i % 2];
			
			c = uInput.getUserInput();
			player.playGame(colour, c);
			win = player.hasWon();
			if (win) {
				break;
			}
			i++;
		}
		System.out.println("Player " + colour + " has won!!!");
		return;
	}
	
	/*public void printWinMessage() {
		System.out.println("You Have Won!!!");
	}*/
	
}
