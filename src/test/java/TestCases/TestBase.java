package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;
    public Actions actions;
    public static WebDriverWait wait;
    LoginPage LoginPage;

    @BeforeSuite
    public void Start_Driver() throws InterruptedException {

        // Launch Chrome Driver
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
       actions = new Actions(driver) ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://hk.tracksolidpro.com/mainFrame");
        Thread.sleep(3000);
        
        // Login
        System.out.println("Login function");
        LoginPage = new LoginPage(driver);
        LoginPage.Login(wait, actions ,driver);
        wait.until(ExpectedConditions.titleContains("Monitor"));*/
    }

    @BeforeClass
    public void Login() throws InterruptedException {
        /*System.out.println("Login function");
        LoginPage = new LoginPage(driver);
        LoginPage.Login(wait, actions ,driver);
        wait.until(ExpectedConditions.titleContains("Monitor"));*/
    	
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
       actions = new Actions(driver) ;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://hk.tracksolidpro.com/mainFrame");
        Thread.sleep(3000);
        
        // Login
        System.out.println("Login function");
        LoginPage = new LoginPage(driver);
        LoginPage.Login(wait, actions ,driver);
        wait.until(ExpectedConditions.titleContains("Monitor"));
    }

    @AfterClass
    public void logout() throws Exception {
       
        /*actions.moveToElement(driver.findElement(By.cssSelector("b.user-name"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.linkText("Logout"))).click().build().perform();
       
        // Press "Ok" at the confirmation message
        WebElement okBtn = driver.findElement(By.linkText("OK"));
        actions.moveToElement(okBtn).click().build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.titleContains("TracksolidPro"));*/
    	
    	actions.moveToElement(driver.findElement(By.cssSelector("b.user-name"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.linkText("Logout"))).click().build().perform();
       
        // Press "Ok" at the confirmation message
        WebElement okBtn = driver.findElement(By.linkText("OK"));
        actions.moveToElement(okBtn).click().build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.titleContains("TracksolidPro"));
    	
        driver.quit();
    }

    @AfterSuite
    public void Stop_Driver() throws InterruptedException {
    	
    	// Logout
    	/*actions.moveToElement(driver.findElement(By.cssSelector("b.user-name"))).click().build().perform();
        actions.moveToElement(driver.findElement(By.linkText("Logout"))).click().build().perform();
       
        // Press "Ok" at the confirmation message
        WebElement okBtn = driver.findElement(By.linkText("OK"));
        actions.moveToElement(okBtn).click().build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.titleContains("TracksolidPro"));
    	
        driver.quit();*/
    }
}
