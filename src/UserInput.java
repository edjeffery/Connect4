import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {

	private BufferedReader input;
	Board b;
	
	public UserInput() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
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
