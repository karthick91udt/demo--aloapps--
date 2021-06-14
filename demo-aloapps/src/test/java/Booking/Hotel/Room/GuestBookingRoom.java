package Booking.Hotel.Room;

import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;
import static com.qmetry.qaf.example.steps.StepsLibrary.guest;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class GuestBookingRoom extends WebDriverTestCase {
	@Test
	@QAFTestStep(description = "guestCheckout")
	public void guest(String email,String psword,String firstname,String lastname) throws InterruptedException
	{		

	get("/");
	getDriver().manage().window().maximize();
	
	//Navigating to Executive Rooms
	click("menu");
	waitForVisible("rooms", 5);
	click("rooms");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,120)");
	Thread.sleep(1000);
	click("exeroom");
	for(String winHandle : getDriver().getWindowHandles()){
	    getDriver().switchTo().window(winHandle);
	}
	
	// Booking Hotel Room
	waitForVisible("checkInDate", 5);
	click("checkInDate");
	getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	click("mnthPick");
	getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	click("datePick");
	getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	waitForVisible("bookNow", 10);
	click("bookNow");
	waitForVisible("proceedChkout", 10);
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	click("proceedChkout");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	click("proceed");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	// SignIn
	click("loginNow");
	clear("Clear_Email");
	sendKeys(email,"EMAIL");
	clear("Clear_PWD");
	sendKeys(psword,"PASSWORD");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	click("loginSubmit");

	// Room Checkout and payment
	waitForVisible("prodProceed", 5);
	click("prodProceed");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	click("agree");
	getDriver().manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	click("payWire");
	waitForVisible("confrmBtn", 5);
	click("confrmBtn");
	Reporter.logWithScreenShot("BookingHotelRoom");
	}
	
	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
	@Test(enabled=true)
	public void guestCheckout(Map<String, String> userData) throws InterruptedException
	{
		get("/");
		getDriver().manage().window().maximize();
		guest(userData.get("email"),userData.get("password"),userData.get("firstName"),userData.get("lastName"));
				
		Thread.sleep(10000);

		Reporter.logWithScreenShot("pass");

		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	{
//		
//		click("Menu");
//		click("ROOMS");
//		JavascriptExecutor js = (JavascriptExecutor)getDriver();
//	    js.executeScript("window.scrollBy(0,450)");
//		click("Book_Now");
//		for(String winHandle : getDriver().getWindowHandles()){
//		    getDriver().switchTo().window(winHandle);
//		}
//		
//		// Booking Hotel Room
//		waitForVisible("checkInDate", 5);
//		click("book");
//		click("Proceed_To_Checkout");
//		click("Proceed");
//		sendKeys(firstname,"customer_firstname");
//		sendKeys(lastname,"customer_lastname");
//		sendKeys(email,"EMAIL_ID");
//		sendKeys(psword,"PASSWORD1");
//		sendKeys("9994309603","phone_mobile");
//		click("submitAccount");
//		click("final_Proceed");
//		click("Payment_Information");
//		click("Pay_by_BankWire");
//		click("I_Confirm_My_Order");
//		Reporter.logWithScreenShot("pass");
//		click("Karthick");
//		click("Logout");
//		
//	}
//
//	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")
//	@Test(enabled=true)
//	public void guestCheckout(Map<String, String> userData) throws InterruptedException
//	{
//		get("/");
//		getDriver().manage().window().maximize();
//		guest(userData.get("email"),userData.get("password"),userData.get("firstName"),userData.get("lastName"));
//				
//		Thread.sleep(10000);
//
//		Reporter.logWithScreenShot("pass");
//
//		
//	}
//	

