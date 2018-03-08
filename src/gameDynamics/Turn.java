package gameDynamics;
import initials.Mapping;
import initials.Runner;

// The class where changes for each turn is applied
public class Turn extends InputHandler {
	private String action;
	private boolean nextAction=true;
	
	public Turn(String action,Runner player, Mapping map) { // Constructor
		super(player, map);
		this.setAction(action);
		actionApply();
	}
	public void actionApply() {
		if(action.equals("2")){
			try{ 
			// Checking if the action can take place or if the getPlayer() reaches the end point
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+2][getPlayer().getPosition()[1]].equals("-")==true) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+2][getPlayer().getPosition()[1]].equals("b")==true && getPlayer().getHammer()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+2][getPlayer().getPosition()[1]].equals("d")==true && getPlayer().getKey()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+4][getPlayer().getPosition()[1]].equals("E")) {
				System.out.println("Congrats! You have reached the end point!");
				setNextAction(false);
				getPlayer().addScore();
			} // Checking wormhole
			if (getMaze().getMapMatrix()[getPlayer().getPosition()[0]+4][getPlayer().getPosition()[1]].equals("WH")) {
				System.out.println("Oh no! Wormhole! You are back to where you started.");
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]+4),Integer.valueOf(getPlayer().getPosition()[1])};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().setPosition(getMaze().getStart().clone());
				getPlayer().addScore();
			}
			// Checking if the getPlayer() finds the key
			else {
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+4][getPlayer().getPosition()[1]].equals("K")){
					System.out.println("Congrats! You have found the key!");
					getPlayer().addKey();} 
				// Checking if the getPlayer() finds the hammer
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]+4][getPlayer().getPosition()[1]].equals("H")){
					System.out.println("Congrats! You have found the hammer!");
					getPlayer().addHammer();}
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]+4),Integer.valueOf(getPlayer().getPosition()[1])};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().addScore();
			}
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Unfortunutely, You are not allowed to go that way!");
				
			}
		}
		
		if(action.equals("8")){
			try{
			// Checking if the action can take place or if the getPlayer() reaches the end point
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-2][getPlayer().getPosition()[1]].equals("-")==true) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-2][getPlayer().getPosition()[1]].equals("b")==true && getPlayer().getHammer()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-2][getPlayer().getPosition()[1]].equals("d")==true && getPlayer().getKey()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-4][getPlayer().getPosition()[1]].equals("E")) {
				System.out.println("Congrats! You have reached the end point!");
				setNextAction(false);
				getPlayer().addScore();
			}// Checking wormhole
			if (getMaze().getMapMatrix()[getPlayer().getPosition()[0]-4][getPlayer().getPosition()[1]].equals("WH")) {
				System.out.println("Oh no! Wormhole! You are back to where you started.");
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]-4),Integer.valueOf(getPlayer().getPosition()[1])};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().setPosition(getMaze().getStart().clone());
				getPlayer().addScore();
			}
			else { // Checking if the getPlayer() finds the key
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-4][getPlayer().getPosition()[1]].equals("K")){ // Checking if there is a key
					System.out.println("Congrats! You have found the key!");
					getPlayer().addKey();}
				// Checking if the getPlayer() finds the hammer
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]-4][getPlayer().getPosition()[1]].equals("H")){ // Checking if there is a hammer
					System.out.println("Congrats! You have found the hammer!");
					getPlayer().addHammer();}
				// Setting the new position to the getPlayer() and to the map
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]-4),Integer.valueOf(getPlayer().getPosition()[1])};
				getPlayer().setPosition(temp); 
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().addScore();
			}
			
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Unfortunutely, You are not allowed to go that way!");
				
			}
		}
		if(action.equals("4")){
			try{
			// Checking if the action can take place or if the getPlayer() reaches the end point
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-2].equals("|")==true) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-2].equals("b")==true && getPlayer().getHammer()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-2].equals("d")==true && getPlayer().getKey()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-4].equals("E")) {
				System.out.println("Congrats! You have reached the end point!");
				setNextAction(false);
				getPlayer().addScore();
			} // Checking wormhole
			if (getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-4].equals("WH")) {
				System.out.println("Oh no! Wormhole! You are back to where you started.");
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]),Integer.valueOf(getPlayer().getPosition()[1]-4)};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().setPosition(getMaze().getStart().clone());
				getPlayer().addScore();
			}
			else { // Checking if the getPlayer() finds the key
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-4].equals("K")){ // Checking if there is a key
					System.out.println("Congrats! You have found the key!");
					getPlayer().addKey();}
				// Checking if the getPlayer() finds the hammer
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]-4].equals("H")){ // Checking if there is a hammer
					System.out.println("Congrats! You have found the hammer!");
					getPlayer().addHammer();}
				// Setting the new position to the getPlayer() and to the map
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]),Integer.valueOf(getPlayer().getPosition()[1]-4)};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().addScore();
			}
			
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Unfortunutely, You are not allowed to go that way!");
				
			}
		}
		if(action.equals("6")){
			try{
			// Checking if the action can take place or if the getPlayer() reaches the end point
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+2].equals("|")==true) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+2].equals("b")==true && getPlayer().getHammer()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+2].equals("d")==true && getPlayer().getKey()==false) {throw new ArrayIndexOutOfBoundsException();}
			if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+4].equals("E")) {
				System.out.println("Congrats! You have reached the end point!");
				setNextAction(false);
				getPlayer().addScore();
			} // Checking wormhole
			if (getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+4].equals("WH")) {
				System.out.println("Oh no! Wormhole! You are back to where you started.");
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]),Integer.valueOf(getPlayer().getPosition()[1]+4)};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().setPosition(getMaze().getStart().clone());
				getPlayer().addScore();

			}
			else {  // Checking if the getPlayer() finds the key
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+4].equals("K")){ // Checking if there is a key
					System.out.println("Congrats! You have found the key!");
					getPlayer().addKey();}
				// Checking if the getPlayer() finds the hammer
				if(getMaze().getMapMatrix()[getPlayer().getPosition()[0]][getPlayer().getPosition()[1]+4].equals("H")){ // Checking if there is a hammer
					System.out.println("Congrats! You have found the hammer!");
					getPlayer().addHammer();}
				// Setting the new position to the getPlayer() and to the map
				int []temp= {Integer.valueOf(getPlayer().getPosition()[0]),Integer.valueOf(getPlayer().getPosition()[1]+4)};
				getPlayer().setPosition(temp);
				temp=getPlayer().getPosition().clone();
				getPlayer().addMove(temp);
				getPlayer().addScore();
			}
			
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Unfortunutely, You are not allowed to go that way!");
				
			}
		}
		if(action.equals("u")){ // Applying undo action
			int[] temp=getPlayer().getHistory().get(getPlayer().getHistory().size()-1);
			if (getMaze().getMapMatrix()[temp[0]][temp[1]].equals("WH")) {
				System.out.println("Can not undo wormhole");
				getPlayer().addScore();}
			else
				getPlayer().doUndo();
		}

		
		}
	// Setters and getters
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public boolean isNextAction() {
		return nextAction;
	}
	public void setNextAction(boolean nextAction) {
		this.nextAction = nextAction;
	}
	
	
	}


