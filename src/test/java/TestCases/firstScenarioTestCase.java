package TestCases;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.MonitorPage;

public class firstScenarioTestCase extends TestBase 
{
	public MonitorPage monitorPage;
	
	@Test
	public void openDeviceDetails() throws InterruptedException 
	{
		System.out.println("Open Device Details");
		monitorPage = new MonitorPage(driver);
		monitorPage.selectDeviceDetails(wait, actions, driver);
		
		// Go to the next tab and confirm that it is opened
		ArrayList<String> activeTabs = new ArrayList<String>(driver.getWindowHandles());
		Assert.assertTrue(driver.switchTo().window(activeTabs.get(1)).getTitle().contains("Device Management"));
		driver.switchTo().window(activeTabs.get(1));
		Thread.sleep(3000);
		driver.close();
		driver.switchTo().window(activeTabs.get(0));
	}
}
