package pages;


import common.BasePage;
import keywords.Action_OLD;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CustomersPage extends BasePage {

    private WebDriver driver;

    public CustomersPage(WebDriver driver){
        super(driver); // phải dùng super do khi kế thừa 1 class mà nó có tham số trong hàm xây dựng phải cần super
        this.driver = driver;
        new WebUI(driver);  // Khởi tạo WebUI để truyền giá trị driver vào trong class WebUI
    }

    private By totalSearchW = By.xpath("//table[@id='clients']//tbody//td/a[contains(text(),'w')]");
    private By firstRowCustomers = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]");
    private By linkDelete = By.xpath("//table[@id='clients']/tbody/tr[1]//a[normalize-space()='Delete']");
    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");

    public void searchTotalW(){

        while (true){
            WebUI.clickElement(inputSearch);
            WebUI.setTextElement(inputSearch, "w");
            WebUI.sleep(2);

            List<WebElement> searchTotaldata = WebUI.getWebElements(totalSearchW);
         //   WebElement firstRow = WebUI.getWebElement(driver, firstRowCustomers);
            // B2: Hover chuột vào dòng đầu tiên
            // 3. Lấy dòng đầu tiên
            WebElement firstRow = searchTotaldata.get(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(firstRow).perform();
            WebUI.sleep(2);

            WebUI.clickElement(linkDelete);
            WebUI.sleep(2);
            driver.switchTo().alert().accept();
            WebUI.sleep(2);
        }
    }


    public void searchTotal(String customerName){
        WebUI.clickElement(inputSearch);
        WebUI.setTextElement(inputSearch, customerName);
    }

    public void hoverTotal(String customerName){
        WebElement firstRow = WebUI.getWebElement(firstRowCustomers);
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        WebUI.sleep(2);
    }

    public void clickLinkDelete(String customerName){
        WebUI.clickElement(linkDelete);
    }

    public void clickAcceptAlert(String customerName){
        driver.switchTo().alert().accept();
        WebUI.sleep(2);
    }

}
