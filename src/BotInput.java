import java.util.Random;

/**
 * Class for generating a bot input (instead of a user)
 * @author edjeffery
 *
 * @version 1.0
 */
public class BotInput {
	
	Random random;
	
	/**
	 * Constructor
	 */
	public BotInput() {
		random = new Random();
	}
	
	/**
	 * Method for getting and returning a random move in column range
	 * @param min
	 * 			Lowest column number
	 * @param max
	 * 			Highest column number
	 * 
	 * @return Move in String format
	 */
	public String getBotInput(int min, int max) {
		String s = String.valueOf(getRandomNumber(min, max));
		return s;
	}
	
	/**
	 * Method for getting and returning a random integer in a range
	 * @param min
	 * 			Minimum value random number can be
	 * @param max
	 * 			Maximum value random number can be
	 * 
	 * @return Random integer
	 */
	private int getRandomNumber(int min, int max) {
		int r = min + random.nextInt(max - min + 1);
		return r; 
	}
	
	/**
	 * Semi-random/clever move generator for looking one-move ahead.
	 * @param board
	 * 			2D array of Connect4/N board
	 * @param colour
	 * 			Colour piece of player (identifier)
	 * 
	 * @return Move in String format
	 */
	public String getBestMove(char[][] board, char colour) {
		int[] allScores = new int[board[0].length];
		int bestScore = 0;
		int bestMove = board[0].length / 2;
		
		// For each move, simulate the move in a board
		// Return move which gives greatest number of pieces in a row
		// If all moves equal, return random move
		for (int i = 1; i <= board[0].length; i++){
			// Creates temporary board and stores the board given as an argument without reference
			char[][] tempBoard = new char[board.length][board[0].length];
			for(int j=0; j<board.length; j++){
				for(int k=0; k<board[0].length; k++){
					tempBoard[j][k] = board[j][k];
				}
			}
			Board botBoard = new Board(tempBoard);
			botBoard.placeCounter(colour, i);
			int maxScore = botBoard.checkCount(colour);
			//System.out.println(maxScore);
			allScores[i-1] = maxScore;
		}
		
		// Loops through scores in array and selects move with highest score
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
		//System.out.println("Best move = " + bestMove);
		return String.valueOf(bestMove);
	}
	
	/**
	 * Method for testing whether all values in integer array are equal
	 * @param array
	 * 			Integer array to be tested
	 * 
	 * @return True if all values equal, false is not
	 */
	private boolean testEqual(int[] array) {
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] != array[0]) {
	            return false;
	        }
	    }
	    return true;
	}
	
}
