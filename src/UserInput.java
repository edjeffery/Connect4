import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserInput {

	private BufferedReader input;
	
	public UserInput () {
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
	
}
