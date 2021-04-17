package week1.assignment;

public class PrintDuplicates {


	/**
	 * Logic
	 * First convert the string to character array
	 * create a temp array character and an integer counter
	 * loop to the length of the original string
	 * check if the temp contains the character, if not add. Note this temp is designed to hold only distinct characters
	 * Check if the character is present in the temporary array, if not assign the character to the temp array
	 * count is set to 1 so that at each increment of the outer loop it is reset. Because the inner loop will give us the number of duplicates in one go (not to be confused with the iteration of the inner loop)
	 * compare the adjacent characters through the inner loop, if match increment count. if not continue to next iteration till the length is reached.
	 * once the inner loop is finished, check if the count is greater than 1, if yes, print the character along with the count
	 * 
	 * 
	 * 
	 */


	public static void main(String[] args) {
		String str = "seleniumjavaeight";
		int count = 1;
		char temp [] = new char[str.length()];
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {    // 1  = a 
			if (temp.length == 0 || !(PrintDuplicates.isCharacterPresent(temp, charArray[i]))) {
				temp[i] = charArray[i];
				count = 1;
				for (int j = i+1; j < charArray.length; j++) {   //3 = a
					if(charArray[i] == charArray[j]) {
						count ++;
					}
				}
				if (count > 1) {
					System.out.println("Count of character : "+ charArray[i] + " : "+count);					
				}
			} 
		}
	}

	public static boolean isCharacterPresent(char[] array , char ch) {
		boolean isPresent = false;
		for (int i = 0; i < array.length; i++) {
			if(ch == array[i]) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
}
