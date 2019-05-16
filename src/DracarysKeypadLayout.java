import java.io.File;
import java.util.*;

class DracarysKeypadLayout {
	public static void main(String args[]) throws Exception {

		File file = new File("/Users/A610368/git/CodeMaster-v2.0/src/Problem1_input.txt");
		Scanner s = new Scanner(file);
		
		System.out.println("file found...");

		while(s.hasNext()) {
//		    String nextToken = s.next();
//		    //or to process line by line
//		    String nextLine = s.nextLine();
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}
		// sort the array
		Arrays.sort(arr);

		// take the total no. of keys
		int k = s.nextInt();
		int[] key = new int[k];
		int temp = 0;
		for (int i = 0; i < k; i++) {
			key[i] = s.nextInt();
			temp += key[i];
		}
		// check
		if (temp < n)
			System.out.println("-1");
		// maintain the no. of presses to be minimum
		else {
			int l = key.length;
			int[] res = new int[temp];
			int j = 0;
			// fill the array
			for (int i = 0; i < l; i++) {
				int x = key[i];
				// x array items bharo
				while (j < temp && x > 0) {
					res[j] = x;
					j++;
					x--;
				}
			}
			// now sort the res array
			Arrays.sort(res);
			// calculate the total presses now
			int sum = 0;
			int m = 0;
			for (int i = n - 1; i >= 0; i--) {
				sum += arr[i] * res[m];
				m++;
			}

			System.out.println(sum);
		}
	}
}
}
