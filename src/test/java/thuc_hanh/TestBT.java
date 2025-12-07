package thuc_hanh;


import common.BaseTest;
import keywords.WebUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
/*
import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.alertErrorMessageEmail;
import static bt_locators.LocatorsLeadsCRM.alertErrorMessageRequired;
import static bt_locators.LocatorsLeadsCRM.buttonNewLead;
import static bt_locators.LocatorsLeadsCRM.buttonSave;
import static bt_locators.LocatorsLeadsCRM.checkboxPublic;
import static bt_locators.LocatorsLeadsCRM.dropdownAssigned;
import static bt_locators.LocatorsLeadsCRM.dropdownCountry;
import static bt_locators.LocatorsLeadsCRM.dropdownDefaultLanguage;
import static bt_locators.LocatorsLeadsCRM.dropdownSource;
import static bt_locators.LocatorsLeadsCRM.dropdownStatus;
import static bt_locators.LocatorsLeadsCRM.firstRowItemLeads;
import static bt_locators.LocatorsLeadsCRM.getValueSource;
import static bt_locators.LocatorsLeadsCRM.getValueStatus;
import static bt_locators.LocatorsLeadsCRM.headerAddNewLead;
import static bt_locators.LocatorsLeadsCRM.headerEditPage;
import static bt_locators.LocatorsLeadsCRM.iconClosePopupLeadDetail;
import static bt_locators.LocatorsLeadsCRM.inputAddress;
import static bt_locators.LocatorsLeadsCRM.inputCity;
import static bt_locators.LocatorsLeadsCRM.inputCompany;
import static bt_locators.LocatorsLeadsCRM.inputDescription;
import static bt_locators.LocatorsLeadsCRM.inputEditTag;
import static bt_locators.LocatorsLeadsCRM.inputEmailAddress;
import static bt_locators.LocatorsLeadsCRM.inputLastContacted;
import static bt_locators.LocatorsLeadsCRM.inputLeadValue;
import static bt_locators.LocatorsLeadsCRM.inputName;
import static bt_locators.LocatorsLeadsCRM.inputPhone;
import static bt_locators.LocatorsLeadsCRM.inputPosition;
import static bt_locators.LocatorsLeadsCRM.inputSearchAssigned;
import static bt_locators.LocatorsLeadsCRM.inputSearchCountry;
import static bt_locators.LocatorsLeadsCRM.inputSearchDefaultLanguage;
import static bt_locators.LocatorsLeadsCRM.inputSearchSource;
import static bt_locators.LocatorsLeadsCRM.inputSearchStatus;
import static bt_locators.LocatorsLeadsCRM.inputState;
import static bt_locators.LocatorsLeadsCRM.inputWebsite;
import static bt_locators.LocatorsLeadsCRM.inputZipCode;
import static bt_locators.LocatorsLeadsCRM.linkDelete;
import static bt_locators.LocatorsLeadsCRM.linkEdit;
import static bt_locators.LocatorsLeadsCRM.tabProfile;



 */
