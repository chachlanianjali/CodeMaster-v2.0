
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class TheaterProfitCalculator {

	public static void main(String args[]) throws FileNotFoundException {

	//	File text = new File("C:/code/CodeMaster-v2.0/Problem2/sample-input.txt");
	
		File text = new File("C:/code/CodeMaster-v2.0/Problem2/problem2-input.txt");

		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(text);
		int no_theater = 0;
		int thNumber = 1;
		if (scnr.hasNextLine()) {
			no_theater = Integer.parseInt(scnr.nextLine());
		}

		try {
			//FileWriter fw = new FileWriter("C:/code/CodeMaster-v2.0/Problem2/sample-output.txt");
			
			FileWriter fw = new FileWriter("C:/code/CodeMaster-v2.0/Problem2/problem2-output.txt");
			while (scnr.hasNextLine()) {
				String lineOfDetails = scnr.nextLine();
				String[] details = lineOfDetails.split(" ");
				int no_fShow = Integer.parseInt(details[0]);
				int capacity = Integer.parseInt(details[1]);
				int no_family = Integer.parseInt(details[2]);
				String lineOfDetailsFamily = scnr.nextLine();

				String[] lineOfDetailsFamilyArray = lineOfDetailsFamily.split(" ");
				List<Integer> family_Members = new CopyOnWriteArrayList<Integer>();
				for (int x = 0; x < lineOfDetailsFamilyArray.length; x++) {
					family_Members.add(Integer.parseInt(lineOfDetailsFamilyArray[x]));
				}

				int theater_profit = 0;
				for (int i = 0; i < no_fShow; i++) {
					int noOfpeopleEnterd = 0;
					int showProfit = 0;
					int availableSeats = capacity;
					Iterator<Integer> itr = family_Members.iterator();
					while (itr.hasNext()) {
						int memberCount = itr.next();
						if (availableSeats >= memberCount) {
							noOfpeopleEnterd = noOfpeopleEnterd + memberCount;
							availableSeats = availableSeats - memberCount;

							family_Members.remove(0);
							family_Members.add(no_family - 1, memberCount);
						} else {
							break;
						}
					}
					showProfit = 10 * noOfpeopleEnterd;
					theater_profit = theater_profit + showProfit;
				}
				System.out.println("Theater- " + thNumber + ": " + theater_profit + "\r\n");
				fw.write("Theater- " + thNumber + ": " + theater_profit + "\r\n");
				thNumber++;
			}
			fw.close();
			System.out.println("------ Done with the job----------------");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}