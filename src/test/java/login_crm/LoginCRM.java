package login_crm;

import bt_locators.LocatorsLeadsCRM;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class LoginCRM {
    /*
    public static WebDriver driver;

    public static boolean checkExistsElement(WebDriver driver, By by) {
        List<WebElement> element = getWebElements(driver, by);
        if (element.size() > 0) { //list # rỗng --> phần tử tồn tại
            System.out.println("Phần tử tồn tại: true" + by);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false" + by);
            return false;
        }
    }

    public static void waitElementVisiable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitElementVisiable(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitElementToBeClickable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitElementToBeClickable(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second), Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static WebElement getWebElement(WebDriver driver, By by){
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(WebDriver driver, By by){
        return driver.findElements(by);
    }

    public static void openURL(WebDriver driver, String url){
        driver.get(url);
    }

    public static void clearElementText(WebDriver driver, By by){
        LoginCRM.waitElementVisiable(driver, by);
        getWebElement(driver, by).clear();
        System.out.println("Clear text on element: " + by);
    }


    public static void setTextElement(WebDriver driver, By by, String text){
        LoginCRM.waitElementVisiable(driver, by);
        getWebElement(driver,by).sendKeys(text);
    }

    public static void setTextAndKeyElement(WebDriver driver, By by, String text, Keys key){
        LoginCRM.waitElementVisiable(driver, by);
        getWebElement(driver,by).sendKeys(text);
    }

    public static void clickElement(WebDriver driver, By by){
        LoginCRM.waitElementToBeClickable(driver, by);
        getWebElement(driver,by).click();
    }

    public static void clickElement(WebDriver driver, By by, int time){
        LoginCRM.waitElementToBeClickable(driver, by, time);
        getWebElement(driver,by).click();
    }

    public static String getElementText(WebDriver driver, By by){
        LoginCRM.waitElementVisiable(driver, by);
        WebElement element = getWebElement(driver, by);
        String text = element.getText();
        return text;
    }

    public static String getElementAttribute(WebDriver driver, By by, String attribute){
        LoginCRM.waitElementVisiable(driver, by);
        WebElement element = getWebElement(driver, by);
        String textAttribute = element.getAttribute(attribute);
        return textAttribute;
    }

    public static void scrollAtTop(WebDriver driver, By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, by));
    }

    public static void scrollAtBottom(WebDriver driver, By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, by));
    }





    @BeforeMethod
    public static void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Create Chrome driver");
        loginCRM();
    }

    public static void loginCRM(){
        driver.get(LocatorsLeadsCRM.url);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonLogin)).click();
        // Verify login success
    }

    @AfterMethod
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            System.out.println("Closed Chrome driver");
        }
    }

    */


}
