package com.sdos;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TheaterDemo {
	public static void main(String[] args) {
		try (BufferedReader br = Files
				.newBufferedReader(Paths.get("C:\\a602289\\coding-competition\\Problem2\\input\\input.txt"))) {
			List<Theater> theaterList = new ArrayList<>();

			int numberOftheaters = Integer.parseInt(br.readLine());

			for (int theaterCounter = 0; theaterCounter < numberOftheaters; theaterCounter++) {
				String data = br.readLine();
				String theaterData[] = data.split(" ");
				Theater theater = new Theater();
				theater.setNumberOfShows(Integer.parseInt(theaterData[0]));
				theater.setSittingCapacity(Integer.parseInt(theaterData[1]));
				theater.setNumberOfFamilies(Integer.parseInt(theaterData[2]));
				theaterList.add(theater);

				String queueData[] = br.readLine().split(" ");

				for (int queueCounter = 0; queueCounter < queueData.length; queueCounter++) {
					theater.getQueue().add(Integer.parseInt(queueData[queueCounter]));
				}
			}

			calculateEarning(theaterList);
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}

	public static void calculateEarning(List<Theater> theaterList) {

		int counter = 1;
		for (Theater theater : theaterList) {
			int totalEarnings = 0;
			Queue<Integer> queue = theater.getQueue();
			for (int showCounter = 1; showCounter <= theater.getNumberOfShows(); showCounter++) {

				int totalnumberOfMemebers = 0;
				queue.add(totalnumberOfMemebers);
				int capacity = theater.getSittingCapacity();

				while (totalnumberOfMemebers < capacity) {
					int currentelement = queue.poll();
					totalnumberOfMemebers += currentelement;
					queue.add(currentelement);
				}

				totalEarnings += totalnumberOfMemebers * 10;
			}

			System.out.println("Theater-" + counter + ":" + totalEarnings);
			counter++;
		}
	}
}