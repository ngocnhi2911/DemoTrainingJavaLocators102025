package pages;


import common.BasePage;
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
    }

    private By totalSearchW = By.xpath("//table[@id='clients']//tbody//td/a[contains(text(),'w')]");
    private By firstRowCustomers = By.xpath("//table[@id='clients']//tbody/tr[1]/td[3]");
    private By linkDelete = By.xpath("//table[@id='clients']/tbody/tr[1]//a[normalize-space()='Delete']");
    private By inputSearch = By.xpath("//div[@id='clients_filter']//input[@type='search']");

    public void searchTotalW() throws InterruptedException {

        while (true){
            WebUI.clickElement(driver, inputSearch);
            WebUI.setTextElement(driver, inputSearch, "w");
            Thread.sleep(2000);

            List<WebElement> searchTotaldata = WebUI.getWebElements(driver, totalSearchW);
         //   WebElement firstRow = WebUI.getWebElement(driver, firstRowCustomers);
            // B2: Hover chuột vào dòng đầu tiên
            // 3. Lấy dòng đầu tiên
            WebElement firstRow = searchTotaldata.get(0);

            Actions actions = new Actions(driver);
            actions.moveToElement(firstRow).perform();
            Thread.sleep(2000);

            WebUI.clickElement(driver, linkDelete);
            Thread.sleep(1000);
            driver.switchTo().alert().accept();
            Thread.sleep(1000);

            //   cb.click();
            Thread.sleep(1000);
        }
    }


    public void searchTotal(String customerName){
        WebUI.clickElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, "w");
    }

    public void hoverTotal(String customerName) throws InterruptedException {
        WebElement firstRow = WebUI.getWebElement(driver, firstRowCustomers);
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);
    }

    public void clickLinkDelete(String customerName){
        WebUI.clickElement(driver, linkDelete);
    }

    public void clickAcceptAlert(String customerName) throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

}
