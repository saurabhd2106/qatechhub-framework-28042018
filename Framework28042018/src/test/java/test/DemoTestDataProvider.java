package test;

import org.testng.annotations.Test;

import utils.TestDataProvider;

public class DemoTestDataProvider {
	@Test(dataProvider="getData", dataProviderClass=TestDataProvider.class)
	public void printData(String userId, String password){
		
		System.out.println("Email Id : "+ userId);
		
		System.out.println("Password : "+ password);
		
	}
	

}
