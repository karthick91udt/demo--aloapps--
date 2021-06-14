package Personal.Details.Updation;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import static com.qmetry.qaf.automation.step.CommonStep.*;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.ElementInteractor.SelectBox;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

public class PersonalDetailsUpdation extends WebDriverTestCase {


	@BeforeTest
	public void openurl() {
		get("/");
		getDriver().manage().window().maximize();

	}
	@QAFTestStep(description = "personnaldetails")
	public void Personal(String email,String psword,String newpwd,String ConfirmPwd ) throws InterruptedException
	{
		

				click("signin");
				clear("Clear_Email");
				sendKeys(email,"EMAIL");
				clear("Clear_PWD");
				sendKeys(psword,"PASSWORD");
				click("Login");
				click("PersonalInfo");
//				clear("frstName");
//				sendKeys("mk","frstName");
				clear("lastname");
				sendKeys("mk","lastname");
				clear("currentPass");
				sendKeys("Test@123","currentPass");
				sendKeys(newpwd,"New_Password");
				sendKeys(ConfirmPwd,"confirmation");
				click("save");
				click("arrow");
				click("Logout");

		Reporter.logWithScreenShot("pass");
	}


	@QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	
	@Test(enabled=true)
	public  void AddingAddress1(Map<String, String> userData)throws IOException, InterruptedException{
		get("/");
		getDriver().manage().window().maximize();

		get("/");
		getDriver().manage().window().maximize();
		Personal(userData.get("email"),userData.get("password"),userData.get("Newpwd"),userData.get("ConPwd"));
	}
	
}