public class TestBT extends BaseTest {
/*
    String status;
    String source;
    String assigned;
    String tag;
    String leadName;
    String address;
    String position;
    String city;
    String emailAddress;
    String state;
    String website;
    String country;
    String phone;
    String zipCode;
    String leadValue;
    String language;
    String company;
    String description;
    String dateContacted;
    int flag;
    int flagEdit;

    public void verifyMenuLead() throws InterruptedException {

        WebUI.clickElement(driver, menuLeads);
        WebUI.clickElement(driver, iconLeadsSummary);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, headerLeadPage), "Không truy cập được vào trang Leads!");

        // So sánh text header lead có đúng với kết quả mk mong muốn hay k
        // softAssert.assertEquals(headerLeadPage, "Leads Summary", "Header Leads is not correct");

    }


    public void verifyBtnAddNewLead() throws InterruptedException {

        WebUI.clickElement(driver, buttonNewLead);
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, headerAddNewLead), "Mở popup Add New Lead không thành công");

        // So sánh header có đúng với kết quả mk mong muốn hay k
        //    softAssert.assertEquals(headerAddNewLead, "Add new lead", "Header Add new lead is not correct");

    }


    public static void fillDataLeads(String status, String source, String assigned, String tag, String name, String address, String position,
                                   String city, String emailAddress, String state, String website, String country, String phone, String zipCode,
                                   String leadValue, String language, String company, String description, String dateContacted, int flag, int flagEdit) throws InterruptedException {


        WebUI.clickElement(driver, dropdownStatus);
        WebUI.setTextElement(driver, inputSearchStatus, status);
        WebUI.clickElement(driver, LocatorsLeadsCRM.getValueStatus(status));


        WebUI.clickElement(driver, dropdownSource);
        WebUI.setTextElement(driver, inputSearchSource, source);
        WebUI.clickElement(driver, LocatorsLeadsCRM.getValueSource(source));

        WebUI.clickElement(driver, dropdownAssigned);
        WebUI.setTextElement(driver, inputSearchAssigned, assigned);
        WebUI.clickElement(driver, LocatorsLeadsCRM.getValueAssigned(assigned));

        if (flagEdit == 1) {
            WebUI.clickElement(driver, iconCloseTag);
            WebUI.clearTextElement(driver, inputName);
            WebUI.clearTextElement(driver, inputAddress);
            WebUI.clearTextElement(driver, inputPosition);
            WebUI.clearTextElement(driver, inputCity);
            WebUI.clearTextElement(driver, inputEmailAddress);
            WebUI.clearTextElement(driver, inputState);
            WebUI.clearTextElement(driver, inputWebsite);
            WebUI.clearTextElement(driver, inputPhone);
            WebUI.clearTextElement(driver, inputZipCode);
            WebUI.clearTextElement(driver, inputLeadValue);
            WebUI.clearTextElement(driver, inputCompany);
            WebUI.clearTextElement(driver, inputDescription);
            WebUI.clearTextElement(driver, inputLastContacted);

           WebUI.clickElement(driver, labelPhone);
           WebUI.clickElement(driver, labelPhone);

            WebUI.scrollAtBottom(driver, dropdownStatus);

            WebUI.scrollAtBottom(driver, buttonSave);

            Thread.sleep(1000);
            WebUI.clickElement(driver, inputTag);

        }


        WebUI.setTextAndKeyElement(driver, inputTag,tag, Keys.ENTER);
        Thread.sleep(500);
        WebUI.clickElement(driver, labelTag);
        WebUI.clickElement(driver, labelTag);

        WebUI.setTextElement(driver, inputName, name);
        WebUI.setTextElement(driver, inputAddress, address);
        WebUI.setTextElement(driver, inputPosition, position);
        WebUI.setTextElement(driver, inputCity, city);
        WebUI.setTextElement(driver, inputEmailAddress, emailAddress);
        WebUI.setTextElement(driver, inputState, state);
        WebUI.setTextElement(driver, inputWebsite, website);

        WebUI.clickElement(driver, dropdownCountry);
        WebUI.setTextElement(driver, inputSearchCountry, country);
        WebUI.clickElement(driver, LocatorsLeadsCRM.getValueCountry(country));

        WebUI.setTextElement(driver, inputPhone, phone);
        WebUI.setTextElement(driver, inputZipCode, zipCode);
        WebUI.setTextElement(driver, inputLeadValue, leadValue);

        WebUI.clickElement(driver, dropdownDefaultLanguage);
        WebUI.setTextElement(driver, inputSearchDefaultLanguage, language);
        WebUI.clickElement(driver, LocatorsLeadsCRM.getValueDefaultLanguage(language));

        WebUI.setTextElement(driver, inputCompany, company);
        WebUI.setTextElement(driver, inputDescription, description);


        WebUI.clickElement(driver, labelCheckboxPublic);

        if (flagEdit == 0) {
            WebUI.clickElement(driver, labelCheckboxContactedToday);
            WebUI.setTextElement(driver, inputDateContacted, dateContacted);
            WebUI.clickElement(driver, labelPhone);
            WebUI.clickElement(driver,labelPhone);
        } else {
            WebUI.clearTextElement(driver, inputLastContacted);
            WebUI.setTextElement(driver, inputLastContacted, dateContacted);
            WebUI.clickElement(driver,labelPhone);
            WebUI.clickElement(driver,labelPhone);
        }

        List<WebElement> errorsRequired = WebUI.getWebElements(driver, alertErrorMessageRequired);

        //  Nếu tìm thấy lỗi (>0) thì lấy text ra in vào log
        if (errorsRequired.size() > 0) {
            String errorMsg = "";
            // Duyệt qua tất cả các lỗi tìm thấy
            for (WebElement err : errorsRequired) {
                errorMsg = errorMsg + err.getText();
            }
            Assert.fail("FAILED: Save không thành công! Nội dung lỗi: " + errorMsg);
        }
     //   Thread.sleep(1000);
    }

    public static void verifyEmailResult(boolean expectValid, String expectedErrorMsg) {
       // List<WebElement> checkErrorEmail = driver.findElements(By.xpath(alertErrorMessageEmail));

        List<WebElement> checkErrorEmail = WebUI.getWebElements(driver, alertErrorMessageEmail);
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

    public void clickIconClosePopupLeadDetail(String name) throws InterruptedException {
        if (flagEdit == 0) {
            WebUI.waitForElementNotVisible(driver, addLeadSuccessMessage);
        } else {
            WebUI.waitForElementNotVisible(driver, updateLeadSuccessMessage);
        }
        WebUI.scrollAtTop(driver, LocatorsLeadsCRM.iconClosePopupLeadDetail(name));
//        Thread.sleep(1000);
        WebUI.clickElement(driver, LocatorsLeadsCRM.iconClosePopupLeadDetail(name));
     //   Thread.sleep(1000);
    }



    public static void searchLeads(String leadsName) throws InterruptedException {

        WebUI.clearTextElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, leadsName);

        // Check xem có tìm thấy dòng nào không
    //    List<WebElement> rows = driver.findElements(By.xpath(firstRowItemLeads));

        List<WebElement> rows = WebUI.getWebElements(driver, firstRowItemLeads);
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Lead vừa tạo trong danh sách!");

        System.out.println("Đã tìm thấy Lead search: " + rows.get(0).getText());
       // Thread.sleep(1000);

    }


    public static void compareFieldAttribute(WebDriver driver, String expectedValue, By by, String attributeType) {
        String actual = WebUI.getElementAttribute(driver, by, attributeType);
        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual
        );
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
      //  WebElement firstRow = driver.findElement(By.xpath(LocatorsLeadsCRM.firstRow));
        WebElement firstRow = WebUI.getWebElement(driver, LocatorsLeadsCRM.firstRow);
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(2000);

        //driver.findElement(By.xpath(linkEdit)).click();
        WebUI.clickElement(driver, linkEdit);
        //Thread.sleep(2000);


        // verify đã vào được màn Edit hay chưa
        List<WebElement> profileTabs = WebUI.getWebElements(driver, tabProfile);
      //  List<WebElement> profileTabs = driver.findElements(By.xpath(tabProfile));
        Assert.assertTrue(profileTabs.size() > 0, "FAILED: Không tìm thấy tab Profile, chưa vào được màn hình Edit Lead.");


        //Verify có vào đúng màn Edit có Tiêu đề edit chứa tên Lead mong muốn theo name
       // String actualTitledit = driver.findElement(By.xpath(headerEditPage)).getText();
//        String actualTitledit = WebUI.getWebElement(driver, headerEditPage).getText();
//        System.out.println("Tiêu đề popup: " + actualTitledit);
//        Assert.assertTrue(actualTitledit.contains(name), "FAILED: Tiêu đề popup không chứa tên Lead! Mở sai pop-up Lead edit hoặc chưa mở được popup edit.");


        compareFieldAttribute(driver, status, dropdownStatus, "title");
        compareFieldAttribute(driver, source, dropdownSource, "title");
        compareFieldAttribute(driver, assigned, dropdownAssigned, "title");
       // compareFieldAttribute(driver, tag, inputEditTag, "value");
        compareFieldAttribute(driver, name, inputName, "value");
        compareFieldAttribute(driver, address, inputAddress, "value");
        compareFieldAttribute(driver, position, inputPosition, "value");
        compareFieldAttribute(driver, city, inputCity, "value");
        compareFieldAttribute(driver, emailAddress, inputEmailAddress, "value");
        compareFieldAttribute(driver, state, inputState, "value");
        compareFieldAttribute(driver, website, inputWebsite, "value");
        compareFieldAttribute(driver, country, dropdownCountry, "title");
        compareFieldAttribute(driver, phone, inputPhone, "value");
        compareFieldAttribute(driver, zipCode, inputZipCode, "value");
        compareFieldAttribute(driver, leadValue + ".00", inputLeadValue, "value");
        compareFieldAttribute(driver, language, dropdownDefaultLanguage, "title");
        compareFieldAttribute(driver, company, inputCompany, "value");
        compareFieldAttribute(driver, description, inputDescription, "value");
        compareFieldAttribute(driver, dateContacted, inputLastContacted, "value");
        //verifyCheckboxSelected(checkboxPublic);


    }



    public void clickButtonDelete(String leadName) throws InterruptedException {


        WebElement firstRowDelete = WebUI.getWebElement(driver, firstRow);
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRowDelete).perform();
        Thread.sleep(3000);

        WebUI.clickElement(driver, linkDelete);

    }

    public void confirmAlertDelete() throws InterruptedException {
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public void verifyAfterDeleteLead(String leadName) throws InterruptedException {

        WebUI.clearTextElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, leadName);
        Assert.assertFalse(WebUI.checkExistsElement(driver, LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)), "Xóa Lead không thành công");

        //Assert.assertFalse(checkExistsElement(LocatorsLeadsCRM.getFirstRowItemLeadName(leadName)), "Xóa Lead không thành công");
        Thread.sleep(1000);
        System.out.println("Không tìm thấy Lead '" + leadName + "' trong kết quả tìm kiếm.");
    }

    public void clickButtonSave() throws InterruptedException {
        //driver.findElement(By.xpath(buttonSave)).click();
        WebUI.scrollAtBottom(driver, buttonSave);
        WebUI.clickElement(driver, buttonSave);
      Thread.sleep(1000);
    }



    @Test(priority = 1)
    public void testAddAndVerifyLead() throws InterruptedException{
        TestBT testBT = new TestBT();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 1";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi1@gmail.com";
        testBT.state = "Hà Nội";
        testBT.website = "htester.com.vn";
        testBT.country = "Vietnam";
        testBT.phone = "0965898989";
        testBT.zipCode = "0001";
        testBT.leadValue = "12345";
        testBT.language = "Vietnamese";
        testBT.company = "NODO JSC";
        testBT.description = "htest add new lead";
        testBT.dateContacted = "10-11-2025 00:00:00";
        testBT.flag = 1;
        testBT.flagEdit = 0;

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        verifyEmailResult(true, "");
        clickButtonSave();
        clickIconClosePopupLeadDetail(testBT.leadName);
        searchLeads(testBT.leadName);
    }


    @Test(priority = 2)
    public void testVerifyEditLead() throws InterruptedException{
        TestBT testBT = new TestBT();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 2";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi2@gmail.com";
        testBT.state = "Hà Nội";
        testBT.website = "htester.com.vn";
        testBT.country = "Vietnam";
        testBT.phone = "0965898989";
        testBT.zipCode = "0001";
        testBT.leadValue = "12345";
        testBT.language = "Vietnamese";
        testBT.company = "NODO JSC";
        testBT.description = "htest add new lead";
        testBT.dateContacted = "10-11-2025 00:00:00";
        testBT.flag = 1;
        testBT.flagEdit = 0;

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        verifyEmailResult(true, "");
        clickButtonSave();
        clickIconClosePopupLeadDetail(testBT.leadName);
        searchLeads(testBT.leadName);

        verifyEditLead(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted);
        Thread.sleep(2000);

    }


    @Test(priority = 3)
    public void testEditLead() throws Exception {
        TestBT testBT = new TestBT();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 3";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi3@gmail.com";
        testBT.state = "Hà Nội";
        testBT.website = "htester.com.vn";
        testBT.country = "Vietnam";
        testBT.phone = "0965898989";
        testBT.zipCode = "0001";
        testBT.leadValue = "12345";
        testBT.language = "Vietnamese";
        testBT.company = "NODO JSC";
        testBT.description = "htest add new lead";
        testBT.dateContacted = "10-11-2025 00:00:00";
        testBT.flag = 1;
        testBT.flagEdit = 0;

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        verifyEmailResult(true, "");
        clickButtonSave();
        clickIconClosePopupLeadDetail(testBT.leadName);
        searchLeads(testBT.leadName);

        verifyEditLead(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted);
        Thread.sleep(2000);

        testBT.status = "Active";
        testBT.source = "Facebook";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 3";
        testBT.address = "Thanh Oai";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi3@gmail.com";
        testBT.state = "Hà Nội";
        testBT.website = "htester.com.vn";
        testBT.country = "Vietnam";
        testBT.phone = "0965898989";
        testBT.zipCode = "0001";
        testBT.leadValue = "12345";
        testBT.language = "Vietnamese";
        testBT.company = "NODO JSC";
        testBT.description = "htest add new lead";
        testBT.dateContacted = "10-11-2025 00:00:00";
        testBT.flag = 0;
        testBT.flagEdit = 1;

//        String status = "Active";
//        String source = "Facebook";
//        String address = "Thanh Oai";

       // editLead(statusEdit, sourceEdit, leadName, addressEdit);
        fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);
        Thread.sleep(2000);
        clickButtonSave();
       clickIconClosePopupLeadDetail(testBT.leadName);
        searchLeads(testBT.leadName);

    }


    @Test(priority = 4)
    public void testDeleteLead() throws InterruptedException{
        TestBT testBT = new TestBT();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 4";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi4@gmail.com";
        testBT.state = "Hà Nội";
        testBT.website = "htester.com.vn";
        testBT.country = "Vietnam";
        testBT.phone = "0965898989";
        testBT.zipCode = "0001";
        testBT.leadValue = "12345";
        testBT.language = "Vietnamese";
        testBT.company = "NODO JSC";
        testBT.description = "htest add new lead";
        testBT.dateContacted = "10-11-2025 00:00:00";
        testBT.flag = 1;
        testBT.flagEdit = 0;

        //click menu Lead
        verifyMenuLead();

        //click btn addnewLead
        verifyBtnAddNewLead();

        fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        verifyEmailResult(true, "");
        clickButtonSave();
        clickIconClosePopupLeadDetail(testBT.leadName);
        searchLeads(testBT.leadName);

        Thread.sleep(2000);
        clickButtonDelete(testBT.leadName);
        confirmAlertDelete();
        verifyAfterDeleteLead(testBT.leadName);

        //  deleteLead(leadName);
        Thread.sleep(2000);
    }



 */

}
