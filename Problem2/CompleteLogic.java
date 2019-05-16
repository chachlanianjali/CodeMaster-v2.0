import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompleteLogic {

	
	Double getTotalAmount(int shows,int capacity,int families,int[] persons){
		//System.out.println(shows+" "+capacity+" "+families+" "+persons.length);
		String [] tempPersons2;
		Double totAmount = 0.0;
		String remaingPer = "";
		int[] tempPersons = persons;
		
		for(int i =0;i<shows;i++){
			int totalCap =0;
			
			StringBuffer sb = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			
			for(int j=0;j<tempPersons.length;j++){
				if(tempPersons[j]<=capacity && (totalCap + tempPersons[j])<= capacity){
					totalCap +=tempPersons[j];
					if(sb.toString().length()>0){
						sb.append(",");
						sb.append(String.valueOf(tempPersons[j]));
					}else{
						sb.append(String.valueOf(tempPersons[j]));
					}
				}else{
					for(int h=j;h<tempPersons.length;h++){
						sb2.append(tempPersons[h]);
						sb2.append(",");
					}
					break;
				}
				
			}
			totAmount = totAmount+totalCap*10;
			
			remaingPer = sb2.toString()+sb.toString();
			//System.out.println(remaingPer.toString());
			tempPersons2 = new String[remaingPer.split(",").length];
			tempPersons2 = remaingPer.split(",");
			for(int l=0;l<tempPersons2.length;l++){
				tempPersons[l] = Integer.parseInt(tempPersons2[l]);
			}
		}
		
		
		
		
		return totAmount;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CompleteLogic cl = new CompleteLogic();
		
		int theatres ;
		int count =1;
		int theaterCount = 1;
		String[] str ;
		
		int shows = 0,capacity =0,families =0;
		int[] persons;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("Problem2_input.txt"));
			FileWriter bw = new FileWriter("Problem2_output.txt");
			
				try {
					String st;
					while((st = br.readLine()) != null){
					//System.out.println(st.split(" "));
					if(count ==1){
						theatres = Integer.parseInt(st.toString());
					}
					else if(count%2==0){
							str = 	st.split(" ");
							shows = Integer.parseInt(str[0]);
							capacity = Integer.parseInt(str[1]);
							families = Integer.parseInt(str[2]);
					}else{
						str = 	st.split(" ");
						persons = new int[str.length];
						
						for(int l=0;l<str.length;l++){
							persons[l] = Integer.parseInt(str[l]);
						}
						System.out.println("Theater-"+theaterCount+":"+cl.getTotalAmount(shows,capacity,families,persons));
						//bw.write("Theater-"+theaterCount+":"+cl.getTotalAmount(shows,capacity,families,persons));
						theaterCount++;
					}
					
					count++;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				br.close();
				bw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
				
		

	}

}
