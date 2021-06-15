package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class ContactUs extends WebDriverTestCase {
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();
		
	}
	
    @Test
    public  void contactUsLink() throws InterruptedException {
    	
    	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click("Option");
		click("contact");
		
		new SelectBox("subject").sendKeys("Customer service");
		click("customerservice");
		Thread.sleep(2000);
	    sendKeys("sahu.archana06@gmail.com","ValEmail");
		sendKeys("Testmessage","message");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("window.scrollBy(0,400)"); 
		Thread.sleep(2000);
		click("submitMessage");
		Thread.sleep(2000);
		
		Reporter.logWithScreenShot("pass");
		
		
	}

}
