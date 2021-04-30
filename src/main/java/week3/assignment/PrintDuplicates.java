package week3.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Print the duplicates using collection
 * int[] data= {1,3,8,3,11,5,6,4,7,6,7};
 * @author AdityaKRavi
 */
public class PrintDuplicates {

	public static void main(String[] args) {

		int[] data= {1,3,8,3,11,5,6,4,7,6,7};
		int[] data2= {1,1,1};
		int[] data3= {1,1,3,3,5,5,1,6,12,12};
		
		System.out.println("Test data set 1");
		printDuplicates(data);
		printDuplicatesMethod2(data);
		
		System.out.println("Test data set 2");
		printDuplicates(data2);
		printDuplicatesMethod2(data2);
		
		System.out.println("Test data set 3");
		printDuplicates(data3);
		printDuplicatesMethod2(data3);
	
	}
	
	//1st method
	private static void printDuplicates(int [] data) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		// Add integer array items to list
		for (int integer : data) {
			list.add(integer);
		}
		//check if the elements are at correct index by using indexOf(). If they are unique, the indexOf() and iterator i will be same, if not they are duplicates hence will return their first occurence in the list
		for(int i=0; i<list.size(); i++) {
			if(i != list.indexOf(list.get(i))) {
				set.add(list.get(i));
			}
		}
		
		for (Integer integer : set) {
			System.out.print(integer + " ");
		}
	}
	
	//2nd Method
	private static void printDuplicatesMethod2(int [] data) {
		System.out.print("\n Second way : ");
		List<Integer> list = new ArrayList<Integer>();
		
		Set<Integer> set = new LinkedHashSet<Integer>();
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		// Add integer array items to list
		for (int integer : data) {
			list.add(integer);
		}
		
		// Sets dont accept duplicates. if set1 is not able to add a value, it will return false and that value will be added to set2
		for (Integer integer : list) {
			if(!set.add(integer)) {
				set2.add(integer);
			}
		}
		
		for (Integer integer : set2) {
			System.out.print(integer + " ");
		}
	}
}
