package com.demo.qloapps;

import static com.qmetry.qaf.automation.step.CommonStep.*;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;
import static com.qmetry.qaf.example.steps.StepsLibrary.Register1;
import static com.qmetry.qaf.example.steps.StepsLibrary.Registerfailed;
import static com.qmetry.qaf.example.steps.StepsLibrary.Tab;
import static com.qmetry.qaf.example.steps.StepsLibrary.Checkout;
import static com.qmetry.qaf.example.steps.StepsLibrary.guest;
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


public class RegisterAccount extends WebDriverTestCase{
	
	 @BeforeTest
	    public void openurl() {
	        get("/");
	        getDriver().manage().window().maximize();
	       
	    }
	@QAFTestStep(description = "Register")
	public void Register1(String eml,String firstname,String lastname,String pass,String passcon)
	{
		click("signin");
		sendKeys(eml,"Email");
		click("SubmitCreate_Button");
		click("Title");
		sendKeys(firstname, "FirstName");
		sendKeys(lastname,"LastName");
		sendKeys(pass,"Password");
		new SelectBox("days").sendKeys("9");
		new SelectBox("months").sendKeys("December");
		new SelectBox("years").sendKeys("1991");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollBy(0,350)");
		click("newsletter");
		click("Option");
		click("submitAccount");
		click("arrow");
		click("Logout");
		Reporter.logWithScreenShot("pass");
	}
	
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void Registertoaccount(Map<String, String> userData)throws IOException{
		get("/");
		getDriver().manage().window().maximize();
		Register1(userData.get("email"),userData.get("firstName"),userData.get("lastName"),userData.get("password"),userData.get("password"));
        System.out.println("Register successfully");
	}

	
	}
