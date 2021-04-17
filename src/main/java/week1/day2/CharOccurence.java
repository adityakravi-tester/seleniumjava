package week1.day2;

public class CharOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CharOccurence().getCharOccurenceCount('e',"sepeeed");
		new CharOccurence().getCharacterCount('c', "racecar");
	}
	
	private void getCharOccurenceCount(char c, String str) {
		char[] charArray = str.toCharArray();
		int count = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == c) {
				count ++;
			}
		}
		System.out.println("Character '" + c +"' occured " + count + " times in the string " + "\""+str+"\"");
	}
	
	private void getCharacterCount(char c, String str) {
		int count = 0;
		for(int i = 0; i<str.length(); i++) {
			if(str.charAt(i) == c) {
				count ++;
			}
		}
		System.out.println("Count is: " + count);
	}
}
