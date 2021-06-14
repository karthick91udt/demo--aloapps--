package com.demo.qloapps.steps;
import static com.qmetry.qaf.automation.step.CommonStep.*;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class StepsLibrary extends WebDriverTestCase {
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */ 
	
	@QAFTestStep(description = "Register")
	public static void Register1(String eml,String firstname,String lastname,String pass,String passcon)
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
		click("newsletter");
		click("Option");
		click("submitAccount");
		Reporter.logWithScreenShot("pass");
	}
}