/**
 * Author : S.Subashree
 * Purpose : Implementing the ATD to check Floyd Warshall Algorithm
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ATDAlgorithm {

	static int [][] shortestDistance;
	
	public static void storeFromFile(int mapNo) throws IOException {
		
		Map test = new Map();
		
		test.storeFromFile(mapNo);
		test.makeMatrix();
		shortestDistance = test.getadjacent();
		writeToFile();
		Compare(mapNo);
		}
		


	public static void writeToFile() throws IOException{
		FileWriter fstream = new FileWriter("Maptest.txt");
        BufferedWriter outStream = new BufferedWriter(fstream);
        
        String temp = " ";
		for(int i = 0;i<25;i++){
        	for(int j = 0;j<25;j++)
        	{
        		outStream.write(shortestDistance[i][j]+temp);
        	}
        	
        	String t = "\n";
        	outStream.write(t);
		}
		
	}
	public static void Compare(int MapNumber) throws IOException{
		
		Scanner in1 = new Scanner(new File("Maptest.txt"));
		
		boolean mistake = false;
		
		String actual, expected;
		Scanner in2 = new Scanner(new File("map1Algout.txt"));
		if(MapNumber == 2) {
			in2 = new Scanner(new File("map2Algout.txt"));	
		}
		else if(MapNumber == 3) {
			in2 = new Scanner(new File("map3Algout.txt"));	
		}
		else if(MapNumber == 4) {
			in2 = new Scanner(new File("map4Algout.txt"));	
		}
		else if(MapNumber == 5) {
			in2 = new Scanner(new File("map5Algout.txt"));	
		}
        
		while(in1.hasNext() && in2.hasNext()){
			actual = in1.nextLine();
			expected = in2.nextLine();
			
			if(actual.compareTo(expected)!=0){
			
				mistake = true;
				System.out.println("Floyd Warshall Algorithm incorrectly implemented.");
			}
		}
			
			if(!mistake)
				System.out.println("Correct implementation of Floyd Warshall Algorithm.");
		
	}
	
	public static void main(String[] args) throws IOException {
		
		/* To check each map you select which map to test.
		 * */
		for(int i=1;i<=5;i++){
			System.out.println("For Map"+i);
			storeFromFile(i);
		}
		 
	}
}