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
	public UserInput() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Method for getting user input from command line
	 * 
	 * @return Move in String format
	 */
	public String getUserInput(){
		String toReturn = null;
		try{
			toReturn = input.readLine(); 
			/*do {
				System.out.printf("Enter a column number: ");
				toReturn = input.readLine(); 
			} while (!isValidInput(toReturn));*/
		}
		catch(Exception e){
			System.out.println("" + e); // Printing a null pointer error message each time?
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
		int range = b.getCol();
		for (int i = 1; i <= range; i++) {
			if (i == Integer.parseInt(input)) {
				return true;
			}
		}
		return false;
	}
	
}
