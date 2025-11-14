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

    public static void openNewLeadsPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.buttonNewLead)).click();
    }


    public static void addNewLeads(String status, String source, String assigned, String tag, String name, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted) throws InterruptedException {
        openNewLeadsPage();
        Thread.sleep(1000);

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
        driver.findElement(By.xpath(LocatorsLeadsCRM.menuLeads)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);

        String firstRowLeads = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRowItemLeads)).getText();
        System.out.println("First row leads: " + firstRowLeads);
        Thread.sleep(2000);

    }

    public boolean verifyLeadData(
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

        boolean isSame = true;

        // Ví dụ: status là dropdown -> getText()
        String actualStatus = driver.findElement(By.xpath(dropdownStatus)).getText();
        isSame = compareField("Status", status, actualStatus) && isSame;

        // source cũng là dropdown
        String actualSource = driver.findElement(By.xpath(dropdownSource)).getText();
        isSame = compareField("Source", source, actualSource) && isSame;

        // assigned là dropdown
        String actualAssigned = driver.findElement(By.xpath(dropdownAssigned)).getText();
        isSame = compareField("Assigned", assigned, actualAssigned) && isSame;

        // tag là textbox -> getAttribute("value")
        String actualTag = driver.findElement(By.xpath(inputEditTag)).getText();
        isSame = compareField("Tag", tag, actualTag) && isSame;

        // name – textbox
        String actualName = driver.findElement(By.xpath(inputName)).getAttribute("value");
        isSame = compareField("Name", name, actualName) && isSame;

        String actualAddress = driver.findElement(By.xpath(inputAddress)).getText();
        isSame = compareField("Address", address, actualAddress) && isSame;

        // position – textbox
        String actualPosition = driver.findElement(By.xpath(inputPosition)).getAttribute("value");
        isSame = compareField("Position", position, actualPosition) && isSame;

        // city – textbox
        String actualCity = driver.findElement(By.xpath(inputCity)).getAttribute("value");
        isSame = compareField("City", city, actualCity) && isSame;

        // email – textbox
        String actualEmail = driver.findElement(By.xpath(inputEmailAddress)).getAttribute("value");
        isSame = compareField("Email", emailAddress, actualEmail) && isSame;

        // state – textbox
        String actualState = driver.findElement(By.xpath(inputState)).getAttribute("value");
        isSame = compareField("State", state, actualState) && isSame;

        // website – textbox
        String actualWebsite = driver.findElement(By.xpath(inputWebsite)).getAttribute("value");
        isSame = compareField("Website", website, actualWebsite) && isSame;

        // country – dropdown
        String actualCountry = driver.findElement(By.xpath(dropdownCountry)).getText();
        isSame = compareField("Country", country, actualCountry) && isSame;

        // phone – textbox
        String actualPhone = driver.findElement(By.xpath(inputPhone)).getAttribute("value");
        isSame = compareField("Phone", phone, actualPhone) && isSame;

        // zipCode – textbox
        String actualZip = driver.findElement(By.xpath(inputZipCode)).getAttribute("value");
        isSame = compareField("Zip Code", zipCode, actualZip) && isSame;

        // leadValue – textbox
        String actualLeadValue = driver.findElement(By.xpath(inputLeadValue)).getAttribute("value");
        isSame = compareField("Lead Value", leadValue, actualLeadValue) && isSame;

        // language – textbox
        String actualLanguage = driver.findElement(By.xpath(dropdownDefaultLanguage)).getText();
        isSame = compareField("Language", language, actualLanguage) && isSame;

        // company – textbox
        String actualCompany = driver.findElement(By.xpath(inputCompany)).getAttribute("value");
        isSame = compareField("Company", company, actualCompany) && isSame;

        // description – textarea
        String actualDescription = driver.findElement(By.xpath(inputDescription)).getAttribute("value");
        isSame = compareField("Description", description, actualDescription) && isSame;

        //  dateContacted – textbox/date input
        String actualDateContacted = driver.findElement(By.xpath(LocatorsLeadsCRM.inputDateContacted)).getAttribute("value");
        isSame = compareField("Date Contacted", dateContacted, actualDateContacted) && isSame;


        return isSame;
    }

    private boolean compareField(String fieldName, String expected, String actual) {
        if (expected == null) expected = "";
        if (actual == null) actual = "";

        if (!expected.equals(actual)) {
            System.out.println("❌" + fieldName + " không khớp. Expected: [" + expected + "] | Actual: [" + actual + "]");
            return false;
        } else {
            System.out.println("✅" + fieldName + " khớp");
            return true;
        }
    }

    @Test
    public void testAddAndVerifyLead() throws InterruptedException{
        openNewLeadsPage();

        AddNewLeads addLead = new AddNewLeads();

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
        String dateContacted = "10-11-2025";

        addLead.addNewLeads(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        searchLeads("Yến Nhi 7");

        boolean ok = addLead.verifyLeadData(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

    }

}
