package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import login_crm.LoginCRM;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.getValueCountry;

public class AddNewLeads extends LoginCRM {

//    public static void openNewLeadsPage() throws InterruptedException {
//        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLead)).click();
//    }

    public static void verifyDisplay(String field, String messageTrue, String messageFalse) {
        boolean check = driver.findElement(By.xpath(field)).isDisplayed();
        if (check) {
            System.out.println(messageTrue);
        } else {
            System.out.println(messageFalse);
        }
    }

    public static void verifyMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(menuLeads)).click();
        Thread.sleep(2000);
        verifyDisplay(headerLeadPage, "Đã tới trang Leads", "FAILED!!! Không truy cập được vào trang Leads");

    }

    public static void verifyBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(buttonNewLead)).click();
        Thread.sleep(1000);
        verifyDisplay(headerAddNewLead, "Mở pop-up Add new lead thành công", "FAILED!!! Không mở được pop-up Add new lead");

    }


    public static void addNewLeads(String status, String source, String assigned, String tag, String name, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted) throws InterruptedException {
//        openNewLeadsPage();
//        Thread.sleep(1000);

        //------------------- Xác định dropdown Status -- Cách 1---------------------------
        // B1. Click vào dropdown

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(1000);
        //B2.Tìm kiếm giá trị cần chọn và nhấn Enter
        // --> Trường hợp này khi tìm kiếm với giá trị sai --> nó vẫn chạy được nhưng kết quả là trống
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchStatus)).sendKeys(status, Keys.ENTER);
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 2: chỉ dùng khi giá trị mở dropdown ra là thấy-----------------------------

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSource)).click();  // Source
        Thread.sleep(1000);
        String xpathSource = getValueSource(source);
        WebElement xpsource = driver.findElement(By.xpath(xpathSource));
        xpsource.click();
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssigned)).click();   // Assigned
        Thread.sleep(1000);
        String xpathAssigned = getValueAssigned(assigned);
        WebElement xpassigned = driver.findElement(By.xpath(xpathAssigned));
        xpassigned.click();
        Thread.sleep(1000);


        // B1: Mở dropdown

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputTag)).click();  // Tag
        Thread.sleep(1000);
        // B2: Lấy danh sách tất cả các phần tử trong dropdown
        List<WebElement> allOptions = driver.findElements(By.xpath(LocatorsLeadsCRM.listdropdownTag));
        Thread.sleep(1000);
        // B3: Duyệt từng WebElement trong danh sách để tìm phần tử có text = "JSC_NEW"
        for (WebElement option : allOptions) {
            if (option.getText().equals(tag)) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputName)).sendKeys(name);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputAddress)).sendKeys(address);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPosition)).sendKeys(position);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCity)).sendKeys(city);
        Thread.sleep(1000);

//        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys("ngocyennhi2911@gmail.com");
//        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputEmailAddress)).sendKeys(emailAddress);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputState)).sendKeys(state);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputWebsite)).sendKeys(website);
        Thread.sleep(1000);


        //------------------- Xác định dropdown-- Cách 3-----------------------------
        // B1: Click mở dropdown Country

        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        // B2: Nhập từ khóa cần tìm vào ô search --> để lọc danh sách
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys(country);
        // B3: Tạo xpath tương ứng với giá trị muốn chọn
        String xpathCountry = getValueCountry(country);
        Thread.sleep(1000);
        // B4: Tìm phần tử tương ứng và click
        driver.findElement(By.xpath(xpathCountry)).click();
        Thread.sleep(1000);
        //-------------


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys(phone);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys(zipCode);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys(leadValue);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchDefaultLanguage)).sendKeys(language, Keys.ENTER);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputCompany)).sendKeys(company);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDescription)).sendKeys(description);
        Thread.sleep(1000);


        boolean expectedPublic = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).isSelected();
        if (expectedPublic == false) {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxPublic)).click();
        }
        Thread.sleep(1000);


        boolean expectedContanctedToday = driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).isSelected();
        if (expectedContanctedToday == true) {
            driver.findElement(By.xpath(LocatorsLeadsCRM.checkboxContactedToday)).click();
        }
        Thread.sleep(1000);

//        driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted)).sendKeys("08-11-2025 06:00");
//        Thread.sleep(1000);

