package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/a")
    WebElement demoHyperLink;
    
    public void Login(WebDriverWait wait, Actions action, WebDriver driver) throws InterruptedException {
    	
    	// Wait until Demo link to be clickable
    	 wait.until(ExpectedConditions.elementToBeClickable(demoHyperLink));
         action.moveToElement(demoHyperLink).click().build().perform();
    	
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/a"))));
        //action.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/a"))).click().build().perform();
        //Thread.sleep(3000);
    }

}
