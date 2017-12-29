
public class GameLogic {
	
	public enum Counter {
		RED, YELLOW
	}
	
	public static void main(String[] args){
		Board board = new Board(6, 7);
		new MyConnectFour(board.getBoard());
	}	
	
}
