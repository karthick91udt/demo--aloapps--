package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class PersonalDetailUpdation extends WebDriverTestCase{
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="signin")	
	@Test(priority = 1)
	public  void SignAccount(Map<String, String> userData)throws IOException, InterruptedException{
		
		click("signin");
		Thread.sleep(2000);
		Login(userData.get("Email"),userData.get("Password"));
		Thread.sleep(2000);
		click("Signinbtn");
		Thread.sleep(2000);
		
	}
	@Test(priority = 2)
	public  void UpdateDetials() throws InterruptedException {
		
		click("personalInfo");
		clear("frstName");
		sendKeys("Aaarchna", "frstName");
		sendKeys("Panigrahi", "LstName");
		new SelectBox("Day").sendKeys("19");
		new SelectBox("Month").sendKeys("December");
		new SelectBox("Year").sendKeys("1992");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,700)");
		sendKeys("Test@123", "currentPass");
		Thread.sleep(2000);
		click("save");
		Thread.sleep(2000);
		
	}
	@Test(priority = 3)
	public  void LogOut() throws InterruptedException {
		
		click("Account");
		click("Logout");
		Thread.sleep(2000);
		Reporter.logWithScreenShot("pass");
	}

}
