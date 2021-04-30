package week3.assignment;

import java.util.ArrayList;
import java.util.List;

public class ArrangeZeroes {
	
	//move all the 0 to the right 
	//output:  4,3,1,5,2,0,0,0

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,0,3,0,1,5,2,0};
		int countOfZeroes = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<num.length;i++) {
			if(num[i] != 0) {
				list.add(num[i]);
			} else {
				countOfZeroes ++;
			}
		}
		
		for(int i=0; i<countOfZeroes; i++) {
			list.add(0);
		}
		
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
	
		
	}
}
