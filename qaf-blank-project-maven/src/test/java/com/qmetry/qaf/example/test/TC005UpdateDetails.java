package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;
import static com.qmetry.qaf.example.steps.StepsLibrary.UpdateUserDetails;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TC005UpdateDetails extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "UserDetails")
	@Test(enabled = true, priority = 5)

	public void UpdateDetails(Map<String, String> userData) throws IOException, InterruptedException {
		get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Login(userData.get("email"), userData.get("password"));

		UpdateUserDetails(userData.get("UpdtfirstName"), userData.get("password"));
		Reporter.logWithScreenShot("pass");

	}

}
