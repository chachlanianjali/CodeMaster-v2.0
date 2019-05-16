package awl.coding.competition;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class Theater {
	static double shows = 0;
	static double capacity = 0;
	static int theatre_no = 0;
	static double theater_collection = 0;

	public static void main(String[] args) {
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get("C:\\CC\\Problem2_input.txt"), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int line_count = 2;
		Iterator<String> itr = lines.iterator();
		while (itr.hasNext()) {
			double no_of_theater = Double.parseDouble(itr.next().trim());
			System.out.println("No.of Theaters" + no_of_theater);
			break;
		}
		lines.remove(0);
		List<Integer> line2 = new ArrayList<Integer>();
		Iterator<String> itr_new = lines.iterator();
		int total = 0;
		while (itr_new.hasNext()) {
			theatre_no = 0;
			if (line_count % 2 == 0) {
				String line1 = itr_new.next().trim();
				shows = Double.parseDouble(line1.substring(0));
				capacity = Double.parseDouble(line1.substring(1));
				line_count++;
			} else {
				for (int i = 0; i <= shows; i++) {
					line2.add(Integer.parseInt(itr_new.next()));
					for (int k = 0; k <= line2.size(); k++) {
						int value = line2.get(k);
						line2.remove(k);
						while (capacity > total) {
							total += value;
							line2.add(value);
							break;
						}
					}
				}
				theater_collection = total * 10;
			}
			theatre_no++;
		}
		System.out.println("Theater No" + theatre_no + "Collection is - " + theater_collection);
	}
}