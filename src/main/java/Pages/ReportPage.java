package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportPage extends PageBase {
	public ReportPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);
	}

	//@FindBy(id = "reportsManagement")
	WebElement reportHyperLink;
	
	@FindBy(tagName = "li")
	java.util.List<WebElement> allLiElements;
	
	//@FindBy(tagName = "span")
	java.util.List<WebElement> allDivElements;
	
	//@FindBy(css = "li.el-submenu")
	@FindBy(xpath = "//span[contains(.,'Motion Statistics')]")
	WebElement motionStatisticsDropDownList;
	
	@FindBy(xpath = "(//li[@role='menuitem'][contains(.,'Motion Overview')])[2]")
	WebElement motionOverviewHyperLink;
	
	@FindBy(xpath = "(//input[@rows='2'])[1]")
	WebElement fromDateTxtBox;
	
	@FindBy(xpath = "(//button[@type='button'])[17]")
	WebElement fromDateConfirmBtn;
	
	@FindBy(xpath = "(//input[contains(@type,'text')])[3]")
	WebElement toDateTxtBox;
	
	@FindBy(xpath = "(//button[contains(@native-type,'button')])[12]")
	WebElement toDateConfirmBtn;	
	
	@FindBy(xpath = "(//input[@type='text'])[6]")
	WebElement selectDeviceDropDownList;
	
	@FindBy(xpath = "(//span[@class='el-checkbox__inner'])[2]")
	WebElement firstCheckBox;
	
	@FindBy (xpath = "/html/body/div[4]/div/div[3]/button[2]/span")
	WebElement confirmDeviceBtn;
	
	@FindBy (css = "ux-button.ux-button--primary")
	WebElement searchBtn;
	
	@FindBy (xpath = "/html/body/div[1]/div/div[2]/div[2]/div[4]/div/div[1]/div[3]/table/tbody/tr/td[1]/div/div")
	WebElement searchFirstResult;
	
	
	public void openReportPage (WebDriverWait wait, Actions action, WebDriver driver)
	{
		System.out.println("-------------------------------------------------------------");
		System.out.println("Second Test Scenario");

		//driver.navigate().refresh();
		reportHyperLink = detectLink(allLiElements, reportHyperLink, "Monitor");
		System.out.println("Report text: "+ reportHyperLink.getText());
		wait.until(ExpectedConditions.elementToBeClickable(reportHyperLink));
		clickButton(reportHyperLink, wait, action);
		System.out.println("Report Page Opened");
	}
	
	public void openMotionOverview (WebDriverWait wait, Actions action, WebDriver driver)
	{
		System.out.println("Motion Overview method");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("div.left-menu left-trip-show"))));
		action.moveToElement(driver.findElement(By.className("div.left-menu left-trip-show")));
		action.moveToElement(driver.findElement(By.cssSelector("ul.menu-list el-menu")));
		allDivElements = driver.findElements(By.tagName("li"));
		
		//motionStatisticsDropDownList = detectLink(allDivElements, motionStatisticsDropDownList, "Device statistics");
		//motionStatisticsDropDownList = detectLink(allLiElements, motionStatisticsDropDownList, "Logistics");
		//motionStatisticsDropDownList = driver.findElement(By.cssSelector("el-submenu__title"));
		//action.moveToElement(motionStatisticsDropDownList).build().perform();
		System.out.println("Path is: "+motionStatisticsDropDownList.getText());
		//clickButton(motionStatisticsDropDownList, wait, action);
		clickButton(allDivElements.get(1), wait, action);
		
		motionOverviewHyperLink = detectLink(allLiElements, motionOverviewHyperLink, "Motion Overview");
		clickButton(motionOverviewHyperLink, wait, action);
		
		System.out.println("Motion Overview Page opened");
	}
	
	public void search (WebDriverWait wait, Actions action, WebDriver driver, String dateFrom, String dateTo)
	{
		//Fill Date From
		setTextElementText(fromDateTxtBox, dateFrom, wait);
		clickButton(fromDateConfirmBtn, wait, action);
		
		//Fill Date To
		setTextElementText(toDateTxtBox, dateTo, wait);
		clickButton(toDateConfirmBtn, wait, action);
		
		//Select device
		clickButton(selectDeviceDropDownList, wait, action);
		clickButton(firstCheckBox, wait, action);
		
		//Click on "Search" button
		clickButton(searchBtn, wait, action);
	}
	
	

}
