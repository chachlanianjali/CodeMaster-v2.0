package com.techforum.theater;

import java.util.LinkedList;
import java.util.List;

public class Theater {
	
	private int numberOfShows;
	private int capacity;
	private int numberOfFamilies;
	private List<Integer> familyQueue = new LinkedList<Integer>();
	private int totalIncome;
	
	public int getNumberOfShows() {
		return numberOfShows;
	}
	public void setNumberOfShows(int numberOfShows) {
		this.numberOfShows = numberOfShows;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNumberOfFamilies() {
		return numberOfFamilies;
	}
	public void setNumberOfFamilies(int numberOfFamilies) {
		this.numberOfFamilies = numberOfFamilies;
	}
	public List<Integer> getFamilyQueue() {
		return familyQueue;
	}
	public void setFamilyQueue(List<Integer> familyQueue) {
		this.familyQueue = familyQueue;
	}
	public int getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(int totalIncome) {
		this.totalIncome = totalIncome;
	}
	@Override
	public String toString() {
		return "Theater [numberOfShows=" + numberOfShows + ", capacity=" + capacity + ", numberOfFamilies="
				+ numberOfFamilies + ", familyQueue=" + familyQueue + ", totalIncome=" + totalIncome + "]";
	}
}
