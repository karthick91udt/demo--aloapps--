package com.demo.qloapps.Remove_From_Cart;
import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class RemoveFromCart extends WebDriverTestCase {
	
	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();

	}
	@Test(description="Contact Us")
	@QAFTestStep(description = "personnaldetails")
	public void remove(String email,String psword,String newpwd,String ConfirmPwd ) throws InterruptedException
	
	 {	
		get("/");
        getDriver().manage().window().maximize();
        sendKeys("United States", "enterhotelloc");
        waitForVisible("selcthotelloc", 1000);
        click("selcthotelloc");
        click("selecthotel");
        Thread.sleep(2000);
        
        click("selecthotelprime");
        Thread.sleep(2000);
        click("selectcheckin");
        click("selctdatein");
        click("selectcheckout");
        click("selctdateout");
         
        click("clickSearchnow");
        click("clickbooknow1");
        Thread.sleep(5000);
        click("proceed_chkout");
        Thread.sleep(2000);
        click("viewcart");
        click("removecart");
        Thread.sleep(3000);

	}
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void AddingAddress1(Map<String, String> userData)throws IOException, InterruptedException{
		get("/");
		getDriver().manage().window().maximize();

		get("/");
		getDriver().manage().window().maximize();
		remove(userData.get("email"),userData.get("password"),userData.get("Newpwd"),userData.get("ConPwd"));
	}
}
