package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class RemoveItemfromCart extends WebDriverTestCase {
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	
	@Test(description="Add To Cart")
	public void addtoCart() throws InterruptedException{
		
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sendKeys("United States", "EnterhotelLoc");
        waitForVisible("SelcthotelLoc", 1000);
        click("SelcthotelLoc");
        click("SelectHotel");
        Thread.sleep(2000);
        
        click("SelecthotelPrime");
        Thread.sleep(2000);
        click("SelectCheckin");
        click("SelctDate");
        click("SelectCheckout");
        click("SelectDate");
         
        click("ClickSearchNow");
        click("ClickbookExRoom");
        Thread.sleep(5000);
        click("proceed_chkout");
        Thread.sleep(2000);
        click("ViewCart");
        click("RemoveCart");
        Thread.sleep(3000);
        Reporter.logWithScreenShot("pass");

	}
	

}
