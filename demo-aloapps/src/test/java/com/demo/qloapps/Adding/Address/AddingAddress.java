package com.demo.qloapps.Adding.Address;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class AddingAddress extends WebDriverTestCase {
	

	 @BeforeTest
	    public void openurl() {
	        get("/");
	        getDriver().manage().window().maximize();
	       
	    }
	@QAFTestStep(description = "Address")
	public void ADDadr(String email,String psword,String company,
			String Address1,String Address2,String city)
	{
		click("signin");
		clear("Clear_Email");
		sendKeys(email,"EMAIL");
		clear("Clear_PWD");
		sendKeys(psword,"PASSWORD");
		click("Login");
		click("AddFirstAddr");
		sendKeys(company, "Company");
		sendKeys(Address1,"Address1");
		sendKeys(Address2,"Address2");
		sendKeys(city,"City");
		new SelectBox("State").sendKeys("Texas");
		sendKeys("75001","postcode");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
	    js.executeScript("window.scrollBy(0,450)");
		sendKeys("1236549878","phonenumber");
		sendKeys("9994309603","mobile");
		sendKeys("Good","ADD_INFO");
		click("submitAddress");
		click("arrow");
		click("Logout");
		Reporter.logWithScreenShot("pass");
	}
	
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void AddingAddress1(Map<String, String> userData)throws IOException{
		get("/");
		getDriver().manage().window().maximize();
		ADDadr(userData.get("email"),userData.get("password"),userData.get("company"),userData.get("address1"),
				userData.get("address2"),userData.get("city"));
       System.out.println("Login successfully");
       Reporter.logWithScreenShot("pass");
	}

	

}
