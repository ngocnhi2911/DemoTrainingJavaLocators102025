package common;

import bt_locators.LocatorsLeadsCRM;
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

    public boolean checkExistsElement(String xpathElement) {
        List<WebElement> element = driver.findElements(By.xpath(xpathElement));
        if (element.size() > 0) {
            System.out.println("Phần tử tồn tại: true" + xpathElement);
            return true;
        } else {
            System.out.println("Phần tử không tồn tại: false" + xpathElement);
            return false;
        }
    }

    @BeforeMethod
    public static void createDriver() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softAssert = new SoftAssert();
        System.out.println("Create Chrome driver");
        loginCRM();
    }

    public static void loginCRM() throws InterruptedException {
        driver.get(LocatorsLeadsCRM.url);

        // Verify hiển thị header 'Login'
        List<WebElement> checkHeaderLogin = driver.findElements(By.xpath(LocatorsLeadsCRM.headerLoginPage));
        System.out.println("checkHeaderLogin: " + checkHeaderLogin.size());
        Assert.assertTrue(checkHeaderLogin.size() > 0, "Header Login is not displayed");

        // So sánh header Login có đúng với kết quả mk mong muốn hay k
        String headerLoginText = driver.findElement(By.xpath(LocatorsLeadsCRM.headerLoginPage)).getText();
        Assert.assertEquals(headerLoginText, "Login", "Header Login is not correct");


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonLogin)).click();
        Thread.sleep(2000);


        // Sau khi đăng nhập thành công --> hiển thị menu Dashboard
        // Verify menu Dashboard
        List<WebElement> checkMenuDashboard = driver.findElements(By.xpath(LocatorsLeadsCRM.menuDashboard));
        System.out.println("checkMenuDashboard: " + checkMenuDashboard.size());
        Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard is not displayed after login");

    }

    @AfterMethod
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            softAssert.assertAll();
            System.out.println("Closed Chrome driver");
        }
    }
}
