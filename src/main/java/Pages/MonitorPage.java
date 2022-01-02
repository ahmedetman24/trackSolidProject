package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonitorPage extends PageBase {
	
	public MonitorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//catch all List items in the Page
	@FindBy(tagName = "li")
	java.util.List<WebElement> cars;
	
	@FindBy(css = "div.leaflet-popup.leaflet-zoom-animated")
	WebElement carPopup;
	
	WebElement firstCar;
	
	public void selectDeviceDetails(WebDriverWait wait, Actions action, WebDriver driver) throws InterruptedException 
	{
		// Get the first Car
		firstCar = detectLink(cars, firstCar, "Default Group");
		
		// Click on the first car in the menu
		wait.until(ExpectedConditions.elementToBeClickable(firstCar));
		System.out.println("First Car detected");
		clickButton(firstCar, wait, action);
		Thread.sleep(3000);
		
		// Open car details
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("i.iconfont.iconicon_detail")));
		System.out.println("Car popup opened");
		WebElement deviceDetailBtn = driver.findElement(By.cssSelector("i.iconfont.iconicon_detail"));
		clickButton(deviceDetailBtn, wait, action);
		
	}

}
