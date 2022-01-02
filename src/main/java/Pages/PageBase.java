package Pages;

import static java.lang.Integer.parseInt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageBase {
    public PageBase(WebDriver driver) {
    	super();
    	PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button, WebDriverWait wait, Actions actions) {

        //System.out.println(button.getLocation().toString());

        actions.moveToElement(button).click().build().perform();
    }
	
	protected static WebElement detectLink(java.util.List<WebElement> elementsList, WebElement targetElement, String elementName)
	{
		System.out.println("Detect Link started");
		for(int i = 0; i<elementsList.size();i++)
		{
			//System.out.println("Target Element is: "+elementsList.get(i).getText());
			//System.out.println("Target Element is: ");
			if(elementsList.get(i).getText().contains(elementName))
			{
				targetElement = elementsList.get(i+1);
				System.out.println("Target Element is: "+targetElement.getText().toString());
				break;
			}
		}
		
		return targetElement;
	}

    protected static void setTextElementText(WebElement textElement, String value, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(textElement));
        textElement.clear();
        textElement.sendKeys(value);
    }

    protected static void select_from_dropdown_menu_by_index(WebElement select, String value, WebDriverWait wait) {
        Select authority = new Select(select);
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(select, By.tagName("option")));
        authority.selectByIndex(parseInt(value));
    }

    protected static void select_from_dropdown_menu_by_visible_text(WebElement select, String value, WebDriverWait wait) {
        Select authority = new Select(select);
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(select, By.tagName("option")));
        authority.selectByVisibleText(value);
    }
}
