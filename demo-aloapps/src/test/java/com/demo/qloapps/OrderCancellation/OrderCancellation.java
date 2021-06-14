package com.demo.qloapps.OrderCancellation;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class OrderCancellation extends WebDriverTestCase {
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();

	}
	@Test(description="Contact Us")
	@QAFTestStep(description = "personnaldetails")
	public void order(String email,String psword,String newpwd,String ConfirmPwd ) throws InterruptedException
	
	 {
		
		get("/");
		getDriver().manage().window().maximize();
		//getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("signin");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		clear("Existing_email_xpath");
		clear("Existing_password_xpath");
		sendKeys(email,"EMAIL");
		sendKeys(email, "Existing_email_xpath");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String password = getBundle().getString("Pwd");
		sendKeys(password, "Existing_password_xpath");
		Thread.sleep(2000);
		click("Login_existing_xpath");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("select_dropdown");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("order");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("booking4");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("cancelbk");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("cancelchkbox");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("submitbtn");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("messagearea");
    	String msg = getBundle().getString("message");
		sendKeys(msg, "messagearea");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("finalsubmit");
		getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		click("select_dropdown");
    	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	click("Logout");
    	Thread.sleep(8000);
    	
	 }

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void AddingAddress1(Map<String, String> userData)throws IOException, InterruptedException{
		get("/");
		getDriver().manage().window().maximize();

		get("/");
		getDriver().manage().window().maximize();
		order(userData.get("email"),userData.get("password"),userData.get("Newpwd"),userData.get("ConPwd"));
	}
	
}


