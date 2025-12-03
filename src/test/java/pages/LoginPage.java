package pages;

import bt_locators.LocatorsLeadsCRM;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LoginPage {

    //Khai báo driver trong từng trang, khai báo private vì chỉ sử dụng nội bộ trong trang Login
    private WebDriver driver;

    //Khai báo hàm xây dựng cho từng trang, là hàm xây dựng nên để public
    public LoginPage(WebDriver driver){
        //truyền driver từ bên ngoài vô để nhận giá trị được khởi tạo từ class BaseTest
        this.driver = driver; //this: dùng để phân biệt 2 biến cùng tên trong và ngoài
    }

    // Khai báo đối tượng trong trang đó (là các element) thuộc về trang Login
    //Để là private vì những element này chỉ sử dụng nội bộ trong trang Login
    private static String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    private By headerLoginPage = By.xpath("//h1[normalize-space() = 'Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxRememberMe = By.xpath("//input[@id='remember']");
    private By labelRememberMe = By.xpath("//label[@for='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");

    //** Nếu có id --> Nên dùng id, (xác định thằng cha rồi đến thằng con) để check lỗi mình mong muốn có đúng k
    private By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div");

    private By alertErrorMessage = By.xpath("//div[contains(text(), 'Invalid email')]");
    private By alertErrorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.']");
    private By alertErrorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.']");

    // Khai báo các hàm xử lý trong nội bộ trang Login
    // 3 hàm enterEmail,enterPassword,clickButtonLogin nên khai báo là private --> chỉ sử dụng nó trong nội bộ class LoginPage
    //vì mk đã gọi lại trong hàm loginCRM, chứ k cần gọi lại 3 hàm này ở class khác

    private void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    public void navigateToLoginPage(){
        driver.get(url);
    }
    public void loginCRM(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickButtonLogin();
    }

    public DashboardPage loginCRM(){
        navigateToLoginPage();
        enterEmail("admin@example.com");
        enterPassword("123456");
        clickButtonLogin();
        verifyLoginSuccess();
        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() {
        List<WebElement> checkMenuDashboard = WebUI.getWebElements(driver, LocatorsLeadsCRM.menuDashboard);
        System.out.println("checkMenuDashboard: " + checkMenuDashboard.size());
        Assert.assertTrue(checkMenuDashboard.size() > 0, "Menu Dashboard is not displayed after login");
        System.out.println("Đăng nhập CRM thành công");
    }

    public void verifyLoginFailWithEmailOrPasswordInvalid() {
        boolean isElementErrorMessageInvalid = WebUI.getWebElements(driver, errorMessageInvalidEmailOrPassword).size()>0;
        System.out.println("isElementErrorMessageInvalid: " + isElementErrorMessageInvalid);
        Assert.assertTrue(isElementErrorMessageInvalid, "Error message for invaild email not displayed");
        System.out.println("Đăng nhập CRM thất bại");
    }

    public void verifyLoginFailWithEmailNull() {
        List<WebElement> isElementErrorMessageEmailNull = WebUI.getWebElements(driver, alertErrorMessageEmailRequired);
        System.out.println("isElementErrorMessageEmailNull: " + isElementErrorMessageEmailNull.size());
        Assert.assertTrue(isElementErrorMessageEmailNull.size() > 0, "Error message for required email null");
        System.out.println("Đăng nhập CRM thất bại");
    }

    public void verifyLoginFailWithPasswordNull() {
        boolean isElementErrorMessagePasswordNull = WebUI.getWebElements(driver, alertErrorMessagePasswordRequired).size()>0;
        System.out.println("isElementErrorMessagePasswordNull: " + isElementErrorMessagePasswordNull);
        Assert.assertTrue(isElementErrorMessagePasswordNull, "Error message for required password null");
        System.out.println("Đăng nhập CRM thất bại");
    }



}
