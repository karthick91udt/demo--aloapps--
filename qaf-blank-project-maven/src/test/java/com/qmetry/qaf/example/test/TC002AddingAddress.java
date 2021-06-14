package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.StepsLibrary.AddAddress;
import static com.qmetry.qaf.example.steps.StepsLibrary.Login;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TC002AddingAddress extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "UserDetails")
	@Test(enabled = true, priority = 2)

	public void AddAddressAfterLogin(Map<String, String> userData) throws IOException, InterruptedException {
		get("/");
		getDriver().manage().window().maximize();

		Login(userData.get("email"), userData.get("password"));

		AddAddress(userData.get("Address"), userData.get("City"), String.valueOf(userData.get("Zipcode")),
				String.valueOf(userData.get("telephone")), String.valueOf(userData.get("mobilephone")));

		Reporter.logWithScreenShot("pass");
	}

}
