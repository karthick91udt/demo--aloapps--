package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.StepsLibrary.Logout;
import static com.qmetry.qaf.example.steps.StepsLibrary.Register1;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

public class TC001Register extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "UserDetails")
	@Test(enabled = true, priority = 1)
	public void Registertoaccount(Map<String, String> userData) throws IOException, InterruptedException {
		get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Register1(userData.get("firstName"), userData.get("lastName"), userData.get("email"), userData.get("password"));
		System.out.println("Register successfully");

		Logout();
	}

}
