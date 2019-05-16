package com.techforum.theater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AcceptInputs {

	private final static int FARE = 10;
	private final static int SHOWS_INDEX = 0;
	private final static int CAPACITY_INDEX = 1;
	private final static int NUMBER_OF_FAMILIES_INDEX = 2;
	
	private static int theaterCount = 0;
	
	public static void main(String args[]) {

		File file = new File("./resources/Problem2_input.txt"); 
		
		BufferedReader br = null;
		BufferedWriter brOut = null;
		FileWriter writer;
		
		Theater theater = null;
		List<Integer> familyQueue = new LinkedList<Integer>();
		List<Theater> theaters = new ArrayList<Theater>();
		
		int count = 0;
		try {
			br = new BufferedReader(new FileReader(file));
			writer = new FileWriter("./resources/Problem2_output.txt");
			brOut = new BufferedWriter(writer);
			
			String st; 
			 if ((st = br.readLine()) != null){
				 theaterCount = Integer.parseInt(st);
			  }
			 while ((st = br.readLine()) != null){
				 //System.out.println("line-" + st);
				 if(count == 0) {
					 theater = new Theater();
					 String []theaterData = st.split(" ");
					 theater.setNumberOfShows(Integer.parseInt(theaterData[SHOWS_INDEX]));
					 theater.setCapacity(Integer.parseInt(theaterData[CAPACITY_INDEX]));
					 theater.setNumberOfFamilies(Integer.parseInt(theaterData[NUMBER_OF_FAMILIES_INDEX]));
					 count = 1;
				 }else {
					 String []familyMembers = st.split(" ");
					 for(int i=0;i<familyMembers.length;i++) {
						familyQueue.add(Integer.parseInt(familyMembers[i])); 
					 }
					 theater.setFamilyQueue(familyQueue);
					 theaters.add(theater);
					 count = 0;
				 }
			  } 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
		int shows = 0;
		int capacity = 0;
		int familyCount = 0;
		int totalIncome = 0;

		for (int i = 0; i < theaters.size(); i++) {

			theater = theaters.get(i);
			//System.out.println("Theater-"+(i+1)+" : "+ theater.toString());
			
			shows = theater.getNumberOfShows();
			familyCount = theater.getNumberOfFamilies();
			familyQueue = theater.getFamilyQueue();
			int k = 0;

			for (int j = 0; j < shows; j++) {
				capacity = theater.getCapacity();

				while (k < familyQueue.size() && familyQueue.get(k) <= capacity) {
					capacity = capacity - familyQueue.get(k);
					totalIncome = totalIncome + (FARE * familyQueue.get(k));
					k++;
				}

				if (k >= familyCount) {
					k = 0;
				}

			}
			theater.setTotalIncome(totalIncome);
			try {
				brOut.write("Theater-" + i + ": " + theater.getTotalIncome());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Theater-" + i + ": " + theater.getTotalIncome());
		}

	}

}
