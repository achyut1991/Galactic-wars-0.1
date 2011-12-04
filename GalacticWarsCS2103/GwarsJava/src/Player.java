/**
 * Author : Achyut Potheri Balaji
 * Purpose : Implementing the player class
 */
import java.util.ArrayList;


public class Player {
	private int position;
	private ArrayList<Integer> allPositions;
	
	/**
	 * Class constructor specifying initial position of player
	 * @param temp The initial position of the player
	 */
	
	public Player(int temp) {
		position = temp;
		allPositions = new ArrayList<Integer>();
		allPositions.add(temp);
	}
	
	/**
	 * Returns the position of the player
	 * @return Current position of the player as int
	 */
	
	public int getPosition() {
		return position;
	}
	
	/**
	 * Returns all the positions occupied by the player
	 * @return The positions occupied as an ArrayList 
	 */
	
	public ArrayList<Integer> getallPositions() {
		return allPositions;
	}
	
	/**
	 * Sets the position of the player
	 * @param temp Position of the player
	 */
	
	public void setPosition(int temp) {
		position = temp;
		allPositions.add(temp);
	}

}

