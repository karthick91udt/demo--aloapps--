package com.qmetry.qaf.example.test;

import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.example.steps.StepsLibrary.BookingHotel;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class TC003BookingHotel extends WebDriverTestCase {

	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName = "UserDetails")
	@Test(enabled = true, priority = 3)

	public void BookingHotelRoom(Map<String, String> userData) throws IOException, InterruptedException {
		get("/");
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		BookingHotel(userData.get("email"), userData.get("password"));

		Reporter.logWithScreenShot("pass");

	}

}
