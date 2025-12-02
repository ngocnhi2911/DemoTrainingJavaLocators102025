package bt_locators;

import org.openqa.selenium.By;

public class LocatorsLoginCRM {
    // public static String url = By.xpath("https://crm.anhtester.com/admin/authentication");
    public static String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public static By headerLoginPage = By.xpath("//h1[normalize-space() = 'Login']");
    public static By inputEmail = By.xpath("//input[@id='email']");
    public static By inputPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    public static By checkboxRememberMe = By.xpath("//input[@id='remember']");
    public static By labelRememberMe = By.xpath("//label[@for='remember']");
    public static By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");

    //** Nếu có id --> Nên dùng id, (xác định thằng cha rồi đến thằng con) để check lỗi mình mong muốn có đúng k
    public static By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div");

    public static By alertErrorMessage = By.xpath("//div[contains(text(), 'Invalid email')]");
    public static By alertErrorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.']");
    public static By alertErrorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.']");


}
