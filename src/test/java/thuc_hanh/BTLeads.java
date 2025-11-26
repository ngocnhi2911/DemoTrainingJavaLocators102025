package thuc_hanh;

import bt_locators.LocatorsLeadsCRM;
import common.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static bt_locators.LocatorsLeadsCRM.*;

public class BTLeads extends BaseTest {

    public void verifyMenuLead() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(menuLeads)).click();
        Thread.sleep(2000);
        // Verify menu Lead
        // Sau khi vào menu lead, check xem có hiển thị header Leads không?
        driver.findElement(By.xpath(iconLeadsSummary)).click();
        Thread.sleep(1000);

      //  List<WebElement> checkHeaderLeadPage= driver.findElements(By.xpath(headerLeadPage));
        Assert.assertTrue(checkExistsElement(headerLeadPage), "Không truy cập được vào trang Leads!");

        // So sánh text header lead có đúng với kết quả mk mong muốn hay k
       // softAssert.assertEquals(headerLeadPage, "Leads Summary", "Header Leads is not correct");

    }


    public void verifyBtnAddNewLead() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(buttonNewLead)).click();
        Thread.sleep(1000);
        Assert.assertTrue(checkExistsElement(headerAddNewLead), "Mở popup Add New Lead không thành công");

        // So sánh header có đúng với kết quả mk mong muốn hay k
    //    softAssert.assertEquals(headerAddNewLead, "Add new lead", "Header Add new lead is not correct");

    }


    public static void addNewLeads(String status, String source, String assigned, String tag, String name, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted) throws InterruptedException {


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownStatus)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchStatus)).sendKeys(status);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.getValueStatus(status))).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownSource)).click();  // Source
        Thread.sleep(1000);
        driver.findElement(By.xpath(inputSearchSource)).sendKeys(source);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.getValueSource(source))).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownAssigned)).click();   // Assigned
        Thread.sleep(1000);
        driver.findElement(By.xpath(inputSearchAssigned)).sendKeys(assigned);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.getValueAssigned(assigned))).click();
        Thread.sleep(1000);

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
//        driver.findElement(By.xpath(iconCloseTag)).click();
//        driver.findElement(By.xpath(iconCloseTag)).click();
        Thread.sleep(1000);


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


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(inputSearchCountry)).sendKeys(country);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.getValueCountry(country))).click();
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.inputPhone)).sendKeys(phone);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputZipCode)).sendKeys(zipCode);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputLeadValue)).sendKeys(leadValue);
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsLeadsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(inputSearchDefaultLanguage)).sendKeys(language);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.getValueDefaultLanguage(language))).click();
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
        Thread.sleep(1000);

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
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadsName);
        Thread.sleep(1000);

        // Check xem có tìm thấy dòng nào không
        List<WebElement> rows = driver.findElements(By.xpath(firstRowItemLeads));
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Lead vừa tạo trong danh sách!");

        System.out.println("Đã tìm thấy Lead search: " + rows.get(0).getText());
        Thread.sleep(1000);

    }

    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeType) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeType);
        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "FAILED: Checkbox [" + checked + "] chưa được chọn.");
    }


    public static void verifyEditLead(
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
        Thread.sleep(2000);

        driver.findElement(By.xpath(linkEdit)).click();
        Thread.sleep(2000);


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

    public static void pressCombo(int... keys) throws Exception {
        Robot r = new Robot();
        // Nhấn giữ tất cả phím
        for (int key : keys) {
            r.keyPress(key);
        }
        // Nhả tất cả phím
        for (int key : keys) {
            r.keyRelease(key);
        }
    }

    public static void editLead (String statusEdit, String sourceEdit, String name, String addressEdit) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();

        actions.click(driver.findElement(By.xpath(dropdownStatus))).perform();
        Thread.sleep(200);
        actions.sendKeys(driver.findElement(By.xpath(inputSearchStatus)), statusEdit).perform();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath(getValueStatus(statusEdit)))).perform();
        Thread.sleep(2000);


        actions.click(driver.findElement(By.xpath(dropdownSource))).perform();
        Thread.sleep(200);
        actions.sendKeys(driver.findElement(By.xpath(inputSearchSource)), sourceEdit).perform();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath(getValueSource(sourceEdit)))).perform();
        Thread.sleep(2000);




