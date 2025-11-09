package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import login_crm.LoginCRM;
import org.openqa.selenium.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.getValueCountry;

public class AddNewLeads extends LoginCRM {

    public static void openNewLeadsPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLead)).click();
    }

    public static void addNewLeads(String leadsName) throws InterruptedException {
        openNewLeadsPage();
        Thread.sleep(1000);

        //------------------- Xác định dropdown Status -- Cách 1---------------------------
        // B1. Click vào dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(1000);
        //B2.Tìm kiếm giá trị cần chọn và nhấn Enter
        // --> Trường hợp này khi tìm kiếm với giá trị sai --> nó vẫn chạy được nhưng kết quả là trống
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchStatus)).sendKeys("Active", Keys.ENTER);
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 2: chỉ dùng khi giá trị mở dropdown ra là thấy-----------------------------
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSource)).click();  // Source
        Thread.sleep(1000);
        String xpathSource = getValueSource("Google");
        WebElement source = driver.findElement(By.xpath(xpathSource));
        source.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssigned)).click();   // Assigned
        Thread.sleep(1000);
        String xpathAssigned = getValueAssigned("Admin Anh Tester");
        WebElement assigned = driver.findElement(By.xpath(xpathAssigned));
        assigned.click();
        Thread.sleep(1000);


        // B1: Mở dropdown
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(1000);
       // B2: Lấy danh sách tất cả các phần tử trong dropdown
        List<WebElement> allOptions = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(1000);
      // B3: Duyệt từng WebElement trong danh sách để tìm phần tử có text = "JSC_NEW"
        for (WebElement option : allOptions) {
            if (option.getText().equals("JSC_NEW")) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(leadsName);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys("Đại Linh");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys("Tester");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys("Hà Nội");
        Thread.sleep(1000);

//        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys("ngocyennhi2911@gmail.com");
//        Thread.sleep(1000);

        Random random = new Random();
        int randomNum = random.nextInt(100000); // ví dụ 0–99999
        String dynamicEmail = "ngocyen" + randomNum + "@gmail.com";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys(dynamicEmail);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys("Nam Từ Liêm");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys("https://crm.anhtester.com/admin/leads");
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 3-----------------------------
        // B1: Click mở dropdown Country
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        // B2: Nhập từ khóa cần tìm vào ô search --> để lọc danh sách
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys("Vietnam");
        // B3: Tạo xpath tương ứng với giá trị muốn chọn
        String xpathCountry = getValueCountry("Vietnam");
        Thread.sleep(1000);
        // B4: Tìm phần tử tương ứng và click
        driver.findElement(By.xpath(xpathCountry)).click();
        Thread.sleep(1000);
        //-------------

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys("0982198605");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys("123456");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys("120");
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchDefaultLanguage)).sendKeys("Vietnamese", Keys.ENTER);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys("Nodo JSC");
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys("Kiểm tra bài tập");
        Thread.sleep(1000);


        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).isSelected();
        if(isSelectedPublic == false)
        {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        }
        Thread.sleep(1000);


        boolean isSelectedContactedToday = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();
        if(isSelectedContactedToday == true)
        {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).click();
        }
        Thread.sleep(1000);

//        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted)).sendKeys("08-11-2025 06:00");
//        Thread.sleep(1000);

        // B1: Lấy thời gian hiện tại
        LocalDateTime now = LocalDateTime.now();
        // B2: Định dạng theo format của hệ thống
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String currentDateTime = now.format(formatter);
        // B3: Gửi vào trường Date Contacted
        WebElement dateContactedInput = driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted));
        dateContactedInput.sendKeys(currentDateTime);
        Thread.sleep(3000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonSave)).click();
        Thread.sleep(3000);

    }


    public static void searchLeads(String leadsName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.iconCloseProfile)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);

        String firstRowLeads = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRowItemLeads)).getText();
        System.out.println("First row customer: " + firstRowLeads);
        Thread.sleep(2000);
    }


    public static void main(String[] args) throws InterruptedException {
        createDriver();
        loginCRM();
        openNewLeadsPage();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = now.format(formatter);
        addNewLeads("Yến Nhi " + currentDateTime);
        searchLeads("Yến Nhi "+ currentDateTime);
        closeDriver();
    }
}
