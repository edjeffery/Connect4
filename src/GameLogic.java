
public class GameLogic {
	
	public enum Colour {
		RED,
		YELLOW
	}
	
	boolean hasWon = false;
	String ui;
	UserInput uInput;
	Player player;
	
	public void test() {
		while(!hasWon) {
			ui = uInput.getUserInput();
			player
		}
	}
	
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
		Board board = new Board(6, 7);
		new Player(board);
	}
	
}