//        // B1: Lấy thời gian hiện tại
//        LocalDateTime now = LocalDateTime.now();
//        // B2: Định dạng theo format của hệ thống
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//        String currentDateTime = now.format(formatter);
//        // B3: Gửi vào trường Date Contacted
//        dateContacted = currentDateTime;
        WebElement dateContactedInput = driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted));
        dateContactedInput.sendKeys(dateContacted);
        Thread.sleep(3000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonSave)).click();
        Thread.sleep(4000);
    }

    public static void searchLeads(String leadsName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.iconCloseProfile)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);

        String firstRowLeads = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRowItemLeads)).getText();
        System.out.println("First row leads: " + firstRowLeads);
        Thread.sleep(2000);

    }

    //Hàm so sánh giá trị đã thêm mới trong màn edit
    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        if (actual.trim().equalsIgnoreCase(expected.trim())) {
            System.out.println("Giá trị hiển thị đúng: " + actual);
        } else {
            System.out.println("FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
        }
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        if (checked) {
            System.out.println("Checkbox is selected: " + checked);
        } else {
            System.out.println("Checkbox is selected: " + checked);

        }
    }


    public static void editLead(
            String status, String source, String assigned, String tag,String name, String address,
            String position, String city, String emailAddress,
            String state, String website, String country, String phone,
            String zipCode, String leadValue, String language, String company,
            String description, String dateContacted
    ) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRow));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath(linkEdit)).click();
        Thread.sleep(3000);

        compareFieldAttribute(status, dropdownStatus, "title");
        compareFieldAttribute(source, dropdownSource, "title");
        compareFieldAttribute(assigned, dropdownAssigned, "title");
        compareFieldAttribute(tag, inputEditTag, "value");
        compareFieldAttribute(name, inputName, "value");
        compareFieldAttribute(address, inputAddress, "value");
        compareFieldAttribute(position, inputPosition, "value");
        compareFieldAttribute(city, inputCity, "value");
        compareFieldAttribute(emailAddress, inputEmailAddress, "value");
        compareFieldAttribute(state, inputState, "value");
        compareFieldAttribute(website, inputWebsite, "value");
        compareFieldAttribute(country, dropdownCountry, "title");
        compareFieldAttribute(phone, inputPhone, "value");
        compareFieldAttribute(zipCode, inputZipCode, "value");
        compareFieldAttribute(leadValue + ".00", inputLeadValue, "value");
        compareFieldAttribute(language, dropdownDefaultLanguage, "title");
        compareFieldAttribute(company, inputCompany, "value");
        compareFieldAttribute(description, inputDescription, "value");
        compareFieldAttribute(dateContacted, inputLastContacted, "value"); //hệ thống bug
        verifyCheckboxSelected(checkboxPublic);
    }

//    private boolean compareField(String fieldName, String expected, String actual) {
//        if (expected == null) expected = "";
//        if (actual == null) actual = "";
//
//        if (!expected.equals(actual)) {
//            System.out.println("❌" + fieldName + " không khớp. Expected: [" + expected + "] | Actual: [" + actual + "]");
//            return false;
//        } else {
//            System.out.println("✅" + fieldName + " khớp");
//            return true;
//        }
//    }

    @Test
    public void testAddAndVerifyLead() throws InterruptedException{
        //openNewLeadsPage();

      //  AddNewLeads addLead = new AddNewLeads();

        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String name = "Yến Nhi 7";
        String address = "Đại Linh";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "ngocnhi7@gmail.com";
        String state = "Hà Nội";
        String website = "htester.com.vn";
        String country = "Vietnam";
        String phone = "0965898989";
        String zipCode = "0001";
        String leadValue = "12345";
        String language = "Vietnamese";
        String company = "NODO JSC";
        String description = "htest add new lead";
        String dateContacted = "10-11-2025 00:00:00";

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

       addNewLeads(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
       Thread.sleep(2000);

        searchLeads("Yến Nhi 7");
        Thread.sleep(2000);
    }

    @Test
    public void testEditLead() throws InterruptedException{
        //openNewLeadsPage();

        //  AddNewLeads addLead = new AddNewLeads();

        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String name = "Yến Nhi 10";
        String address = "Đại Linh";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "ngocnhi10@gmail.com";
        String state = "Hà Nội";
        String website = "htester.com.vn";
        String country = "Vietnam";
        String phone = "0965898989";
        String zipCode = "0001";
        String leadValue = "12345";
        String language = "Vietnamese";
        String company = "NODO JSC";
        String description = "htest add new lead";
        String dateContacted = "10-11-2025 00:00:00";

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        addNewLeads(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

        searchLeads("Yến Nhi 10");
        Thread.sleep(2000);

        editLead(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

    }

}
