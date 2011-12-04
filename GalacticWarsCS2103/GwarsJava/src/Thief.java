/**
 * Author : Achyut Potheri Balaji, Sesha Sendhil Subramanian
 * Purpose : Implementing the thief class and the AI
 */
import java.util.*;

public class Thief {
		
	private int position;
	private ArrayList<Integer> allPositions; 
	
	/**
	 * Class constructor specifying initial position of thief
	 * @param temp The initial position of the thief
	 */

	public Thief(int temp) {
		position = temp;
		allPositions = new ArrayList<Integer>();
		allPositions.add(temp);
	}
		
	/**
	 * Returns the position of the thief
	 * @return Current position of the thief as int
	 */
	
	public int getPosition() {
		return position;
	}
	
	/**
	 * Sets the position of the thief
	 * @param temp Position of the thief
	 */
		
	public void setPosition(int temp) {
		position = temp;
	}
	
	/**
	 * Returns all the positions occupied by the thief
	 * @return The positions occupied as an ArrayList
	 */
	
	public ArrayList<Integer> getallPositions() {
		return allPositions;
	}
	
	/**
	 * Calculates the next position to which the thief should move
	 * @param availableMoves An arrayList of adjacent nodes
	 * @return The node to which the thief should move next
	 */
		
	public int thiefMove(ArrayList<Integer> availableMoves) {
		
		if(availableMoves.size() == 0) {
			allPositions.add(position);
			return position;
		}
		
		ArrayList<Integer> adjacentNode = new ArrayList<Integer>();
		ArrayList<Integer> shorterDistance = new ArrayList<Integer>();
		ArrayList<Integer> longerDistance = new ArrayList<Integer>();
		int distanceFrom1;
		int distanceFrom2;
		int greatest;
		int largest;
		
		//Loop which breaks the arriving ArrayList into three parts and stores it into three separate arraylists
		
		for(int i =0;i<availableMoves.size();i++) {
			int temp = availableMoves.get(i);
			distanceFrom1 = temp%100;
			temp/=100;
			distanceFrom2 = temp%100;
			temp/=100;
			adjacentNode.add(temp%100);
			if(distanceFrom1<distanceFrom2) {
				shorterDistance.add(distanceFrom1);
				longerDistance.add(distanceFrom2);
			}
			else {
				shorterDistance.add(distanceFrom2);
				longerDistance.add(distanceFrom1);
			}
		}
		
		//Loop which finds the largest value of the shorter distance
		
		greatest = shorterDistance.get(0);
		for (int i=1; i<adjacentNode.size(); i++) {
			if(greatest<shorterDistance.get(i)) {
				greatest = shorterDistance.get(i);
			}
		}
		
		//Loop which restrict the ArrayList to only those values containing the largest value of the shorter distance
		
		for(int i=adjacentNode.size()-1;i>=0;i--) {
			if(shorterDistance.get(i) < greatest) {
				shorterDistance.remove(i);
				longerDistance.remove(i);
				adjacentNode.remove(i);
			}
		}
		
		//Return statement if largest value of shorter distance is 1
		Random random = new Random();
		if(greatest == 1) {
			position = adjacentNode.get(random.nextInt(adjacentNode.size()));
			allPositions.add(position);
			return adjacentNode.get(random.nextInt(adjacentNode.size()));
		}
		
		//Loop to find the largest of the longerDistance
		
		largest = longerDistance.get(0);
		for (int i=1; i<adjacentNode.size(); i++) {
			if(largest<longerDistance.get(i)) {
				largest = longerDistance.get(i);
			}
		}
		
		//Loop which restricts the ArrayList to only those values containing the largest of the longerDistance
		
		for(int i=adjacentNode.size()-1;i>=0;i--) {
			if(longerDistance.get(i) < largest) {
				shorterDistance.remove(i);
				longerDistance.remove(i);
				adjacentNode.remove(i);
			}
		}
		
		//Return statement 
		position = adjacentNode.get(random.nextInt(adjacentNode.size()));
		allPositions.add(position);
		return adjacentNode.get(random.nextInt(adjacentNode.size()));
		
	}

}



