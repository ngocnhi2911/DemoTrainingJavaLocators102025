package common;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public SoftAssert softAssert;


    @BeforeMethod
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) throws InterruptedException {
        // gán @Optional("chrome"): cho trường hợp lỡ như quên truyền tham số thì nó sẽ lấy giá trị mặc định = Chrome
        setupDriver(browser);
        softAssert = new SoftAssert();

//        driver = new ChromeDriver(); // giá trị cứng
//        driver.manage().window().maximize();
//      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        softAssert = new SoftAssert();
//        System.out.println("Create Chrome driver");

    }

    public WebDriver setupDriver(String browserName) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":  // Nếu như tham số browserName = Chrome thì khởi tạo initChromeDriver
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "edge":
                driver = initEdgeDriver();
                break;
            default: // nếu k rơi vào 3 trường hợp trên thì chạy với Chrome
                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;
    }

    private WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }


    @AfterMethod
    public void closeDriver(){
        if(driver != null){
            driver.quit();

           // System.out.println("Closed Chrome driver");
        }
        softAssert.assertAll();
    }
}
