import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class for handling a user
 * @author edjeffery
 *
 * @version 1.0
 */
public class User extends Player {

	private BufferedReader input;
	
	/**
	 * Constructor
	 */
	public User(char colour) {
		super(colour);
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Method for generating a proper move from input
	 * @param Board
	 * 			Board object - not used in User
	 * 
	 * @return Move in integer format
	 */
	@Override
	public int getNextMove(Board board) { // Does this need to take Board as an argument?
		int move = Integer.parseInt(getUserInput());
		return move;
	}
	
	/**
	 * Method for getting user input from command line
	 * 
	 * @return Move in String format
	 */
	public String getUserInput(){
		String toReturn = null;
		try {
			do {
				System.out.println("Enter a column number: ");
				toReturn = input.readLine();
			} while (!isValidInput(toReturn));
		} catch(Exception e){
			System.out.println("" + e);
		}
		
		return toReturn;
	}
	
	/**
	 * Method for checking whether input is valid or not
	 * @param input
	 * 			User's input from command line
	 * 
	 * @return True if valid, false if not
	 */
	public boolean isValidInput(String input) {
		int intInput = 0;
		int range = GameLogic.COLS;

		try {
			intInput = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("Input is not valid. Please try again.");
			return false;
		}
		
		for (int i = 1; i <= range; i++) {
			if (i == intInput) {
				return true;
			}
		}
		return false;
	}
	
}
