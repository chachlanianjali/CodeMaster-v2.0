 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
 
/**
 * This program demonstrates how to read characters from a text file
 * using a BufferedReader for efficiency.
 * @author www.codejava.net
 *
 */
public class FraudStar {
 
	static long Theatercount = 0;
	static long noOfShows = 0;
	static long maxCapacity = 0;
	static long sizeOfQueue = 0;
	public static void main(String[] args) {
		try {
			/**********************File Reader*************************/
			String basePath = new File("").getAbsolutePath();
			FileReader reader = new FileReader(basePath+"\\src\\Input\\input_2.txt");  // Input File destination
			BufferedReader bufferedReader = new BufferedReader(reader);
			long noOfTheaters = 0;
			long i = 0;
			String line; // To store Line Data
			List<String> inputDataLine = new ArrayList<String>();		// Storage for Input Line
			Queue<Long> familyQueue = new LinkedList<Long>();
			
			while ((line = bufferedReader.readLine()) != null) {
				//  System.out.println(line);			// Output Per Line Data
				
				if(i == 0){
					noOfTheaters = Long.valueOf(line);
				}else{
					
					if(i%2 != 0){
						String[] array = line.split(" ");
						noOfShows = Long.parseLong(array[0]);
						maxCapacity = Long.parseLong(array[1]);
						sizeOfQueue =Long.parseLong(array[2]);

					}else{
						//create queue of elements;
						String[] array = line.split(" ");
						for (int j = 0; j < array.length; j++) {
							familyQueue.add(Long.valueOf(array[j]));
						}
						Theatercount++;
						inputDataLine.add("Theater-"+""+Theatercount+""+" : "+processor(noOfShows,maxCapacity,sizeOfQueue,familyQueue));  // write output
						familyQueue = new LinkedList<Long>();  // Flush Queue
					}
				}
				i++;
			}
			reader.close();
			/**************Send to Writer*******************/  
			outputWriter(inputDataLine);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
    
    public static void outputWriter(Object obj) throws IOException{	
    	try {
    		
    		String basePath = new File("").getAbsolutePath();
    		FileOutputStream outputStream = new FileOutputStream(basePath+"\\src\\Output\\output.txt");
    		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-16");
    		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

    		if(obj instanceof ArrayList)
    		{
    			List iterate  = (ArrayList)obj;
    			for (Iterator iterator = iterate.iterator(); iterator.hasNext();) {
					String strLine = (String) iterator.next();
					bufferedWriter.write(strLine);
            		bufferedWriter.newLine();
				}
    			
        		bufferedWriter.close();
    		}
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    
    
    /***return Income of Each Theater***/
    public static String processor(long noOfShows,long maxCapacity,long sizeOfQueue, Queue<Long> familyQueue ){

		long rupees = 0 ;
		while (noOfShows > 0) {
			long available_seat = maxCapacity;
			long familyInQueue = familyQueue.size();
			while(familyQueue.peek() <= maxCapacity &&  familyQueue.peek() <= available_seat && familyInQueue>0) {
				rupees = rupees + familyQueue.peek() * 10;
				available_seat = available_seat - familyQueue.peek();
					familyQueue.add(familyQueue.poll());
				familyInQueue --;
			}
			noOfShows --;
		} 
 
    	return ""+rupees;
    }
    
 
}