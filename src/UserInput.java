import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Class for handling user input from command line
 * @author edjeffery
 *
 * @version 1.0
 */
public class UserInput {

	private BufferedReader input;
	Board b;
	
	/**
	 * Constructor
	 */
	public UserInput(Board board) {
		input = new BufferedReader(new InputStreamReader(System.in));
		this.b = board;
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
		int range = b.getCol();

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
