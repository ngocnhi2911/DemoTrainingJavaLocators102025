package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import login_crm.LoginCRM;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.getValueCountry;

public class AddNewLeads extends LoginCRM {


    static String expectedStatus;
    static String expectedName;
    static String expectedSource;
    static String expectedAssigned;
    static String expectedTags;
    static String expectedAddress;
    static String expectedPosition;
    static String expectedCity;
    static String expectedEmailAddress;
    static String expectedState;
    static String expectedWebsite;
    static String expectedCountry;
    static String expectedPhone;
    static String expectedZipCode;
    static String expectedLeadValue;
    static String expectedDefaultLanguage;
    static String expectedCompany;
    static String expectedDescription;
    static String expectedDateContacted;
    static String expectedPublic;
    static String expectedContanctedToday;

    // Biến actual (giá trị đọc ở màn Edit)
    static String actualStatus;
    static String actualName;
    static String actualSource;
    static String actualAssigned;
    static String actualTags;
    static String actualAddress;
    static String actualPosition;
    static String actualCity;
    static String actualEmailAddress;
    static String actualState;
    static String actualWebsite;
    static String actualCountry;
    static String actualPhone;
    static String actualZipCode;
    static String actualLeadValue;
    static String actualDefaultLanguage;
    static String actualCompany;
    static String actualDescription;
    static String actualLastContacted;
    static String actualPublic;
    static String actualContanctedToday;



    public static void openNewLeadsPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLead)).click();
    }

    public static void addNewLeads(String leadsName) throws InterruptedException {
        openNewLeadsPage();
        Thread.sleep(1000);

        //------------------- Xác định dropdown Status -- Cách 1---------------------------
        // B1. Click vào dropdown
        expectedStatus = "Active";
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(1000);
        //B2.Tìm kiếm giá trị cần chọn và nhấn Enter
        // --> Trường hợp này khi tìm kiếm với giá trị sai --> nó vẫn chạy được nhưng kết quả là trống
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchStatus)).sendKeys(expectedStatus, Keys.ENTER);
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 2: chỉ dùng khi giá trị mở dropdown ra là thấy-----------------------------
        expectedSource = "Google";
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSource)).click();  // Source
        Thread.sleep(1000);
        String xpathSource = getValueSource(expectedSource);
        WebElement source = driver.findElement(By.xpath(xpathSource));
        source.click();
        Thread.sleep(1000);

        expectedAssigned = "Admin Anh Tester";
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssigned)).click();   // Assigned
        Thread.sleep(1000);
        String xpathAssigned = getValueAssigned(expectedAssigned);
        WebElement assigned = driver.findElement(By.xpath(xpathAssigned));
        assigned.click();
        Thread.sleep(1000);


        // B1: Mở dropdown
        expectedTags = "JSC_NEW";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(1000);
       // B2: Lấy danh sách tất cả các phần tử trong dropdown
        List<WebElement> allOptions = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(1000);
      // B3: Duyệt từng WebElement trong danh sách để tìm phần tử có text = "JSC_NEW"
        for (WebElement option : allOptions) {
            if (option.getText().equals(expectedTags)) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }


        expectedName = leadsName;
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(leadsName);
        Thread.sleep(1000);

        expectedAddress = "Đại Linh";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys(expectedAddress);
        Thread.sleep(1000);

        expectedPosition = "Tester";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys(expectedPosition);
        Thread.sleep(1000);

        expectedCity = "Hà Nội";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys(expectedCity);
        Thread.sleep(1000);

