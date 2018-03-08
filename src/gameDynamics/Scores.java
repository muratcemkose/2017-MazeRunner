package gameDynamics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
// The class for keeping and updating score information
public class Scores  implements DisplayInterface{
	private ArrayList<String[]> scores=new ArrayList<String[]>();
	private String playerName;
	private String mazeName;
	private int score;
	private String mapName;
	public Scores(String playerName, String mazeName ,int score,String mapName) { // Constructor
		this.setPlayerName(playerName);
		this.setMazeName(mazeName);
		this.setScore(score);
		this.setMapName(mapName);
	}
	public void doScoring() {
		try { // Obtaining previous scores
			File file = new File(".");
			String currentDirectory = file.getAbsolutePath();
			Scanner fileIn;
			if (getMapName().equals("1") || getMapName().equals("2") || getMapName().equals("3")) {
				setMapName(getMapName()+".txt");
				fileIn= new Scanner(new File(currentDirectory+"\\Scores of map "+getMapName()));}
			else {
				String [] temp=getMapName().split("\\\\");
				setMapName(temp[temp.length-1]);
				try { // Checking if there is an existing result file 
					fileIn= new Scanner(new File(currentDirectory+"\\Scores of map "+getMapName()));
				} catch (Exception e) {
					FileWriter f2;
					try { // If there is none, creating a result file. 
						f2 = new FileWriter(new File(currentDirectory+"\\Scores of map "+getMapName()), false);
						f2.close();
					} catch (IOException e1) {
					}// Continues the algorithm with newly created result file.
					fileIn= new Scanner(new File(currentDirectory+"\\Scores of map "+getMapName()));
				}
				}
			String [] line=new String [3];
			while(fileIn.hasNextLine()==true) {
				line=fileIn.nextLine().split(",");
				getScores().add(line);
			}
			fileIn.close();
		}
			catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		addScore(); // Adding current player score
		Collections.sort(getScores(),new Comparator<String[]>() { // Sorting the score output by best score
		    public int compare(String[] strings, String[] otherStrings) {
		        return Integer.valueOf(strings[2]).compareTo(Integer.valueOf(otherStrings[2]));
		    }
		});
		// Displaying and saving all scores for chosen level
		display();
		writeScores();
	}
	// Adding a new score
	public void addScore() {
		String [] temp={this.getPlayerName(),this.getMazeName(),String.valueOf(this.getScore())};
		this.getScores().add(temp);
		
	}
	@Override
	public void display() { // Displaying all scores
		System.out.println("         All Scores for map/level "+getMapName().split(".t")[0]);
		System.out.println("Player name - Maze name - Score");
		for(int i=0;i<this.getScores().size();i++) {
			System.out.print(this.getScores().get(i)[0]+" - ");
			System.out.print(this.getScores().get(i)[1]+" - ");
			System.out.print(this.getScores().get(i)[2]);
			System.out.println();
		}
	}
	public void writeScores() { // Writing all scores to txt in a sorted way
		File temp = new File(".");
		String currentDirectory = temp.getAbsolutePath();
		File file=new File(currentDirectory+"\\Scores of map "+getMapName());
		try {
		    FileWriter f2 = new FileWriter(file, false);
		    for(int i=0;i<getScores().size();i++) {
		    	f2.write(getScores().get(i)[0]+","+getScores().get(i)[1]+","+getScores().get(i)[2]+"\r\n");
			}
		    f2.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	// Getter for scores
	public ArrayList<String[]> getScores() {
		return scores;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getMapName() {
		return mapName;
	}
	public void setMapName(String mapName) {
		this.mapName = mapName;
	}
	

}

