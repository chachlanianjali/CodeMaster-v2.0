package Problem2;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static int theatercount;
	static int shows;
	static String capacity;
	static int familyCount;
	static int sum;
	static int amount;
	static int showamount ;
	static int Theateramount;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  File file = new File("C:\\Users\\A704168\\Desktop\\CM2-TeamInevitable\\CodeMaster-v2.0\\Problem2\\input.txt"); 
		   try {
			  
			  BufferedReader reader = new BufferedReader(new FileReader(
						file));
				String line = reader.readLine();
				while (line != null) {
					
					String[] a = line.split(" ");
					for(int i=0;i<a.length;i++) {
						if(a.length == 1) {
							theatercount = Integer.parseInt(a[i]); 
							System.out.println("theatercount"+theatercount);
						break;
							
						}else if(a.length == 3) {
							shows = Integer.parseInt(a[0]);
							capacity = a[1];
							familyCount = Integer.parseInt(a[2]);
							break;
						}else {
							for(int j=0;j<shows;j++) {
								if(familyCount == a.length) {
									//Queue<Object> queue = new LinkedList<>(Arrays.asList(a));
									Queue<Object> queue = 
									          new Collections.synchronizedList( Arrays.asList(a)); 
							
							
									for(Object item : queue){
										
										String value = item.toString();
										if(Integer.parseInt(value)< Integer.parseInt(capacity)) {
											  sum+=(Integer.parseInt(a[j]));
											  if(sum <(Integer.parseInt(capacity))) {
												  queue.remove();
												  queue.add(item);
												  amount += 10*sum;
												   }else {
											  sum-=((Integer)item); 
											 break;
											  }
											  }
									   
									}
								}
								
								
								shows--;
								showamount = amount;
								
								}
							Theateramount += showamount;
							System.out.println("Theater-"+a[i]+":"+showamount);
							theatercount--;
							
						}
						
			
						
					}
					if(theatercount == 0) {
						break;
					}
					
			
				
					
					line = reader.readLine();
				}
				
				reader.close();
			
				}catch (IOException e) {
				e.printStackTrace();
			}
	}

}
