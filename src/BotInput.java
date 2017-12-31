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
	
	/**
	 * Semi-random/clever move generator for looking one-move ahead.
	 * @param board
	 * @param colour
	 * @return move in String format
	 */
	public String getBestMove(char[][] board, char colour) {
		int[] allScores = new int[7];
		int bestScore = 0;
		int bestMove = 4;
		for (int i = 1; i <= board[0].length; i++){
			char[][] tempBoard = new char[6][7];
			for(int j=0; j<board.length; j++){
				for(int k=0; k<board[0].length; k++){
					tempBoard[j][k] = board[j][k];
				}
			}
			Board botBoard = new Board(tempBoard);
			botBoard.placeCounter(colour, i);
			int maxScore = botBoard.checkCount(colour);
			System.out.println(maxScore);
			allScores[i-1] = maxScore;
		}
		for (int j = 0; j < allScores.length; j++) {
			if (allScores[j] > bestScore) {
				bestScore = allScores[j];
				bestMove = j+1;
			}
		}
		// Return random number if all scores are equal
		if (testEqual(allScores)) {
			return String.valueOf(getRandomNumber(1, 7));
		}
		System.out.println("Best move = " + bestMove);
		return String.valueOf(bestMove);
	}
	
	private boolean testEqual(int[] array) {
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] != array[0]) {
	            return false;
	        }
	    }
	    return true;
	}
	
}
