package Contact_Us;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
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
public class Contactus extends WebDriverTestCase {
		 @BeforeTest
	    public void openurl() {
	        get("/");
	        getDriver().manage().window().maximize();
	       	    }
	 public class TC006_ContactUs extends WebDriverTestCase {
		   
	      @BeforeTest
	      public void openurl() {
	          get("/");
	          getDriver().manage().window().maximize();
	      }
	     
	      @QAFTestStep(description ="Contactus")
	      public void Contactus(String email,String psword,String txt) throws InterruptedException {
	         
	          //LOGIN Functionality
	           click("signin");
	           clear("Clear_Email");
	           sendKeys(email,"EMAIL");
	           Thread.sleep(10000);
	           clear("Clear_PWD");
	           sendKeys(psword,"PASSWORD");
	           click("Login");
	           //Contact Us
	           click("Menu");
	           click("contact");
	           click("subject");
	           click("customerservice");
	           sendKeys(txt,"Chat");
	           click("send");
	          	         
	      }
	      @QAFDataProvider(dataFile = "TestData/UserData.xls", sheetName="UserDetails")	  
	       @Test(enabled=true)
	       public  void Contactus(Map<String, String> userData)throws IOException, InterruptedException{
	         
	         Contactus(userData.get("email"),userData.get("password"),userData.get("message"));
	         System.out.println("Message Sent successfully");
	         Reporter.logWithScreenShot("pass");
	       }
	}
	
	

}
