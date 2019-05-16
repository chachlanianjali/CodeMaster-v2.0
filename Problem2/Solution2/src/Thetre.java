import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Thetre {
	public static void main(String Arg[]) throws IOException{
		  File file = new File("C:\\Users\\A704234\\POJO\\Solution2\\src\\input.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  int T = 0;
		  String st;
		String[] in; 
		  while((st = br.readLine()) != null){
			  
			  T = Integer.parseInt(st);
			  
			  int S[] = new int[3];
			  int P[] = new int[3];;
			  int FC[] = new int[3];;
			  int FCN[][] = new int[T][10];;
			  
			  for(int i=0,j=0;i<T && j< 3; j++,i++){
					  in = br.readLine().split(" ");
					  S[i] = Integer.parseInt(in[0]);
					  P[i] = Integer.parseInt(in[1]);
					  FC[i] = Integer.parseInt(in[2]);
					  in = br.readLine().split(" ");
					  for(int k = 0; k < FC[i] ; k++){
						  FCN[i][k] = Integer.parseInt(in[k]);
					  }					  
			  
		}
		int sum[]=new int[T];
		for(int i=0;i<T;i++){
			for(int j = 0; j<S[i]; j++){
				for(int k=0; k<P[i]; k++){
					int p=0;
					int f = FCN[i][k];
					while(f <= P[k]){
						p=f;
						f=f+FCN[i][j];
					}
					sum[i] = sum[i] +p*10;
				}
/*				sum = S[i];
				for(int j=0;j<FC[i];j++){
					int p = 0;
					int s;
					int f = FC[j]; 
					while(f <= P[i]){
						p=f;
						f=f+FC[j];
					}
					sum = sum + p*10;
					
				}*/
			}	
		}
	 }		
}}

/*Sample Input

3
5 5 10
2 4 2 3 4 2 1 2 1 3
1 10 9
1 1 1 1 1 1 1 1 1
100 10 1
1


Sample Output

Theater-1: 200
Theater-2: 90
Theater-3: 1000
*/