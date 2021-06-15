package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.StepsLibrary.ContactUs;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TC006Contact extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "UserDetails")
	@Test(enabled = true, priority = 6)

	public void Contactuss(Map<String, String> userData) throws IOException, InterruptedException {
		get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		ContactUs(userData.get("email"), userData.get("Message"));
		Reporter.logWithScreenShot("pass");

	}

}
