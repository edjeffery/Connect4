import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {

	private BufferedReader input;
	
	public UserInput() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String getUserInput(){
		String toReturn = null;
		try{			
			toReturn = input.readLine(); 
		}
		catch(Exception e){
			System.out.println(e.getMessage()); 
		}
		return toReturn;
	}
	
	public String validateInput(String input) {
		boolean validated = false;
		while(!validated) {
			if (input.length() == 0) {
				System.out.println("Please enter a move.");
			}
			else if (input.length() > 1) {
				System.out.println("Please enter a one digit number.");
			}
			else {
				validated = true;
			}
		}
		return input;
	}
	
}
