package gameDynamics;
import initials.Mapping;
import initials.Runner;

// The class for visual display of the game
public class VisualDesign extends InputHandler  implements DisplayInterface{
	public VisualDesign(Mapping mapStructure,Runner player) { // Constructor
		super(player,mapStructure);
	}
	@Override
	public void display() {
		for(int x=0;x<getMaze().getMapMatrix().length;x++) { // Displaying the matrix
			for(int y=0;y<getMaze().getMapMatrix()[0].length;y++) {
				if (x==getPlayer().getPosition()[0] && y==getPlayer().getPosition()[1]) {
					System.out.print("Y");
				}
				else if (getMaze().getMapMatrix()[x][y].equals("f")) { // Hiding the fake wall
					if(getMaze().getMapMatrix()[x][y+1].equals("-")) {
						System.out.print("-");
					}
					else if(getMaze().getMapMatrix()[x+1][y].equals("|")) {
						System.out.print("|");
					}
				}
				else if (getMaze().getMapMatrix()[x][y].equals("K")) { // Hiding the key
					System.out.print(" ");
				}
				else if (getMaze().getMapMatrix()[x][y].equals("H")) { // Hiding the hammer
					System.out.print(" ");
				}
				else if (getMaze().getMapMatrix()[x][y].equals("S")) {
					System.out.print(" ");
				}
				else if (getMaze().getMapMatrix()[x][y].equals("WH")) { // Hiding the hammer
					System.out.print(" ");
				}
				else {
				System.out.print(getMaze().getMapMatrix()[x][y]);
				}
			}
			System.out.println();
		}
		// Displaying the getPlayer() information
		System.out.println(getPlayer().getPlayerName()+" with maze "+getPlayer().getMazeName());
		if (getPlayer().getKey()==true) {
			System.out.print("Key=1 ");
		}
		else {
			System.out.print("Key=0 ");
		}
		if (getPlayer().getHammer()==true) {
			System.out.print("Hammer=1 ");
		}
		else {
			System.out.print("Hammer=0 ");
		}
		System.out.print("Score=");
		System.out.print(getPlayer().getScore());
		System.out.println();
	}

}
