package pages;

import common.BasePage;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver){
        super(driver); // phải dùng super do khi kế thừa 1 class mà nó có tham số trong hàm xây dựng phải cần super
        this.driver = driver;
    }

    private By buttonDashboardOption = By.xpath("//div[@class='screen-options-btn']");
    private By labelTotalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");


    public void verifyDashboardPageDisplayed(){
        boolean isElementDisplayed = WebUI.getWebElements(driver, buttonDashboardOption).size()>0;
        Assert.assertTrue(isElementDisplayed, "Dashboard Page is not displayed");
    }

    public String getTotalConvertedLeads() {
        String totalConvertedLeads = driver.findElement(labelTotalConvertedLeads).getText();
        System.out.println("Total Projects In Progress: " + totalConvertedLeads);
        return totalConvertedLeads;
    }


}
