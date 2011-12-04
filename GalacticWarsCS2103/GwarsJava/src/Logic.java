/**
 * Author : Sesha Sendhil Subramanian
 * Author : Achyut Potheri Balaji
 * Purpose : Implementing the logic of the game
 */

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Logic {
	private Thief thief;
	private Player player1;
	private Player player2;
	private Map map;
	private int turnNumber;
	private int length; // 1= 10turns, 2= 15turns, 3= 20turns, 4= 25turns
	private int difficulty; // 1= easy, 2= normal, 3= hard, 4= Diabolique
	private int mapNumber;
	private boolean turnOver;
	
	
	/** 
	 * Default Class Constructor
	 */

	public Logic() {
		turnNumber = 0;
		map = new Map();
	}
	
	public void saveToFile() throws IOException {
			
			FileWriter fstream = new FileWriter("save.txt");
	        BufferedWriter outStream = new BufferedWriter(fstream);
	        String saveout;
	        if(turnOver){
	        saveout = "" + turnNumber + " done" + " " + length + " " + difficulty
	        + " " + mapNumber + " " + player1.getPosition() + " "
	        + player2.getPosition() + " " + thief.getPosition();
	        }
	        else{
		        saveout = "" + turnNumber + " mid" + " " + length + " " + difficulty
		        + " " + mapNumber + " " + player1.getPosition() + " "
		        + player2.getPosition() + " " + thief.getPosition();
	        }
	        	
	        outStream.write(saveout);
	        outStream.close();
	}
	
	public void loadFromFile() throws IOException{
		Scanner inStream = new Scanner(new File("save.txt"));
		String temp = inStream.next();
		turnNumber = Integer.parseInt(temp);
		String blah = inStream.next();
		temp = inStream.next();
		length = Integer.parseInt(temp);
		temp = inStream.next();
		difficulty = Integer.parseInt(temp);
	    temp = inStream.next();
		mapNumber = Integer.parseInt(temp);
		temp = inStream.next();
		int tempo = Integer.parseInt(temp);
		player1.setPosition(tempo);
		temp = inStream.next();
		player2.setPosition(Integer.parseInt(temp));
		temp = inStream.next();
		thief.setPosition(Integer.parseInt(temp));
		System.out.print("" + length + difficulty + mapNumber + blah );
		
	}
	
	/** 
	 * Randomly chooses the initial positions of the players and the thief
	 * @return The integer array of positions
	 */

	private int positionChooser() {
		int positions;
		int temp1, temp2, temp3;
		Random random = new Random();

		do {
			temp1 = random.nextInt(25) + 1;
			temp2 = random.nextInt(25) + 1;
			temp3 = random.nextInt(25) + 1;
		} while (temp1 == temp2 || temp1 == temp3 || temp2 == temp3);

		positions = temp1;
		positions = positions * 100;
		positions += temp2;
		positions = positions * 100;
		positions += temp3;
		return positions;
	}
	
	/**
	 * Returns true of the thief is caught by the specified player
	 * @param playerNumber The number of the player
	 * @return True/False if the thief is caught or not
	 */
	
	public boolean thiefCaught(int playerNumber) {
		int thiefNode, player1Node,player2Node;
		thiefNode = thief.getPosition();
		player1Node = player1.getPosition();
		player2Node = player2.getPosition();
		if(playerNumber == 1) {
			if(thiefNode == player1Node) {
				return true;
			}
		}
		else if(playerNumber == 2) {
			if(thiefNode == player2Node) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Takes note of Player1’s new position and checks if the thief is caught by Player 1
	 * @param player1newPosition The position of Player 1
	 * @return If the thief is caught, 50; else -1
	 */

	public int afterplayer1(int player1newPosition) {
		player1.setPosition(player1newPosition);
		boolean caught = thiefCaught(1);
		if(caught == true) {
			return 50;
		}
		turnOver = false;
		return -1;
	}
	
	public int loadturn() {
		try {
			map.storeFromFile(mapNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.makeMatrix();
		try {
			map.readPosFile(mapNumber);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thief.thiefMove(map.getMoveLength(thief.getPosition(), player1.getPosition(), player2.getPosition()));
        turnOver = true;
		return thief.getPosition();
	}
	
	/**
	 * Makes the first move of the thief 
	 * @param lengthChoice The total number of turns that the players/thief have in the game
	 * @param difficultyChoice The difficulty level
	 * @param mapChoice The number of the map being used
	 * @return The new position of the thief to which he has moved
	 * @throws FileNotFoundException
	 */

	public int thiefTurn(String lengthChoice, String difficultyChoice, String mapChoice) throws FileNotFoundException {
		turnNumber = 1;
		if(lengthChoice.equals("10"))
			length = 1;
		else if(lengthChoice.equals("15"))
			length = 2;
		else if(lengthChoice.equals("20"))
			length = 3;
		else if(lengthChoice.equals("25"))
			length = 4;
		if(difficultyChoice.equals("Easy"))
			difficulty = 1;
		else if(difficultyChoice.equals("Normal"))
			difficulty = 2;
		else if(difficultyChoice.equals("Hard"))
			difficulty = 3;
		else if(difficultyChoice.equals("Diabolique"))
			difficulty = 4;
		if(mapChoice.equals("Map 1"))
			mapNumber = 1;
		else if(mapChoice.equals("Map 2"))
			mapNumber = 2;
		else if(mapChoice.equals("Map 3"))
			mapNumber = 3;
		else if(mapChoice.equals("Map 4"))
			mapNumber = 4;
		else if(mapChoice.equals("Map 5"))
			mapNumber = 5;
		int positions = positionChooser();
		player1 = new Player(positions % 100);
		positions /= 100;
		thief = new Thief(positions % 100);
		positions /= 100;
		player2 = new Player(positions % 100);
		try {
			map.storeFromFile(mapNumber);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.makeMatrix();
		map.readPosFile(mapNumber);
		thief.thiefMove(map.getMoveLength(thief.getPosition(), player1.getPosition(), player2.getPosition()));
        turnOver = true;
		return thief.getPosition();
	}
	
	public int getmapchoice() {
		return mapNumber;
	}
	
	/**
	 * Takes note of Player2’s new position and checks if the thief is caught by Player 2, if not, makes the subsequent move of the thief
	 * @param player2newPosition The new position of Player 2
	 * @return The 
	 */
	

	public int thiefTurn(int player2newPosition) {
		player2.setPosition(player2newPosition);
		boolean caught = thiefCaught(2);
		if(caught == true) {
			return 51;
		}
		turnNumber++;
		

		int thiefPosition = thief.thiefMove(map.getMoveLength(thief.getPosition(), player1.getPosition(), player2.getPosition()));

		if(length == 1) {
			if(turnNumber == 10) {
				return 52;
			}
		}
		else if(length == 2) {
			if(turnNumber == 15) {
				return 52;
			}
		}
		else if(length == 3) {
			if(turnNumber == 20) {
				return 52;
			}
		}
		else if (length == 4) {
			if(turnNumber == 25) {
				return 52;
			}
		}
		
		if(difficulty == 1) {
			for(int i=2;i<25;i++) {
			if(turnNumber == i) {
				turnOver = true;
				return thiefPosition;
				}
			}
		}
		else if(difficulty == 2) {
			for(int i=2;i<25;i+=2) {
				if(turnNumber == i) {
					turnOver = true;
					return thiefPosition;
				}
			}
		}
		else if(difficulty == 3) {
			for(int i=2;i<25;i+=3) {
				if(turnNumber == i) {
					turnOver = true;
					return thiefPosition;
				}
			}
		}
		else if(difficulty == 4) {
			for(int i=2;i<25;i+=4) {
				if(turnNumber == i) {
					turnOver = true;
					return thiefPosition;
				}
				}
		}
		
		return 0;
	}
	
	/**
	 * Returns all the positions occupied by the thief
	 * @return The positions occupied as an ArrayList
	 */
	
	public ArrayList<Integer> thiefallPositions() {
		return thief.getallPositions();
	}
	
	/**
	 * Returns all the positions occupied by player1
	 * @return The positions occupied as an ArrayList 
	 */
	
	public ArrayList<Integer> player1allPositions() {
		return player1.getallPositions();
	}
	
	/**
	 * Returns all the positions occupied by player2
	 * @return The positions occupied as an ArrayList 
	 */
	
	public ArrayList<Integer> player2allPositions() {
		return player2.getallPositions();
	}
	
	/**
	 * Returns all the adjacent nodes of Player 1
	 * @return The list of adjacent nodes as an ArrayList of Strings
	 */

	public ArrayList<String> getPlayer1Positions() {
		return map.getAdjacentNodes(player1.getPosition());
	}
	
	/**
	 * Returns all the adjacent nodes of Player 2
	 * @return The list of adjacent nodes as an ArrayList of Strings
	 */

	public ArrayList<String> getPlayer2Positions() {
		return map.getAdjacentNodes(player2.getPosition());
	}
	
	/**
	 * Returns all the coordinates of the adjacent nodes of Player 1
	 * @return The list of adjacent nodes as an ArrayList of Points
	 */
	
	public ArrayList<Point> getpos1List() {
		return map.getposList(player1.getPosition());
	}
	
	/**
	 * Returns all the coordinates of the adjacent nodes of Player 2
	 * @return The list of adjacent nodes as an ArrayList of Points
	 */
	
	public ArrayList<Point> getpos2List() {
		return map.getposList(player2.getPosition());
	}
	
	/**
	 * Returns the current position of Player 1
	 * @return The position of Player 1
	 */

	public int getPosition1() {
		return player1.getPosition();
	}
	
	/**
	 * Returns the current position of the thief
	 * @return The position of the thief
	 */
	
	public int thiefGetPosition() {
		return thief.getPosition();
	}
	
	/**
	 * Returns the current position of Player 2
	 * @return The position of Player 2
	 */

	public int getPosition2() {
		return player2.getPosition();
	}
	
	/**
	 * Returns the coordinates of the specified position
	 * @param position The position whose coordinates are to be returned
	 * @return The coordinates of the specified position
	 */

	public Point getpointPos(int position) {
		return map.pointPos(position);
	}
	
	/**
	 * Returns the number of completed turns
	 * @return The number of turns completed
	 */
	
	public int getTurnnumber() {
		return turnNumber;
	}
	
	/**
	 * Returns the number of the node given its coordinates
	 * @param pos The coordinates of the node whose number is to be found
	 * @return The node number at the given coordinates
	 */
	
	public int getposPoint(Point pos) {
		return map.posPoint(pos);
	}
}