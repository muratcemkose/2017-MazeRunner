// Murat Cem Köse Basic Programming Final Project
package initials;
import java.util.Scanner;

import gameDynamics.*;
// The class where the game is initialized and played
public class Game {
	private static boolean nextAction=true;
	
	public static boolean getNextAction() {
		return nextAction;
	}

	public static void setNextAction(boolean nextaction) {
		nextAction = nextaction;
	}
	
	public static void main(String[] args) {
		// Information about the game
		System.out.println("                           Welcome to MyMaze!");
		System.out.println();
		System.out.println("Game Rules:");
		System.out.println("  Rule 1: Y states your position while E is the ending point.");
		System.out.println("  Rule 2: Walls (---) can not be passed.");
		System.out.println("  Rule 3: Breakable walls (-b-) can be passed with hammer.");
		System.out.println("  Rule 4: Doors (-d-) can be passed with key.");
		System.out.println("  Rule 5: Key and hammer are hidden in the map.");
		System.out.println("  Rule 6: Wormholes bring you to the starting point and can not be undone.");
		System.out.println("  Rule 7: Enter '8' (up), '4' (left), '2' (down), '6' (right), 'u' (undo)");
		System.out.println();
		System.out.println("Please pick a difficulty level '1'-'2'-'3' or a valid map path.");
		// Select difficulty
		Scanner scan = new Scanner( System.in );
		String input=scan.next();
		String mapName=input;
		Mapping map= new Mapping(mapName);
		// Player information
		System.out.println("Please state your name");
		String playerName=scan.next();
		System.out.println("Please state your maze name");
		String mazeName=scan.next();
		System.out.println("");
		System.out.println("");
		System.out.println(" Let the game begin!");
		// Game initialization
		Runner mazeRunner=new Runner(playerName,mazeName,map.getStart());
		VisualDesign UI=new VisualDesign(map,mazeRunner);
		UI.display();
		Turn turnAction;
		while(getNextAction()==true) { // Continues until the player reaches the end point
			input=scan.next();
			try {  // Input control
				if(input.equals("8")==false&&input.equals("4")==false&&input.equals("2")==false&&input.equals("6")==false&&input.equals("u")==false) {throw new IllegalArgumentException();}
			}
			catch(IllegalArgumentException e){
				System.out.println("Please enter one of '8, 4, 2, 6, u'");
				continue;
			}
			// Applying chances
			turnAction=new Turn(input,mazeRunner,map);
			setNextAction(turnAction.isNextAction());
			UI.setPlayer(mazeRunner);
			if(getNextAction()==true) { // Displaying current map
				UI.display();
			}
			else{  // Adding the new score and displaying score history.
				System.out.print("Your score is: ");
				System.out.println(mazeRunner.getScore());
				Scores scoreList=new Scores(mazeRunner.getPlayerName(),mazeRunner.getMazeName(),mazeRunner.getScore(),mapName);
				scoreList.doScoring();
			}
		}
		scan.close();
		
	}
}
