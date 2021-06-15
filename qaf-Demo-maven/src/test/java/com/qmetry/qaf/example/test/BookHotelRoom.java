package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class BookHotelRoom extends WebDriverTestCase{
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	

	    @QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "signin1")
		@Test(priority = 1)
	    public void BookRoom(Map<String, String> userData) throws InterruptedException  {
	        
	    	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	click("Option");
			Thread.sleep(2000);
			click("Rooms");
			click("closewndow");
			click("BookExRoom");
	        Thread.sleep(3000);
	        String parentHandle = getDriver().getWindowHandle();
	        for (String winHandle : getDriver().getWindowHandles()) {
	        getDriver().switchTo().window(winHandle);
	        }
	        click("Roomcheckin");
	        Thread.sleep(2000);
	        click("checkinDate");
	        Thread.sleep(2000);
	        JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("window.scrollBy(0,700)"); 
			assertText("BookPrice","$2,000.00");
	        click("BookBtn");
	        click("checkout");
	        click("proceed");
	        click("LoginNow");
	        
	        sendKeys(userData.get("Email"), "GuestEmail");
	        sendKeys(userData.get("Password"), "GuestPwd");
	        click("GuestSignin");
	     
	        click("Userproceed");
	        click("PaymentCheckbox");
	        Thread.sleep(3000);
	        click("PaymentOption");
	        click("ConfirmOrder");
	        Thread.sleep(4000);
            Reporter.logWithScreenShot("pass");

	    }

}
