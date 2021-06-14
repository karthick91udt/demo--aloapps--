package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.verifyLinkWithPartialTextPresent;
import static com.qmetry.qaf.example.steps.StepsLibrary.Register1;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;
import static com.qmetry.qaf.example.steps.StepsLibrary.Registerfailed;
import static com.qmetry.qaf.example.steps.StepsLibrary.Tab;
import static com.qmetry.qaf.example.steps.StepsLibrary.Checkout;
import static com.qmetry.qaf.example.steps.StepsLibrary.guest;
import java.io.IOException;
import java.util.Map;
import org.testng.annotations.Test;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class SampleTest extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void Registertoaccount(Map<String, String> userData)throws IOException{
		get("/");
		getDriver().manage().window().maximize();
		Register1(userData.get("firstName"),userData.get("lastName"),userData.get("email"),userData.get("password"),userData.get("passwordConfirm"));
        System.out.println("Register successfully");
	}
	
 
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=false)
	public void Login1(Map<String, String> userData)
	{
		get("/");
		getDriver().manage().window().maximize();
		Login(userData.get("email"),userData.get("password"));

	}
	
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=true)
	public void Registerfail(Map<String, String> userData) {
		get("/");
		getDriver().manage().window().maximize();
		Registerfailed(userData.get("firstName"),userData.get("lastName"),userData.get("email"),userData.get("password"),userData.get("passwordConfirm"));
			
	}
	
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=false)
	public void Title(Map<String, String> userData)
	{
		get("/");
		getDriver().manage().window().maximize();
		Login(userData.get("email"),userData.get("password"));
		verifyLinkWithPartialTextPresent("Your Store");  
		Reporter.logWithScreenShot("pass");
	}
	
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=true)
	public void Tab1(Map<String, String> userData) throws InterruptedException
	{
		get("/");
		getDriver().manage().window().maximize();
		Tab(userData.get("email"),userData.get("password"));
		Thread.sleep(10000);

		Reporter.logWithScreenShot("pass");

		
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=true)
	public void Checkout1(Map<String, String> userData) throws InterruptedException
	{
		get("/");
		getDriver().manage().window().maximize();
		Checkout(userData.get("email"),userData.get("password"),userData.get("firstName"),userData.get("lastName"),
				userData.get("company"),userData.get("address1"),userData.get("address2"),userData.get("city"),
				userData.get("country"),userData.get("region"));
		Thread.sleep(10000);

		Reporter.logWithScreenShot("pass");

		
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=true)
	public void guestCheckout(Map<String, String> userData) throws InterruptedException
	{
		get("/");
		getDriver().manage().window().maximize();
		guest(userData.get("email"),userData.get("password"),userData.get("firstName"),userData.get("lastName"),
				userData.get("company"),userData.get("address1"),userData.get("address2"),userData.get("city"),
				userData.get("country"),userData.get("region"));
		Thread.sleep(10000);

		Reporter.logWithScreenShot("pass");

		
	}
}
