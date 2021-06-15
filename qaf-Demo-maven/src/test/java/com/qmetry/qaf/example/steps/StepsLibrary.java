package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.*;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.step.QAFTestStep;


public class StepsLibrary {
	/**
	 * @param searchTerm
	 *            : search term to be searched
	 */ 

	@QAFTestStep(description = "Register")
	public static void Register(String frstname,String lstname,String pass)
	{
		sendKeys(frstname, "Firstname");
		sendKeys(lstname,"Lastname");
		sendKeys(pass,"Password");
	
	}
	@QAFTestStep(description = "Login")
	public static void Login(String email,String psword) throws InterruptedException
	{
		clear("RegisterEmail");
		sendKeys(email,"RegisterEmail");
		Thread.sleep(2000);
		clear("RegisterPassword");
		sendKeys(psword,"RegisterPassword");
		
		
	}
	@QAFTestStep(description = "Login")
	public static void AddressDetails(String company,String add,String city,String addressTitl) throws InterruptedException
	{
	
		sendKeys(company,"company");
		sendKeys(add,"address");
		sendKeys(city,"city");
		new SelectBox("state").sendKeys("Alabama");
		sendKeys("16003","postalcode");
		sendKeys("22020","homephone");
		sendKeys("8951673328","Mob");
		sendKeys(addressTitl,"AddTitle");
		
	
		
		
	}
	
}
