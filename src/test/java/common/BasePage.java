package common;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CustomersPage;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.TasksPage;

import static bt_locators.LocatorsLeadsCRM.*;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public By menuLeads = By.xpath("//span[@class='menu-text' and normalize-space()='Leads']");
    public By menuDashboard = By.xpath("//span[@class='menu-text' and normalize-space()='Dashboard']");
    public By menuTasks = By.xpath("//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Tasks']");
    public By menuCustomers = By.xpath("//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Customers']");

   // Khai báo các hàm xử lý chung (hàm xử lý click vào các menu Dashboard, Lead, Task)

//    public void clickMenuDashboard(){
//        WebUI.clickElement(driver, menuDashboard);
//
//    }

    public DashboardPage clickMenuDashboard(){
        WebUI.clickElement(driver, menuDashboard);
        return new DashboardPage(driver);
    }

    public LeadsPage clickMenuLead(){
        WebUI.clickElement(driver, menuLeads);
        return new LeadsPage(driver);
    }

    public TasksPage clickMenuTask(){
        WebUI.clickElement(driver, menuTasks);
        return new TasksPage(driver);
    }

    public CustomersPage clickMenuCustomers(){
        WebUI.clickElement(driver, menuCustomers);
        return new CustomersPage(driver);
    }

}
