package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import common.BaseTest;
import login_crm.LoginCRM;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.getValueCountry;

public class AddNewLeads extends BaseTest {

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
        // Verify menu Lead
        // Sau khi vào menu lead, check xem có hiển thị header Leads không?
        driver.findElement(By.xpath(iconLeadsSummary)).click();
        Thread.sleep(1000);

        List<WebElement> checkHeaderLeadPage= driver.findElements(By.xpath(headerLeadPage));
        System.out.println("checkHeaderLeadPage: " + checkHeaderLeadPage.size());
        Assert.assertTrue(checkHeaderLeadPage.size() > 0, "Không truy cập được vào trang Leads!");

        // So sánh text header lead có đúng với kết quả mk mong muốn hay k
        String headerLeadsText = driver.findElement(By.xpath(headerLeadPage)).getText();
        softAssert.assertEquals(headerLeadsText, "Leads Summary", "Header Leads is not correct");

    }

    public static void verifyBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(buttonNewLead)).click();
        Thread.sleep(1000);
     //   verifyDisplay(headerAddNewLead, "Mở pop-up Add new lead thành công", "FAILED!!! Không mở được pop-up Add new lead");

        List<WebElement> checkHeaderAddNewLeadPage= driver.findElements(By.xpath(headerAddNewLead));
        System.out.println("checkHeaderAddNewLeadPage: " + checkHeaderAddNewLeadPage.size());
        Assert.assertTrue(checkHeaderAddNewLeadPage.size() > 0, "Không mở được popup Add new Lead !");

        // So sánh header có đúng với kết quả mk mong muốn hay k
        String headerAddNewLeadsText = driver.findElement(By.xpath(headerAddNewLead)).getText();
        softAssert.assertEquals(headerAddNewLeadsText, "Add new lead", "Header Add new lead is not correct");

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

        // Check sau khi save có lỗi required không
       List<WebElement> errorsRequired = driver.findElements(By.xpath(alertErrorMessageRequired));

        //  Nếu tìm thấy lỗi (>0) thì lấy text ra in vào log
        if (errorsRequired.size() > 0) {
            String errorMsg = "";
            // Duyệt qua tất cả các lỗi tìm thấy
            for (WebElement err : errorsRequired) {
                errorMsg = errorMsg + err.getText();
            }
            Assert.fail("FAILED: Save không thành công! Nội dung lỗi: " + errorMsg);
        }
        Thread.sleep(3000);
    }

    public static void verifyEmailResult(boolean expectValid, String expectedErrorMsg) {
        List<WebElement> checkErrorEmail = driver.findElements(By.xpath(alertErrorMessageEmail));
        System.out.println("checkErrorEmail.size(): " + checkErrorEmail.size());

        if (expectValid) {
            Assert.assertEquals(checkErrorEmail.size(), 0, "Không thể thêm mới vì Email lỗi !!! Vui lòng kiểm tra lại");
        } else {
            // Case: email SAI / TRÙNG → PHẢI có lỗi
            Assert.assertTrue(checkErrorEmail.size() > 0, "Nhập email sai/trùng nhưng không hiển thị lỗi Email !!!");

            String actualMsg = checkErrorEmail.get(0).getText().trim();
            Assert.assertTrue(actualMsg.contains(expectedErrorMsg),
                    "Thông báo lỗi email không đúng. Expected: " + expectedErrorMsg + " | Actual: " + actualMsg);
        }
    }


    public static void searchLeads(String leadsName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsLeadsCRM.iconCloseProfile)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);

        // Check xem có tìm thấy dòng nào không
        List<WebElement> rows = driver.findElements(By.xpath(firstRowItemLeads));
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Lead vừa tạo trong danh sách!");

        System.out.println("Đã tìm thấy Lead search: " + rows.get(0).getText());
        Thread.sleep(2000);

    }

    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeType) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeType);
        softAssert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "FAILED: Checkbox [" + checked + "] chưa được chọn.");
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


        // verify đã vào được màn Edit hay chưa
        List<WebElement> profileTabs = driver.findElements(By.xpath(tabProfile));
        Assert.assertTrue(profileTabs.size() > 0, "FAILED: Không tìm thấy tab Profile, chưa vào được màn hình Edit Lead.");


        //Verify có vào đúng màn Edit có Tiêu đề edit chứa tên Lead mong muốn theo name
        String actualTitledit = driver.findElement(By.xpath(headerEditPage)).getText();
        System.out.println("Tiêu đề popup: " + actualTitledit);
        Assert.assertTrue(actualTitledit.contains(name), "FAILED: Tiêu đề popup không chứa tên Lead! Mở sai pop-up Lead edit hoặc chưa mở được popup edit.");


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


    public static void deleteLead(String leadsName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRow));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();

        Thread.sleep(3000);

        driver.findElement(By.xpath(linkDelete)).click();
        Thread.sleep(3000);

        //Khởi tạo class Alert
        Alert alert1 = driver.switchTo().alert();
        //Dùng hàm accept() để xác nhận Alert (tương ứng click vào nút OK)
        alert1.accept(); // chấm hàm để sử dụng
        Thread.sleep(3000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(2000);

        List<WebElement> actualResults = driver.findElements(By.xpath(firstRowItemLeads));
        Assert.assertEquals(actualResults.size(), 0, "FAILED: Lead vẫn tìm thấy sau khi xóa. Số lượng kết quả: " + actualResults.size());

        System.out.println("Không tìm thấy Lead '" + leadsName + "' trong kết quả tìm kiếm.");


    }



    @Test(priority = 1)
    public void testAddAndVerifyLead() throws InterruptedException{
        //openNewLeadsPage();

      //  AddNewLeads addLead = new AddNewLeads();

        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String name = "Yến Nhi 1";
        String address = "Đại Linh";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "ngocnhi1@gmail.com";
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

        verifyEmailResult(true, "");


        searchLeads("Yến Nhi 1");
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void testEditLead() throws InterruptedException{
        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String name = "Yến Nhi 2";
        String address = "Đại Linh";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "ngocnhi2@gmail.com";
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

        verifyEmailResult(true, "");
        Thread.sleep(2000);

        searchLeads("Yến Nhi 2");
        Thread.sleep(2000);

        editLead(status, source, assigned, tag, name, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void testDeleteLead() throws InterruptedException{
        //openNewLeadsPage();

        //  AddNewLeads addLead = new AddNewLeads();

        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String name = "Yến Nhi 3";
        String address = "Đại Linh";
        String position = "Tester";
        String city = "Việt Nam";
        String emailAddress = "ngocnhi3@gmail.com";
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

        searchLeads("Yến Nhi 3");
        Thread.sleep(2000);

        deleteLead("Yến Nhi 3");
        Thread.sleep(2000);

    }


}
