package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ReportPage;

public class secondScenarioTestCase extends TestBase {
	
	ReportPage reportPage;
	
	@Test(priority=1,alwaysRun=true)
	public void openReportPage()
	{
		//reportPage = new ReportPage();
		reportPage = new ReportPage(driver);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='txt'][contains(.,'Report')]")));
		reportPage.openReportPage(wait, actions, driver);
		Assert.assertTrue(driver.getTitle().contains("Report"));
	}
	
	@Test(dependsOnMethods= {"openReportPage"})
	public void openMotionOverview()
	{
		reportPage.openMotionOverview(wait, actions, driver);
		Assert.assertTrue(driver.findElement(By.cssSelector("div.right-report__title")).getText().contains("Motion Overview"));
	}

	@Test(dependsOnMethods= {"openMotionOverview"})
	public void search()
	{
		reportPage.search(wait, actions, driver, "2021-12-01 00:00:00", "2021-12-05 00:00:00");
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[4]/div/div[1]/div[3]/table/tbody/tr/td[1]/div/div")).getText().contains("1"));
	}

}
