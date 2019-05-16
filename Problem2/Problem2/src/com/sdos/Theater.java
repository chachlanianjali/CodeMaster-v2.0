package com.sdos;

import java.util.LinkedList;
import java.util.Queue;

public class Theater {
	
	int numberOfShows;
	int sittingCapacity;
	int numberOfFamilies;
	Queue<Integer> queue = new LinkedList<>();
	public int getNumberOfShows() {
		return numberOfShows;
	}
	public void setNumberOfShows(int numberOfShows) {
		this.numberOfShows = numberOfShows;
	}
	public int getSittingCapacity() {
		return sittingCapacity;
	}
	public void setSittingCapacity(int sittingCapacity) {
		this.sittingCapacity = sittingCapacity;
	}
	public int getNumberOfFamilies() {
		return numberOfFamilies;
	}
	public void setNumberOfFamilies(int numberOfFamilies) {
		this.numberOfFamilies = numberOfFamilies;
	}
	public Queue<Integer> getQueue() {
		return queue;
	}
	
	public void setQueue(Queue<Integer> queue) {
		this.queue = queue;
	}
	@Override
	public String toString() {
		return "Theater [numberOfShows=" + numberOfShows + ", sittingCapacity=" + sittingCapacity
				+ ", numberOfFamilies=" + numberOfFamilies + ", queue=" + queue + "]";
	}
	
	
}