//        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys("ngocyennhi2911@gmail.com");
//        Thread.sleep(1000);

        Random random = new Random();
        int randomNum = random.nextInt(100000); // ví dụ 0–99999
        String dynamicEmail = "ngocyen" + randomNum + "@gmail.com";
        expectedEmailAddress = dynamicEmail;
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys(expectedEmailAddress);
        Thread.sleep(1000);

        expectedState = "Nam Từ Liêm";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys(expectedState);
        Thread.sleep(1000);

        expectedWebsite = "https://crm.anhtester.com/admin/leads";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys(expectedWebsite);
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 3-----------------------------
        // B1: Click mở dropdown Country
        expectedCountry = "Vietnam";
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        // B2: Nhập từ khóa cần tìm vào ô search --> để lọc danh sách
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys(expectedCountry);
        // B3: Tạo xpath tương ứng với giá trị muốn chọn
        String xpathCountry = getValueCountry(expectedCountry);
        Thread.sleep(1000);
        // B4: Tìm phần tử tương ứng và click
        driver.findElement(By.xpath(xpathCountry)).click();
        Thread.sleep(1000);
        //-------------

        expectedPhone = "0982198605";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys(expectedPhone);
        Thread.sleep(1000);

        expectedZipCode = "123456";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys(expectedZipCode);
        Thread.sleep(1000);

        expectedLeadValue = "120";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys(expectedLeadValue);
        Thread.sleep(1000);


        expectedDefaultLanguage = "Vietnamese";
        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchDefaultLanguage)).sendKeys(expectedDefaultLanguage, Keys.ENTER);
        Thread.sleep(1000);


        expectedCompany = "Nodo JSC";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys(expectedCompany);
        Thread.sleep(1000);

        expectedDescription = "Kiểm tra bài tập";
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys(expectedDescription);
        Thread.sleep(1000);



        boolean expectedPublic = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).isSelected();
        if(expectedPublic == false)
        {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        }
        Thread.sleep(1000);


        boolean expectedContanctedToday = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();
        if(expectedContanctedToday == true)
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
        expectedDateContacted = currentDateTime;
        WebElement dateContactedInput = driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted));
        dateContactedInput.sendKeys(expectedDateContacted);
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
        System.out.println("First row leads: " + firstRowLeads);
        Thread.sleep(2000);

    }


    public static void editLeads() throws InterruptedException {

        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRow));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath(linkEdit)).click();
        Thread.sleep(3000);

        // Lấy dữ liệu hiển thị
        actualStatus= driver.findElement(By.xpath(dropdownStatus)).getText().trim();
        actualSource = driver.findElement(By.xpath(dropdownSource)).getText().trim();
        actualAssigned = driver.findElement(By.xpath(dropdownAssigned)).getText().trim();
        actualTags = driver.findElement(By.xpath(inputEditTag)).getText().trim();
        actualName = driver.findElement(By.xpath(inputName)).getAttribute("value").trim();
        actualAddress = driver.findElement(By.xpath(inputAddress)).getText().trim();
        actualPosition = driver.findElement(By.xpath(inputPosition)).getAttribute("value").trim();
        actualCity = driver.findElement(By.xpath(inputCity)).getAttribute("value").trim();
        actualEmailAddress = driver.findElement(By.xpath(inputEmailAddress)).getAttribute("value").trim();
        actualState = driver.findElement(By.xpath(inputState)).getAttribute("value").trim();
        actualWebsite = driver.findElement(By.xpath(inputWebsite)).getAttribute("value").trim();
        actualCountry = driver.findElement(By.xpath(dropdownCountry)).getText().trim();
        actualPhone = driver.findElement(By.xpath(inputPhone)).getAttribute("value").trim();
        actualZipCode = driver.findElement(By.xpath(inputZipCode)).getAttribute("value").trim();
        actualLeadValue = driver.findElement(By.xpath(inputLeadValue)).getAttribute("value").trim();
        actualDefaultLanguage = driver.findElement(By.xpath(dropdownDefaultLanguage)).getText().trim();
        actualCompany = driver.findElement(By.xpath(inputCompany)).getAttribute("value").trim();
        actualDescription = driver.findElement(By.xpath(inputDescription)).getAttribute("value").trim();
      //  actualLastContacted = driver.findElement(By.xpath(inputLastContacted)).getAttribute("value").trim();

//        boolean actualLastContacted = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();
//
//        boolean actualPublic = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();



    }


    public static void verifyLeadData() throws InterruptedException {

        compareField("Status", expectedStatus, actualStatus);
        compareField("Name", expectedName, actualName);
        compareField("Source", expectedSource, actualSource);
        compareField("Assigned", expectedAssigned, actualAssigned);
        compareField("Tags", expectedTags, actualTags);
        compareField("Address", expectedAddress, actualAddress);
        compareField("Position", expectedPosition, actualPosition);
        compareField("City", expectedCity, actualCity);
        compareField("Email Address", expectedEmailAddress, actualEmailAddress);
        compareField("State", expectedState, actualState);
        compareField("Website", expectedWebsite, actualWebsite);
        compareField("Country", expectedCountry, actualCountry);
        compareField("Phone", expectedPhone, actualPhone);
        compareField("Zip Code", expectedZipCode, actualZipCode);
        compareField("Lead Value",  expectedLeadValue, actualLeadValue);
        compareField("Default Language", expectedDefaultLanguage, actualDefaultLanguage);
        compareField("Company", expectedCompany, actualCompany);
        compareField("Description", expectedDescription, actualDescription);
      //  compareField("Date Contacted", expectedDateContacted, actualLastContacted);

        Thread.sleep(2000);
    }

    private static void compareField(String fieldName, String expected, String actual) {
        if (expected == null) expected = "";
        if (actual == null) actual = "";

        if (!expected.equals(actual)) {
            System.out.println("❌ " + fieldName + " không khớp. Expected: [" + expected + "] | Actual: [" + actual + "]");
        } else {
            System.out.println("✅ " + fieldName + " khớp");
        }
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
        editLeads();
        verifyLeadData();
        closeDriver();
    }
}
