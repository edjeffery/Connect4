import java.util.Random;

/**
 * Class for generating a bot (instead of a user).
 * 
 * @author edjeffery
 * @version 1.0
 * @release 2018-01-12
 * @see Player.java
 */
public class Bot extends Player {
	
	Random random;
	
	/**
	 * Constructor. Sets the bot's colour (ID) and instantiates the random number generator.
	 * @param colour
	 * 			Colour (ID) of bot
	 */
	public Bot(char colour) {
		// Use the super constructor to set the colour
		super(colour);
		random = new Random();
	}
	
	/**
	 * Semi-random/clever move generator that looks one-move ahead and tries
	 * each of the possible moves to see which gives the highest number of
	 * counters in a row.
	 * @param board
	 * 			2D array of Connect4/N board
	 * @param colour
	 * 			Colour piece of player (identifier)
	 * 
	 * @return Move in String format
	 */
	@Override
	public int getNextMove(Board board) {
		int rows = board.getRow();
		int cols = board.getCol();
		int[] allScores = new int[cols];
		int bestScore = 0;
		int bestMove = cols / 2; // Place counter in middle of board if something goes wrong
		int maxScore;
		
		// For each move, simulate the move in a board and store the 'score' of that move in allScores array
		// Return move which gives greatest number of pieces in a row
		// If all moves equal, return random move
		for (int i = 1; i <= cols; i++){
			// Creates temporary board and stores the board given as an argument without memory address reference
			char[][] tempBoard = new char[rows][cols];
			for(int j = 0; j < rows; j++){
				for(int k = 0; k < cols; k++){
					tempBoard[j][k] = board.getBoard()[j][k];
				}
			}
			Board botBoard = new Board(tempBoard);
			// If column full, set score for that move equal to 0. Else test move and record score.
			if (botBoard.isColumnFull(i)) {
				maxScore = 0;
			}
			else {
				botBoard.placeCounter(colour, i);
				maxScore = botBoard.checkCount(colour);
			}
			// Store the score
			allScores[i-1] = maxScore;
		}
		
		// Loops through scores in array and selects move with highest score
		for (int j = 0; j < allScores.length; j++) {
			if (allScores[j] > bestScore) {
				bestScore = allScores[j];
				bestMove = j + 1;
			}
		}
		
		// Return random number if all scores are equal
		if (testEqual(allScores)) {
			return getRandomNumber(1, 7);
		}
		return bestMove;
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
		int randomNum = min + random.nextInt(max - min + 1);
		return randomNum; 
	}
	
	/**
	 * Method for testing whether all values in integer array are equal.
	 * This is used to test the allScores array which the bot uses when 
	 * trying to work out the best next move. If all equal, then a random
	 * number will be used instead.
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
