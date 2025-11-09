package login_crm;

import bt_locators.LocatorsLeadsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginCRM {
    public static WebDriver driver;

    public static void createDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Create Chrome driver");
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

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            System.out.println("Closed Chrome driver");
        }
    }

}