//        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
//        pressCombo(KeyEvent.VK_DELETE);

        WebElement elementName = driver.findElement(By.xpath(inputName));
        actions.click(elementName).perform();
        Thread.sleep(1000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
        actions.sendKeys(elementName, name).perform();
        Thread.sleep(2000);


        WebElement elementAddress= driver.findElement(By.xpath(inputAddress));
        actions.click(elementAddress).perform();
        Thread.sleep(1000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
        //  elementHourlyRate.clear();
        actions.sendKeys(elementAddress, addressEdit).perform();
        Thread.sleep(1000);

    }


    public void clickButtonDelete(String leadName) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRow));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath(linkDelete)).click();
        Thread.sleep(2000);
    }

    public void confirmAlertDelete() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public void verifyAfterDeleteLead(String leadName) throws InterruptedException {
//        driver.findElement(By.xpath(LocatorLeadPage.inputSearchLeads)).sendKeys(leadName);
//        Thread.sleep(1000);
//        Assert.assertFalse(checkExistsElement(LocatorLeadPage.getFirstRowItemLeadName(leadName)), "Xóa Lead không thành công");
//        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearch)).sendKeys(leadName);
        Thread.sleep(2000);

        Assert.assertFalse(checkExistsElement(LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)), "Xóa Lead không thành công");
        Thread.sleep(1000);
        System.out.println("Không tìm thấy Lead '" + leadName + "' trong kết quả tìm kiếm.");
    }

    public void clickButtonSave() throws InterruptedException {
        driver.findElement(By.xpath(buttonSave)).click();
        Thread.sleep(3000);
    }


    public void clickIconClosePopupLeadDetail(String leadName) throws InterruptedException {
        driver.findElement(By.xpath(iconClosePopupLeadDetail(leadName))).click();
        Thread.sleep(1000);
    }


    @Test(priority = 1)
    public void testAddAndVerifyLead() throws InterruptedException{
        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String leadName = "Yến Nhi 1";
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

       addNewLeads(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
       Thread.sleep(2000);

        verifyEmailResult(true, "");

        searchLeads(leadName);

    }

    @Test(priority = 2)
    public void testVerifyEditLead() throws InterruptedException{
        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String leadName = "Yến Nhi 2";
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

        addNewLeads(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

        verifyEmailResult(true, "");
        Thread.sleep(2000);

        searchLeads(leadName);
        Thread.sleep(2000);

        verifyEditLead(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void testEditLead() throws Exception {
        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String leadName = "Yến Nhi 2";
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

        addNewLeads(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

        verifyEmailResult(true, "");
        Thread.sleep(2000);

        searchLeads(leadName);
        Thread.sleep(2000);

        verifyEditLead(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

        String statusEdit = "Active";
        String sourceEdit = "Facebook";
        String addressEdit = "Thanh Oai";

        editLead(statusEdit, sourceEdit, leadName, addressEdit);
        Thread.sleep(3000);
        clickButtonSave();
        clickIconClosePopupLeadDetail(leadName);
        searchLeads(leadName);

    }

    @Test(priority = 4)
    public void testDeleteLead() throws InterruptedException{
        //openNewLeadsPage();

        //  AddNewLeads addLead = new AddNewLeads();

        String status = "Active";
        String source = "Google";
        String assigned = "Admin Anh Tester";
        String tag = "JSC_NEW";
        String leadName = "Yến Nhi 3";
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

        addNewLeads(status, source, assigned, tag, leadName, address, position, city,
                emailAddress, state, website, country, phone, zipCode, leadValue, language,
                company, description, dateContacted);
        Thread.sleep(2000);

        searchLeads(leadName);
        Thread.sleep(2000);
        clickButtonDelete(leadName);
        confirmAlertDelete();
        verifyAfterDeleteLead(leadName);

      //  deleteLead(leadName);
        Thread.sleep(2000);
    }


}
