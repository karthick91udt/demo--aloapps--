package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class OrderCancellation extends WebDriverTestCase{
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	

	 @QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "signin1")
     @Test(priority = 1)
	 public void signin(Map<String, String> userData) throws InterruptedException  {
		 
		 getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    click("signin");
			Thread.sleep(2000);
			Login(userData.get("Email"),userData.get("Password"));
			Thread.sleep(2000);
			click("Signinbtn");
			Thread.sleep(2000);;
	 }
	 @Test(priority = 2)
	 public void CancelOrder() throws InterruptedException {
		 
		 getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 click("OrderHistory");
		 click("Details");
		 Thread.sleep(2000);
		 Reporter.logWithScreenShot("pass");
		 JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("window.scrollBy(0,700)"); 
		 click("CancelBooking");
		 click("checkRoom");
		 Thread.sleep(2000);
		 click("CancelSubmit");
		 Thread.sleep(2000);
		 String parentHandle = getDriver().getWindowHandle();
	        for (String winHandle : getDriver().getWindowHandles()) {
	        getDriver().switchTo().window(winHandle);
	        }
		 sendKeys("Testing","CancelReason");
		 click("SubmitReason");
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
