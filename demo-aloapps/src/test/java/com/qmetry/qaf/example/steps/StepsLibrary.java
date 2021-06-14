package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class StepsLibrary extends WebDriverTestCase {
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */ 
	  @BeforeTest
	    public void openurl() {
	        get("/");
	        getDriver().manage().window().maximize();
	       
	    }
	@QAFTestStep(description = "Register")
	public static void Register1(String frstname,String lstname,String eml,String pass,String passcon)
		{
		click("myaccount");
		click("Register");
		sendKeys(frstname, "Firstname");
		sendKeys(lstname,"Lastname");
		sendKeys(eml,"Email");
		sendKeys("9994309603","Telephone");
		sendKeys(pass,"Password");
		sendKeys(passcon,"PasswordConfirm");
		click("NewsLetter");
		click("agree");
		click("submit");
		Reporter.logWithScreenShot("pass");
	}
	@QAFTestStep(description = "Login")
	public static void Login(String email,String psword)
	{
		click("myaccount");
		click("Login");
		sendKeys(email,"Emailid");
		sendKeys(psword,"Password1");
		click("submit1");
		System.out.println("Login Successfully");
		
	}
	@QAFTestStep(description = "Register fail")
	public static void Registerfailed(String frstname,String lstname,String eml,String pass,String passcon) {
		click("myaccount");
		click("Register");
		sendKeys(frstname, "Firstname");
		sendKeys(lstname,"Lastname");
		sendKeys(eml,"Email");
		sendKeys(pass,"Password");
		sendKeys(passcon,"PasswordConfirm");
		click("NewsLetter");
		click("agree");
		click("submit");
		Reporter.logWithScreenShot("pass");

	}
	@QAFTestStep(description = "Tab")
	public static void Tab(String email,String psword)
	{
		click("myaccount");
		click("Login");
		sendKeys(email,"Emailid");
		sendKeys(psword,"Password1");
		click("submit1");
		System.out.println("Login Successfully");	
		click("Desktop");
		click("showall");
		click("Laptop");
		click("Addtocart");
		System.out.println("AddToCart successfully");
		
	}
	
	@QAFTestStep(description = "Checkout")
	public static void Checkout(String email,String psword,String frstname,String lstname,String company,
			String Address1,String Address2,String city,String country, String Region)
	{
		click("myaccount");
		click("Login");
		sendKeys(email,"Emailid");
		sendKeys(psword,"Password1");
		click("submit1");
		System.out.println("Login Successfully");	
		click("laptop_notebook_xpath");
		click("showall_lap_note_xpath");
		click("HpLp3065_xpath");
		click("delivery_date_xpath");
		click("add_to_cart_xpath");
		click("ClickCart");
		click("viewCart");
		click("checkout");
		click("click_continue_xpath");
		click("continuebilling");
		click("cmmtbox");
		click("continuepdeliverymethod");
		click("cmtpaymentmethod");
		click("termsagree");
		click("continuepayment");
		click("confirmorder");
	}
	
	@QAFTestStep(description = "guestCheckout")
	public static void guest(String email,String psword,String frstname,String lstname,String company,
			String Address1,String Address2,String city,String country, String Region)
	{
		
		click("laptop_notebook_xpath");
		click("showall_lap_note_xpath");
		click("HpLp3065_xpath");
		click("delivery_date_xpath");
		click("add_to_cart_xpath");
		click("ClickCart");
		click("viewCart");
		click("checkout");
		click("Guest_Account");
		sendKeys(frstname,"fstName");
		sendKeys(lstname,"lstName");
		sendKeys( company,"company");
		sendKeys( Address1,"address1");
		sendKeys(Address2 ,"address2");
		sendKeys( city,"city");
		sendKeys( "75001","postcode");
		sendKeys( country,"country");
		sendKeys( Region,"Region");
		click("Guest_Continue");
		click("cmmtbox");
		click("continuepdeliverymethod");
		click("cmtpaymentmethod");
		click("termsagree");
		click("continuepayment");
		click("confirmorder");
	}
}
