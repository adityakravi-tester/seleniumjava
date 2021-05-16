package exercise.daily;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParallelDataProvider {

	
	@Test(dataProvider = "sendData")
	public void testGreetings(String greetings) {
		
		System.out.println("Greetings 1 : " + greetings);
		
	}
	
	@Test(dataProvider = "sendData")
	public void testGreetings2(String greetings) {
		
		System.out.println("Greetings 2 : " + greetings);
		
	}

	@DataProvider(parallel = true)
	public String[][] sendData(){
		return new String[][] {
			{"Hello"},
			{"Good Morning"},
			{"Good Afternoon"},
			{"Good Evening"},
			{"Bonjour"},
			{"Ciao"},
			{"Hola"},
			
		};
	}
}
