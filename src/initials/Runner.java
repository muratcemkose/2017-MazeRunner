package initials;
import java.util.ArrayList;
// The class for the player information and position
public class Runner {
	private String playerName;
	private String mazeName;
	private int [] position;
	private boolean hasKey=false; // Starts without key and hammer
	private boolean hasHammer=false;
	private ArrayList<int[]>history=new ArrayList<int[]>();
	private int score=0; // Initial score is 0

	public Runner(String PlayerName, String MazeName, int[] position) { // Constructor
		setPlayerName(PlayerName);
		setMazeName(MazeName);
		setPosition(position.clone());
		addMove(position.clone());
	}
	public void doUndo() { // Undo movement
		try{
			if(history.size()<2) {throw new ArrayIndexOutOfBoundsException();}
			position=history.get(history.size()-2); // While we initiate with first position, the size should be at least 2
			history.remove(history.size()-1); // Removing last move
			addScore();
		}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("You havent done any moves!");
		}

	}
	// Setters and getters.
	public void addKey() {
		hasKey=true;
	}
	public boolean getKey() {
		return hasKey;
	}
	public void addHammer() {
		hasHammer=true;
	}
	public boolean getHammer() {
		return hasHammer;
	}
	public void addMove(int[] a) {
		history.add(a);
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getMazeName() {
		return mazeName;
	}
	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	public int getScore() {
		return score;
	}
	public void addScore() {
		this.score=this.score+1;
	}
	public ArrayList<int[]> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<int[]> history) {
		this.history = history;
	}

}
