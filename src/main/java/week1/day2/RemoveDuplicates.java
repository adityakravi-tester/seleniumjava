package week1.day2;

public class RemoveDuplicates {

	/*
	 * Pseudo code 

	 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 

	 * g) Displaying the String without duplicate words	
	 */

	public static void main(String[] args) {
		new RemoveDuplicates().removeDuplicates(new String("We learn java basics as part of java sessions in java week1"));
	}

	private void removeDuplicates(String text) {
		String [] eachWord = text.split(" ");
		for (int i = 0; i < eachWord.length; i++) {
			for (int j = i + 1; j < eachWord.length; j++) {
				if (eachWord[i].equals(eachWord[j])){
					eachWord[i] ="";
				} 
			}
		}
		
		String newWord = "";
		for (int i = 0; i < eachWord.length; i++) {
			newWord =newWord + " " + eachWord[i];
		}
		
		System.out.println(newWord.replaceAll("  ", " "));
	}
	
}
