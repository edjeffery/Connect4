import java.util.Random;

public class BotInput {
	
	Random random;
	
	public BotInput() {
		random = new Random();
	}
	
	public String getBotInput(int min, int max) {
		String s = String.valueOf(getRandomNumber(min, max));
		return s;
	}
	
	private int getRandomNumber(int min, int max) {
		int r = min + random.nextInt(max - min + 1);
		return r; 
	}
	
	private int getBestMove(char[][] board, char colour) {
		for(int i = 0; i < board[0].length; i++){
			Board testBoard = new Board(board);
			//char[][] botBoard = testBoard.getBoard();
			testBoard.placeCounter(colour, i);
		}
		return 0;
	}
	
}
