/**
 * Author : Achyut Potheri Balaji
 * Purpose : Implementing the map
 */

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

	int[][] map;
	int[][] shortestDistance;
	Point[] nodePositions;
	
	/**
	 * Class default constructor
	 */

	public Map() {
		map = new int[25][25];
		shortestDistance = new int[25][25];
	}
	
	/**
	 * Calculates the distance between the adjacent nodes of the thief and the positions of the players
	 * @param thiefPosition Current position of the thief
	 * @param player1Position Current position of player 1
	 * @param player2Position Current position of player 2
	 * @return The distance between the adjacent nodes of the thief and the positions of the players as an ArrayList
	 */

	public ArrayList<Integer> getMoveLength(int thiefPosition,
			int player1Position, int player2Position) {
		ArrayList<Integer> moveLength = new ArrayList<Integer>();
		int temp;
		for (int i = 0; i < 25; i++) {
			temp = 0;
			if (map[thiefPosition - 1][i] == 1 && i + 1 != player1Position
					&& i + 1 != player2Position) {
				temp += i + 1;
				temp *= 100;
				temp += shortestDistance[i][player1Position - 1];
				temp *= 100;
				temp += shortestDistance[i][player2Position - 1];
				moveLength.add(temp);
			}
		}
		return moveLength;
	}
	
	/**
	 * Determines the adjacent nodes
	 * @param position Position whose adjacent nodes are to be found
	 * @return The determined adjacent nodes of the specified position as an ArrayList of Strings
	 */

	public ArrayList<String> getAdjacentNodes(int position) {
		ArrayList<String> adjacentNodes = new ArrayList<String>();
		String s;
		for (int i = 0; i < 25; i++) {
			if (map[position - 1][i] == 1) {
				s = new Integer(i + 1).toString();
				adjacentNodes.add(s);
			}
		}
		return adjacentNodes;
	}
	
	
	/**
	 * Determines the coordinates of the adjacent nodes
	 * @param position Position whose adjacent nodes are to be found
	 * @return The determined coordinates of the adjacent nodes of the specified position as an ArrayList of Points
	 */
	
	public ArrayList<Point> getposList(int position) {
		ArrayList<Point> posList = new ArrayList<Point>();
		Point pos;
		for (int i = 0; i < 25; i++) {
			if (map[position - 1][i] == 1) {
				pos = pointPos(i + 1);
				posList.add(pos);
			}
		}
		return posList;
	}
	
	/**
	 * Stores the map from the file into an integer matrix
	 * @param mapNumber The number of the map to be stored
	 * @throws IOException
	 */

	public void storeFromFile(int mapNumber) throws IOException {
			Scanner inStream = new Scanner(new File("./map1.txt"));
		if(mapNumber == 2) {
			inStream = new Scanner(new File("./map2.txt"));	
		}
		else if(mapNumber == 3) {
			inStream = new Scanner(new File("./map3.txt"));	
		}
		else if(mapNumber == 4) {
			inStream = new Scanner(new File("./map4.txt"));	
		}
		else if(mapNumber == 5) {
			inStream = new Scanner(new File("./map5.txt"));	
		}
		map = new int[25][25];
		int temp;
		int r = 0;
		int c = 0;
		while (inStream.hasNext() && r < 25) {
			temp = inStream.nextInt();
			if (temp == 0 && r != c) {
				map[r][c] = 30;
			} else {
				map[r][c] = temp;
			}
			if (c >= 24) {
				r++;
				c = 0;
			} else
				c++;
		}
	}
	
	/**
	 * Stores the coordinates of the nodes into an Array of Points
	 * @param mapNumber The number of the map to be stored
	 * @throws FileNotFoundException
	 */

	public void readPosFile(int mapNumber) throws FileNotFoundException{
		Scanner inStream = new Scanner(new File("./map1pos.txt"));
		if(mapNumber == 2) {
			inStream = new Scanner(new File("./map2pos.txt"));
		}
		else if(mapNumber == 3) {
			inStream = new Scanner(new File("./map3pos.txt"));
		}
		else if(mapNumber == 4) {
			inStream = new Scanner(new File("./map4pos.txt"));
		}
		else if(mapNumber == 5) {
			inStream = new Scanner(new File("./map5pos.txt"));
		}
		nodePositions = new Point[26];
		while (inStream.hasNext()) {
			int node = inStream.nextInt();
			int x = inStream.nextInt();
			int y = inStream.nextInt();
			nodePositions[node] = new Point(x, y);
		}
	}
	
	/**
	 * Creates the matrix containing shortest distance from 1 node to another (using Floyd Warshall algorithm)
	 */

	public void makeMatrix() {

		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 25; j++) {
				shortestDistance[i][j] = map[i][j];
			}
		}

		for (int k = 0; k < 25; k++) {
			for (int i = 0; i < 25; i++) {
				for (int j = 0; j < 25; j++) {
					shortestDistance[i][j] = Math.min(shortestDistance[i][j],
							(shortestDistance[i][k] + shortestDistance[k][j]));
				}
			}
		}
	}
	
	/**
	 * Returns the map
	 * @return The map in 2-D integer matrix format
	 */

	public int[][] getMap() {
		return map;
	}
	
	/**
	 * Returns the shortest distance matrix of the map
	 * @return The shortest distance matrix of the map in 2-D integer matrix format
	 */

	public int[][] getadjacent() {
		return shortestDistance;
	}
	
	/**
	 * Returns the coordinates of the specified node
	 * @return The coordinates of the node
	 * @param position The node number whose coordinates are needed
	 */

	public Point pointPos(int position) {
		return nodePositions[position];
	}
	
	/**
	 * Returns the node number whose coordinates are specified
	 * @return The node number of the specified coordinates
	 * @param pos The coordinates of the node whose number is needed
	 */
	
	public int posPoint(Point pos) {
		for(int i=0;i< 26;i++) {
			if(nodePositions[i] == pos) {
				return i;
			}
		}
		return 0;
	}

}
