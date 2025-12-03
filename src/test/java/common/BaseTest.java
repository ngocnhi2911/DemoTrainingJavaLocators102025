package common;

import bt_locators.LocatorsLeadsCRM;
import bt_locators.LocatorsLoginCRM;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public static SoftAssert softAssert;


    @BeforeMethod
    public static void createDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        System.out.println("Create Chrome driver");
      //  loginCRM();
    }

//    public static void loginCRM() throws InterruptedException {
//        driver.get(LocatorsLoginCRM.url);
//       // WebUI.openURL(driver, LocatorsLeadsCRM.url);
//
//        // Verify hiển thị header 'Login'
//      //  List<WebElement> checkHeaderLogin = driver.findElements(By.xpath(LocatorsLeadsCRM.headerLoginPage));
//
//        List<WebElement> checkHeaderLogin = WebUI.getWebElements(driver, LocatorsLoginCRM.headerLoginPage);
//        System.out.println("checkHeaderLogin: " + checkHeaderLogin.size());
//        Assert.assertTrue(checkHeaderLogin.size() > 0, "Header Login is not displayed");
//
//        // So sánh header Login có đúng với kết quả mk mong muốn hay k
//      //  String headerLoginText = driver.findElement(By.xpath(LocatorsLeadsCRM.headerLoginPage)).getText();
//
//        String headerLoginText = WebUI.getWebElement(driver, LocatorsLoginCRM.headerLoginPage).getText();
//
//        Assert.assertEquals(headerLoginText, "Login", "Header Login is not correct");
//
//
//        WebUI.clearTextElement(driver, LocatorsLoginCRM.inputEmail);
//        WebUI.setTextElement(driver, LocatorsLoginCRM.inputEmail, "admin@example.com");
//        WebUI.clearTextElement(driver, LocatorsLoginCRM.inputPassword);
//        WebUI.setTextElement(driver, LocatorsLoginCRM.inputPassword, "123456");
//        WebUI.clickElement(driver, LocatorsLoginCRM.buttonLogin);
//
//        Thread.sleep(2000);
//
//
//        // Sau khi đăng nhập thành công --> hiển thị menu Dashboard
//        // Verify menu Dashboard
//        //List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsLeadsCRM.menuDashboard));
//
//        List<WebElement> checkMenuDashboard = WebUI.getWebElements(driver, LocatorsLeadsCRM.menuDashboard);
//        System.out.println("checkMenuDashboard: " + checkMenuDashboard.size());
//        Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard is not displayed after login");
//
//    }

    @AfterMethod
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            softAssert.assertAll();
            System.out.println("Closed Chrome driver");
        }
    }
}
