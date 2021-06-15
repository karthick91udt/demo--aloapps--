package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;
import static com.qmetry.qaf.example.steps.StepsLibrary.AddressDetails;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class AddAddressTest extends WebDriverTestCase{ 
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="signin1")	
	@Test(priority = 1)
	public  void SignAccount(Map<String, String> userData)throws IOException, InterruptedException{
		
		click("signin");
		Thread.sleep(2000);
		Login(userData.get("Email"),userData.get("Password"));
		Thread.sleep(2000);
		click("Signinbtn");
		Thread.sleep(2000);
		//String actTitle = getDriver().getTitle();
		assertText("LoginMsg","Welcome to your account. Here you can manage all of your personal information and orders.");
		
	}
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="AddressDet")	
	@Test(priority = 2)
	public  void AddAdderess(Map<String, String> userData)throws IOException, InterruptedException{
		
		click("AddAdress");
		AddressDetails(userData.get("Company"),userData.get("Address"),userData.get("City"),userData.get("AddressTitle"));
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,700)");
		click("savebtn");
		Thread.sleep(2000);
		Reporter.logWithScreenShot("pass");
	}

}
