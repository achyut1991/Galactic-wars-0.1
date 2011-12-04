/**
 * Author : S.Subashree
 * Purpose : Implementing ATD for function getAdjacentNodes.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ATDMap {

	static ArrayList<String> AdjacentNodes = new ArrayList<String>();
	static Map test = new Map();
	static int[][] map = new int[25][25];
	
	public static void storeFromFile(int mapNo) throws IOException {
		
		
		test.storeFromFile(mapNo);
		map = test.getMap();
		PrinttoFile();
		Compare(mapNo);
	}
	
	public static void PrinttoFile() throws IOException {
		
		FileWriter fstream = new FileWriter("Maptest.txt");
        BufferedWriter outStream = new BufferedWriter(fstream);
        outStream.write("Neighbours of Nodes are as follows: \n");
    
        for(int i = 1;i<=25;i++) {
        AdjacentNodes = test.getAdjacentNodes(i);
        outStream.write("Node" + i + ": ");
        for(int j=0,c=0;j<AdjacentNodes.size();j++)
        {
        	if(c!=0)
    			outStream.write(", ");
        	outStream.write(AdjacentNodes.get(j));
        	c++;
        }
        outStream.write("\n");
        }
        
        outStream.close();
}
	
	public static void Compare(int No) throws IOException
	{
		Scanner in1 = new Scanner(new File("Maptest.txt"));
		boolean mistake = false;
		
		String actual, expected;
		Scanner in2 = new Scanner(new File("map1out.txt"));
		if(No == 2) {
			in2 = new Scanner(new File("map2out.txt"));	
		}
		else if(No == 3) {
			in2 = new Scanner(new File("map3out.txt"));	
		}
		else if(No == 4) {
			in2 = new Scanner(new File("map4out.txt"));	
		}
		else if(No == 5) {
			in2 = new Scanner(new File("map5out.txt"));	
		}
		
		while(in1.hasNext() && in2.hasNext()){
			actual = in1.nextLine();
			expected = in2.nextLine();
			
			if(actual.compareTo(expected)!=0){
			
				mistake = true;
				System.out.println("Expected output for line \n" + actual + " is " + expected);
			}
		}
		
		if(!mistake)
			System.out.println("No errors in this map.");
		
		
		
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
