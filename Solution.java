package com.problem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;


public class Theatre {
	public static void main(String[] args) {
		
		try {
			FileInputStream fstream = new FileInputStream("C:\\Users\\A674540\\git\\CodeMaster-v2.0\\Problem2\\Problem2_input.txt");
			BufferedReader buff = new BufferedReader(new InputStreamReader(fstream));
			String line=buff.readLine().trim();
			int theater=Integer.parseInt(line);
			System.out.println(theater);
			int theaterResult[]=new int[theater];
			for(int i=0;i<theater;i++) {
				String line1=buff.readLine();
				String line2=buff.readLine();
				int totalShow=Integer.parseInt(line1.split(" ")[0]);
				int totalCapacity=Integer.parseInt(line1.split(" ")[1]);
				int totalFamilyName=Integer.parseInt(line1.split(" ")[2]);
				int[] allData=Theatre.convert(line2);
				
				int totalCost=0;
				for(int show=0;show<totalShow;show++) {
					int rotateArray=0;
					//array rotate
					int sum=0;
					int pos=0;
					while(totalCapacity>sum+allData[pos]) {
						sum=sum+allData[pos];
						pos++;
						rotateArray++;
					}
					
					totalCost=totalCost+sum*10;
					System.out.println(totalCost);
					//rotate array
					int len=allData.length;
					int rotates[]=new int[len];
					for(int rotate=0;rotate<len;rotate++) {
						rotates[rotate]=allData[(rotate+rotateArray)%len];
					}
					allData=rotates;
				}
				theaterResult[i]=totalCost;
				System.out.println(totalCost);
			}
			for(int print=0;print<theater;print++) {
				System.out.println(theaterResult[print]);
			}
		}catch (Exception e) {
			
		}
		
	}

	static int[] convert(String x){
	    String[] val = x.split(" ");
	    int[] arr = new int[val.length];
	    for (int i = 0; i < val.length; ++i){
	         arr[i] = Integer.parseInt(val[i]);
	    }
	    return arr;
	}
	} 
 
