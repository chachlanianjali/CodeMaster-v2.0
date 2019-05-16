import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Problem2 {


	public static void main(String[] args) throws IOException {
		new Problem2().calculate();
	}

	List<Integer> familyList = new LinkedList();
	
	public String calculate (){

		//tested for first sample data
		int capacityOfT= 5;
		int noShows= 5;
		//family mem as 10
		familyList.add(2);
		familyList.add(4);
		familyList.add(2);
		familyList.add(3);
		familyList.add(4);
		familyList.add(2);
		familyList.add(1);
		familyList.add(2);
		familyList.add(1);
		familyList.add(3);

		
		int totalAmount =0;
		             
		for(int i=1;i<=noShows;i++){
			int amount =  calculateBusiness(i,familyList,capacityOfT);

			System.out.println("After show "+ i +" "+amount);
			totalAmount = totalAmount +amount;
		}
		System.out.println(" Total Collected for show "+totalAmount);

		return null;
	}



	private int calculateBusiness(int numberOFIteration, List<Integer> familyList, int capacityOfT) {

		int capacityCounter= capacityOfT;
		int business=0;
		
		List<Integer> targetFamilyList =new LinkedList(familyList);

		for (int i=0;i<familyList.size();i++) {

			Integer memberNumber = familyList.get(i);

			if(memberNumber<=capacityCounter){

				business = business + (10 * memberNumber);
				capacityCounter = capacityCounter - memberNumber;

			}
			else
			{

				break;
			}

			targetFamilyList.add(memberNumber);
			targetFamilyList.remove(new Integer(memberNumber));
		}
		System.out.println("f"+familyList);
		System.out.println(" t"+targetFamilyList);
		this.familyList = targetFamilyList;
		return business;
	}











}
