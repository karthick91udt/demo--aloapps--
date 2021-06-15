package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.example.steps.StepsLibrary.Register;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class RegisterAccount extends WebDriverTestCase{
	
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(priority = 1)
	public  void Registertoaccount(Map<String, String> userData)throws IOException, InterruptedException{
		
		
		click("signin");
		Thread.sleep(2000);
		sendKeys(userData.get("Email"),"EmailAddress");
		submit("createAccountBtn");
		Register(userData.get("FirstName"),userData.get("LastName"),userData.get("password"));
		  JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("window.scrollBy(0,700)"); 
		new SelectBox("Day").sendKeys("9");
		new SelectBox("Month").sendKeys("september");
		new SelectBox("Year").sendKeys("1992");
		Thread.sleep(2000);
		click("Registerbtn");
		Thread.sleep(2000);
		Reporter.logWithScreenShot("pass");
	}


}
