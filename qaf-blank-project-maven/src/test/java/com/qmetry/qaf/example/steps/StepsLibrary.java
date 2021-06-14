package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.switchToWindow;
import static com.qmetry.qaf.automation.step.CommonStep.verifyPresent;
import static com.qmetry.qaf.automation.step.CommonStep.waitForPresent;
import static com.qmetry.qaf.automation.step.CommonStep.waitForSelected;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class StepsLibrary extends WebDriverTestCase {

	@QAFTestStep(description = "Register")
	public static void Register1(String frstname, String lstname, String eml, String pass) throws InterruptedException {
		click("Signin");
		waitForPresent("CAEmail");
		sendKeys(eml, "CAEmail");
		click("CreateAbtn");
		click("Mr");
		waitForPresent("CAFirstname");
		sendKeys(frstname, "CAFirstname");
		sendKeys(lstname, "CALastname");
		sendKeys(pass, "CAPassword");
		click("CADay");
		click("CAMonth");
		click("CAYear");
		click("CARegister");
		Reporter.logWithScreenShot("pass");

	}

	@QAFTestStep(description = "Login")
	public static void Login(String email, String psword) throws InterruptedException {

		click("Signin");
		waitForPresent("Emailid");
		clear("Emailid");
		waitForPresent("Password");
		sendKeys(email, "Emailid");
		clear("Password");
		sendKeys(psword, "Password");
		click("submitsignin");

	}

	@QAFTestStep(description = "AddAddress")
	public static void AddAddress(String address, String city, String zipcode, String phone, String mobile)
			throws InterruptedException {

		Thread.sleep(2000);
		click("myaddress");

		waitForSelected("addnewaddress");
		click("addnewaddress");

		waitForPresent("AAaddress");
		sendKeys(address, "AAaddress");
		sendKeys(city, "AACity");
		sendKeys(zipcode, "AAZipcode");
		sendKeys(phone, "AAphone");
		sendKeys(mobile, "AAmobile");

		click("AAStadedd");
		click("AAState");
		click("AASavebtn");
	}

	@QAFTestStep(description = "BookingHotel")
	public static void BookingHotel(String eml, String pass) throws InterruptedException {

		click("BookHThreeLines");
		click("BookHRooms");

		click("BookHBookNow");

		Thread.sleep(2000);
		switchToWindow("1");

		verifyPresent("BookHPrice");

		click("BookHBookNow2");
		waitForPresent("BookHPTCout");
		click("BookHPTCout");

		waitForPresent("BookHProceedBtn");
		click("BookHProceedBtn");

		waitForSelected("BookHLoginnow");
		click("BookHLoginnow");

		waitForPresent("BookHEmail");
		sendKeys(eml, "BookHEmail");
		sendKeys(pass, "BookHPassword");

		waitForPresent("BookHSubmitLogin");

		click("BookHSubmitLogin");
		waitForPresent("BookHProceedBtn2");

		click("BookHProceedBtn2");

		waitForPresent("BookHAgreeCheckBox");
		click("BookHAgreeCheckBox");
		click("BookHBankwire");
		click("BookHConfirmMyOrder");

	}

	@QAFTestStep(description = "UpdateUserDetails")
	public static void UpdateUserDetails(String updfrstname, String cnfirmPaswd) throws InterruptedException {
		waitForSelected("UpdtDtlsMyPersonalInfo");
		click("UpdtDtlsMyPersonalInfo");

		clear("UpdtDtlsFirstname");
		waitForPresent("UpdtDtlsFirstname");
		sendKeys(updfrstname, "UpdtDtlsFirstname");

		sendKeys(cnfirmPaswd, "UpdtDtlsMyCrntPaswd");
		click("UpdtDtlsSavebtn");

	}

	@QAFTestStep(description = "ContactUs")
	public static void ContactUs(String eml, String msg) throws InterruptedException {

		click("qlo_threedot");
		click("qlo_contact");
		waitForSelected("Subject");
		click("Subject");
		click("qlo_customerservice");

		sendKeys(eml, "qlo_contactemail");

		sendKeys(msg, "qlo_message");
		click("qlo_sendmessage");

	}

	@QAFTestStep(description = "Cancel")
	public static void CancelOrder(String msg) throws InterruptedException {
		waitForSelected("CoOrderhstrDetls");
		click("CoOrderhstrDetls");
		waitForSelected("CoCancelBkngbtn");
		click("CoCancelBkngbtn");
		click("CoCancelsubmit");

		sendKeys(msg, "CoCancelmessage");
		click("CoCancelsubmit2");

	}

	@QAFTestStep(description = "Logout")
	public static void Logout() {
		click("Logoutarrow");
		click("Logout");

	}
}
