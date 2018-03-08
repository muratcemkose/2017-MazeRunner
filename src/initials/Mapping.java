package initials;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// The class that keeps map design
public class Mapping {
	private int[] start = new int [2]; //start coordinates
	private int[] end = new int [2]; //end coordinates
	private int[] key = new int [2];
	private int[] hammer = new int [2];
	private int[] wormHole = new int [2];
	private String [] [] mapMatrix;
	
	public Mapping(String mapInput) { // Constructor
	doMap(mapInput);
	}
	public void doMap(String mapInput) {
		File file = new File(".");
		String currentDirectory = file.getAbsolutePath();
		String tempPath;
		if (mapInput.equals("1") || mapInput.equals("2") || mapInput.equals("3"))
			tempPath=currentDirectory+"\\level\\"+"level"+mapInput+".txt"; // Getting level infomation from current directory
		else
			tempPath=mapInput;
		try {
			Scanner fileIn = new Scanner(new File(tempPath));
			String [] line=new String [7];
			int maxx=0;
			int maxy=0;
			// Reading the map file line by line, getting the dimensions of the map and taking game attribute coordinates 
			while(fileIn.hasNextLine()==true) { 
				line=fileIn.nextLine().split(",");
				if (line[0].equals("Xcoordinate")) {continue;} // Skipping the header line
				if(Integer.parseInt(line[0])>maxx) { // Taking x coordinate
					maxx=Integer.parseInt(line[0]);
					}
				if(Integer.parseInt(line[1])>maxy) { // Taking y coordinate
					maxy=Integer.parseInt(line[1]);
					}
				// Checking if the current line represents any of the position of game attributes
				if(line[6].equals("start")) { 
					start[0]=Integer.parseInt(line[0]);
					start[1]=Integer.parseInt(line[1]);
				}
				if(line[6].equals("end")){
					end[0]=Integer.parseInt(line[0]);
					end[1]=Integer.parseInt(line[1]);
				}
				if(line[6].equals("key")){
					key[0]=Integer.parseInt(line[0]);
					key[1]=Integer.parseInt(line[1]);
				}
				if(line[6].equals("hammer")){
					hammer[0]=Integer.parseInt(line[0]);
					hammer[1]=Integer.parseInt(line[1]);
				}
				if(line[6].equals("wormhole")){
					wormHole[0]=Integer.parseInt(line[0]);
					wormHole[1]=Integer.parseInt(line[1]);
				}
			}
			mapMatrix=new String[5+maxx*4] [5+maxy*4]; // Matrix construction
			for(int i=0;i<mapMatrix.length;i++) { // Initially, assigning space for each point
				for (int j=0;j<mapMatrix[0].length;j++) {
					mapMatrix[i][j]=" ";
					}
			}
			for(int i=0;i<mapMatrix.length;i=i+4) { // Putting + for each corner of each point
				for (int j=0;j<mapMatrix[0].length;j=j+4) {
					mapMatrix[i][j]="+";
				}
			}
			
			fileIn.close();
			fileIn = new Scanner(new File(tempPath));
			
			while(fileIn.hasNextLine()==true){ // Reading the file again, this time checking the map attributes
				line=fileIn.nextLine().split(",");
				if(line[2].equals("wall")) {
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[2].equals("breakable")) {
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="b";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[2].equals("door")) {
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="d";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}				
				if(line[2].equals("fake")) {
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="f";
					mapMatrix[mapMatrix.length-1-4-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				
				if(line[3].equals("wall")) {
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[3].equals("breakable")) {
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="b";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[3].equals("door")) {
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="d";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[3].equals("fake")) {
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][1+4*Integer.parseInt(line[1])]="-";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][2+4*Integer.parseInt(line[1])]="f";
					mapMatrix[mapMatrix.length-1-4*Integer.parseInt(line[0])][3+4*Integer.parseInt(line[1])]="-";
				}
				if(line[4].equals("wall")) {
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
				}
				if(line[4].equals("breakable")){
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="b";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
				}
				if(line[4].equals("door")){
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="d";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
				}				
				if(line[4].equals("fake")){
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="f";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4+4*Integer.parseInt(line[1])]="|";
				}
				if(line[5].equals("wall")) {
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
				}
				if(line[5].equals("breakable")) {
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="b";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
				}
				if(line[5].equals("door")) {
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="d";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
				}
				if(line[5].equals("fake")) {
					mapMatrix[mapMatrix.length-1-1-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
					mapMatrix[mapMatrix.length-1-2-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="f";
					mapMatrix[mapMatrix.length-1-3-4*Integer.parseInt(line[0])][4*Integer.parseInt(line[1])]="|";
				}
			}
			// Repositioning the game attributes
			start[0]=mapMatrix.length-4*start[0]-3;
			start[1]=4*start[1]+2;
			end[0]=mapMatrix.length-4*end[0]-3;
			end[1]=4*end[1]+2;
			key[0]=mapMatrix.length-4*key[0]-3;
			key[1]=4*key[1]+2;
			hammer[0]=mapMatrix.length-4*hammer[0]-3;
			hammer[1]=4*hammer[1]+2;
			wormHole[0]=mapMatrix.length-4*wormHole[0]-3;
			wormHole[1]=4*wormHole[1]+2;
			// Positioning the game attributes into the map
			mapMatrix[start[0]][start[1]]="S";
			mapMatrix[end[0]][end[1]]="E";
			mapMatrix[key[0]][key[1]]="K";
			mapMatrix[hammer[0]][hammer[1]]="H";
			mapMatrix[wormHole[0]][wormHole[1]]="WH";
			fileIn.close();
		} 
		catch (FileNotFoundException e) {
			// Map selection control
			System.out.println("Given path is not a valid path please enter a valid path or map level.");
			Scanner scan = new Scanner( System.in );
			String input=scan.next();
			doMap(input); // If given file is not a valid txt file, a new file is requested and the same procedure is done
		}
	}

	public int[] getStart() {
		return start;
	}

	public void setStart(int[] start) {
		this.start = start;
	}

	public int[] getEnd() {
		return end;
	}

	public void setEnd(int[] end) {
		this.end = end;
	}

	public int[] getKey() {
		return key;
	}

	public void setKey(int[] key) {
		this.key = key;
	}

	public int[] getHammer() {
		return hammer;
	}

	public void setHammer(int[] hammer) {
		this.hammer = hammer;
	}

	public String[][] getMapMatrix() {
		return mapMatrix;
	}

	public void setMapMatrix(String[][] mapMatrix) {
		this.mapMatrix = mapMatrix;
	}
	
}
