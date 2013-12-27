

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


	 public class Opsm_Automation {
	 WebDriver driver;
	

	 
	 
	 @BeforeMethod
	 public void setUp()
	 {
		 System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\Downloads\\IEDriverServer_x64_2.37.0\\IEDriverServer.exe");
	       DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	       capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	       driver = new InternetExplorerDriver(capab);
	 }
	 
	   String xpath= ".//*[@id='txtWorkPlanName']";

	/* public boolean IsEditable(String xpath)
	 {
	   boolean state = false;
	   if (driver.findElement(By.xpath(xpath)).isEnabled())
	   {
	    state = true;
	    
	    System.out.println("asdasd");
	   }
	   return state;
	 }*/
	
	 @Test
	 public void openOpsm() throws InterruptedException
	 {
	   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	   driver.get(" https://khonestdwsw11.kiewitplaza.com:65443/OPSM_UI_1/");
	   driver.get("javascript:document.getElementById('overridelink').click();");  
	   driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td/div/table/thead/tr/th[2]/a[1]/span")).click();
	   driver.findElement(By.className("k-textbox")).sendKeys("124557");
	   driver.findElement(By.xpath("html/body/div[2]/form/div[1]/button[1]")).click();
	   driver.findElement(By.linkText("124557")).click();
	   driver.findElement(By.id("btnCancelCompSerach")).click();
	   //driver.get("javascript:document.getElementById('span_Workplan').click();");
	   //driver.get("javascript:document.getElementById('Span_Quantity').click();");
	   
	 /*	   WebDriverWait wait = new 	WebDriverWait(driver,20);
	   WebElement compose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='divQuantity']/div/div/div[1]/div[1]/table/tbody/tr/td[1]/div/span")));
	   String a = compose.getText();
	   System.out.println(a+"aaaaaaa");
	   Assert.assertEquals(a, "Quantity Book");
	 */  
	   WebElement element1 = driver.findElement(By.id("span_Workplan"));
	   JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	   executor1.executeScript("arguments[0].click();", element1);
	   
	   driver.findElement(By.xpath(".//*[@id='rdFromScratch']")).click();
	   driver.findElement(By.xpath(".//*[@id='btnCreateWorkPlan']")).click();
	   
	   //PARENT PLAN PACKAGE ID
	   String string = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[1]/td[1]/label")).getText();
	   Assert.assertEquals(string, "Parent Plan/Package ID");
	   
	   WebElement some_element = driver.findElement(By.xpath(".//*[@id='txtParentPlanId']"));
	   String readonly = some_element.getAttribute("readonly");
	   Assert.assertNull(readonly);
	   
	   //WORK PLAN PACKAGE ID
	   String string1 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[3]/td[1]/label")).getText();
	   Assert.assertEquals(string1, "Work Plan /Package ID");
	   
	   WebElement some_element1 = driver.findElement(By.xpath(".//*[@id='txtWorkPlanId']"));
	   String readonly1 = some_element1.getAttribute("readonly1");
	   Assert.assertNull(readonly1);

	   //PARENT PLAN NAME

	   String string2 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[1]/td[2]/label")).getText();
	   Assert.assertEquals(string2, "Parent Plan Name");
	   
	   WebElement some_element2 = driver.findElement(By.xpath(".//*[@id='txtParentPlanName']"));
	   
	   String readonly2 = some_element2.getAttribute("readonly2");
	   Assert.assertNull(readonly2);
	  
	 
	   //operation
	   String string3 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[5]/td[2]/label")).getText();
	   Assert.assertEquals(string3, "Operation");
	   
	  
	   //discipline
	   String string4 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[7]/td[2]/label")).getText();
	   Assert.assertEquals(string4, "Discipline *");
	  
	   //package description
	   String string5 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[3]/td[3]/label")).getText();
	   Assert.assertEquals(string5, "Work Plan/Package Description");
	   
	   //District
	   String string6 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[5]/td[3]/label")).getText();
	   Assert.assertEquals(string6, "District");
	   
	   //Work Type 
	   String string7 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[7]/td[3]/label")).getText();
	   Assert.assertEquals(string7, "Work Type *");

	   //status
	   String string8 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[5]/td[4]/label")).getText();
	   Assert.assertEquals(string8, "Status");
	   
	   //
	   String string9 = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[7]/td[4]/label")).getText();
	   Assert.assertEquals(string9, "Incident No.");
	   
	   WebElement some_element3 = driver.findElement(By.xpath(".//*[@id='txtWorkPlanName']"));
	   some_element3.sendKeys("Aeka");
	   
	   
	 /*  driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
	   driver.findElement(By.xpath("/html/body/div[23]/div/ul/li[3]")).click();
	   driver.findElement(By.xpath("(//input[@type='text'])[12]")).click();
	   driver.findElement(By.cssSelector("li.k-item.k-state-hover")).click();
		 */
	   
	   //	ops.this.IsEditable(xpath);
	   
	   //Select type = new Select(driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[8]/td[3]/span/span")));
	   //type.selectByIndex(1);
	
	   //work type drop down
	  driver.findElement(By.xpath("(//input[@type='text'])[12]")).click();
	  WebElement sel = driver.findElement(By.id("ddlWorkType-list"));
	  List<WebElement> lists = sel.findElements(By.tagName("li"));
	 
	  for(WebElement element: lists)
	       {
	         String str = element.getText();
	         if (element.getText().equals("Construction")) 
	           {
	        	  System.out.println("Construction");
	        	  str.contentEquals("Construction");
	           }
	          else if (element.getText().equals("Rework")) 
	          {
	        	  System.out.println("Rework");
	        	  str.contentEquals("Rework");
	        	  element.click();
	          }
	          else if (element.getText().equals("Test"))
	          {
	        	  System.out.println("Test");
	        	  str.contentEquals("Test");
	        	  break;
	          }
	       }
	  
	 // driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[8]/td[2]/span/span/span/span")).click();
	
	  driver.findElement(By.xpath("(//input[@type='text'])[11]")).click();
	  WebElement discilineId = driver.findElement(By.id("ddlWKDiscipline-list"));
	  List<WebElement> discilineLists = discilineId.findElements(By.tagName("li"));
	 
	  for(WebElement element: discilineLists)
	       {
	         String str = element.getText();
	         if (element.getText().equals("Pipe")) 
	           {
	        	  System.out.println("Pipe");
	        	  str.contentEquals("Pipe");
	           }
	         else if (element.getText().equals("Electrical")) 
	           {
	        	  System.out.println("Electrical");
	        	  str.contentEquals("Electrical");
	           }
	          else if (element.getText().equals("Instrumentation")) 
	          {
	        	  System.out.println("Instrumentation");
	        	  str.contentEquals("Instrumentation");
	          }
	          else if (element.getText().equals("Plant Equipment"))
	          {
	        	  System.out.println("Plant Equipment");
	        	  str.contentEquals("Plant Equipment");
	          }
	          else if (element.getText().equals("Structural Steel")) 
	          {
	        	  System.out.println("Structural Steel");
	        	  str.contentEquals("Structural Steel");
	        	  element.click();
	          }
	          else if (element.getText().equals("System Test and Commissioning")) 
	          {
	        	  System.out.println("System Test and Commissioning");
	        	  str.contentEquals("System Test and Commissioning");
	          }
	          else if (element.getText().equals("General")) 
	          {
	        	  System.out.println("General");
	        	  str.contentEquals("General");
	          }
	          else if (element.getText().equals("Welding")) 
	          {
	        	  System.out.println("Welding");
	        	  str.contentEquals("Welding");
	        	  break;
	          }
	       }
	 
	  boolean distirct = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[6]/td[3]/span/span/input")).isEnabled();
	  System.out.println(distirct);
	  Assert.assertEquals(false, distirct);
	  
	  boolean discpline = driver.findElement(By.xpath(".//*[@id='divOverviewContainer']/table/tbody/tr[8]/td[2]/span/span/input")).isEnabled();
	  System.out.println(discpline);
	  Assert.assertEquals(true, discpline);
	 }
	 }