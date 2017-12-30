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
	
	public String getBestMove(char[][] board, char colour) {
		int[] allScores = new int[7];
		int bestScore = 0;
		int bestMove = 4;
		for (int i = 1; i <= board[0].length; i++){
			Board testBoard = new Board(board);
			testBoard.placeCounter(colour, i);
			int maxScore = testBoard.checkCount(colour);
			System.out.println(maxScore);
			allScores[i-1] = maxScore;
		}
		for (int j = 0; j < allScores.length; j++) {
			if (allScores[j] > bestScore) {
				bestMove = j;
			}
		}
		System.out.println("Best move = " + bestMove);
		return String.valueOf(bestMove);
	}
	
}
