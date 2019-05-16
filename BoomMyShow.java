import java.util.Scanner;
import java.util.Iterator;
// Java orogram to demonstrate working of Queue 
// interface in Java 
import java.util.LinkedList; 
import java.util.Queue;
public class BoomMyShow {

	
        int noOfTheatre;
		int noOfShows;
		int capacityOfShows;
		int noOfFamily;
		int membersOfFamily;
					
			
		
			public static void main(String args[]) throws Exception
			   {
			     			      
			        int noOfTheatre;
					int noOfShows;
					int capacityOfShows;
					int noOfFamily;
					int membersOfFamily;
			     
			      Scanner in = new Scanner(System.in);
			     
			      System.out.println("Enter an noOfTheatres");
			      noOfTheatre = in.nextInt();
			    			      
			      
			      System.out.println("Enter a noOfShows");
			      noOfShows = in.nextInt();
			      
			   
			      System.out.println("Enter a capacityOfShows");
			      capacityOfShows = in.nextInt();
			          
			      System.out.println("Enter a NumbersOfFamily");
			      noOfFamily = in.nextInt();
			      
			   
			    //  System.out.println("Enter a membersOfFamily");
			     // membersOfFamily = in.nextInt();
			    
			  	Queue<Integer> q = new LinkedList<>(); 


			   for(noOfTheatre=1;noOfTheatre<4;noOfTheatre++)
			   {
				   int total=0;
				  for(noOfShows=0;noOfShows<10;noOfShows++){
					  if(noOfFamily>0){
//
						  Scanner scan;
							Queue<Integer> queue;
							
						   scan = new Scanner(System.in);
							queue = new LinkedList<Integer>();
							
										
							System.out.println("\nEnter numbers OfFamily' value :");
							membersOfFamily = scan.nextInt();
							
							System.out.println("Enter the size of each family");
							
							for(int i=0; i<membersOfFamily; i++) {
								
								q.add(scan.nextInt());
							}		
						}
						   	// Adds elements {0, 1, 2, 3, 4} to queue 
						   	for (int i=0; i<noOfFamily; i++) 
						   	q.add(i); 
						   	int sum=0;
						   	Iterator<Integer> it=q.iterator();
						   	if(capacityOfShows==q.peek()){
						   		 total=q.peek()*10;
						   		 q.remove();
						  noOfShows++;
					  }else
						  {
						  while(sum<=capacityOfShows)
						  while(it.hasNext()){
							   sum = q.peek()+it.next();
					            
					            total= sum*10;
						  int que=it.next();
					  }
						  }
						   	System.out.println("Theater-"+noOfTheatre+":"+total);
						   	
						   	
						  		   
				   
			   }
			      			    	  
			   }	
			   }
			   
			
 
			   
			   	

			   } 
			   

			      
			   











