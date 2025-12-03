
package pages;

import bt_locators.LocatorsLeadsCRM;
import common.BasePage;
import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.addLeadSuccessMessage;
import static bt_locators.LocatorsLeadsCRM.alertErrorMessageEmail;
import static bt_locators.LocatorsLeadsCRM.alertErrorMessageRequired;
import static bt_locators.LocatorsLeadsCRM.buttonSave;
import static bt_locators.LocatorsLeadsCRM.dropdownAssigned;
import static bt_locators.LocatorsLeadsCRM.dropdownCountry;
import static bt_locators.LocatorsLeadsCRM.dropdownDefaultLanguage;
import static bt_locators.LocatorsLeadsCRM.dropdownSource;
import static bt_locators.LocatorsLeadsCRM.dropdownStatus;
import static bt_locators.LocatorsLeadsCRM.firstRow;
import static bt_locators.LocatorsLeadsCRM.firstRowItemLeads;
import static bt_locators.LocatorsLeadsCRM.iconCloseTag;
import static bt_locators.LocatorsLeadsCRM.inputAddress;
import static bt_locators.LocatorsLeadsCRM.inputCity;
import static bt_locators.LocatorsLeadsCRM.inputCompany;
import static bt_locators.LocatorsLeadsCRM.inputDateContacted;
import static bt_locators.LocatorsLeadsCRM.inputDescription;
import static bt_locators.LocatorsLeadsCRM.inputEmailAddress;
import static bt_locators.LocatorsLeadsCRM.inputLastContacted;
import static bt_locators.LocatorsLeadsCRM.inputLeadValue;
import static bt_locators.LocatorsLeadsCRM.inputName;
import static bt_locators.LocatorsLeadsCRM.inputPhone;
import static bt_locators.LocatorsLeadsCRM.inputPosition;
import static bt_locators.LocatorsLeadsCRM.inputSearch;
import static bt_locators.LocatorsLeadsCRM.inputSearchAssigned;
import static bt_locators.LocatorsLeadsCRM.inputSearchCountry;
import static bt_locators.LocatorsLeadsCRM.inputSearchDefaultLanguage;
import static bt_locators.LocatorsLeadsCRM.inputSearchSource;
import static bt_locators.LocatorsLeadsCRM.inputSearchStatus;
import static bt_locators.LocatorsLeadsCRM.inputState;
import static bt_locators.LocatorsLeadsCRM.inputTag;
import static bt_locators.LocatorsLeadsCRM.inputWebsite;
import static bt_locators.LocatorsLeadsCRM.inputZipCode;
import static bt_locators.LocatorsLeadsCRM.labelCheckboxContactedToday;
import static bt_locators.LocatorsLeadsCRM.labelPhone;
import static bt_locators.LocatorsLeadsCRM.labelTag;
import static bt_locators.LocatorsLeadsCRM.linkDelete;
import static bt_locators.LocatorsLeadsCRM.linkEdit;
import static bt_locators.LocatorsLeadsCRM.tabProfile;
import static bt_locators.LocatorsLeadsCRM.updateLeadSuccessMessage;

public class LeadsPage extends BasePage{

    private WebDriver driver;

    public LeadsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Locators for menu Leads
    private By menuLeads = By.xpath("//span[@class='menu-text' and normalize-space()='Leads']");
    private By menuDashboard = By.xpath("//span[@class='menu-text' and normalize-space()='Dashboard']");

    //Locators for Leads Page

    private By urlLeads = By.xpath("https://crm.anhtester.com/admin/leads");
    private By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    private By iconLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    private By iconSwitchToKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    private By iconFilterBy = By.xpath("//div[@id='vueApp']//button[@type='button']");
    private By headerLeadPage = By.xpath("//h4[normalize-space()='Leads Summary']");

    private By dropdownLength = By.xpath("//select[@name='leads_length']");
    private By buttonExport = By.xpath("//button[normalize-space()='Export']");
    private By buttonBulkActions = By.xpath("//button[normalize-space()='Bulk Actions']");
    private By iconReload = By.xpath("//button[@title='Reload']");

    private By inputSearch = By.xpath("//div[@id='leads_filter']//input[@type='search']");
    // Tìm kiếm phần tử đầu tiên của bảng
    private By firstRowItemLeads = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");
    private By iconCloseProfile = By.xpath("//div[@id='lead-modal']//button[@class='close']");

    private By firstRow = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]");

    //----------Locators for Leads button

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    private By linkView = By.xpath("//tr[@id='lead_248']//a[normalize-space()='View']");
    //  private By linkEdit = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a/following-sibling::div/a[normalize-space()='Edit']");
    private By linkEdit = By.xpath("//table[@id='leads']/tbody/tr[1]//a[normalize-space()='Edit']");
    private By linkDelete = By.xpath("//table[@id='leads']/tbody/tr[1]//a[normalize-space()='Delete']");

    private By buttonPrevious = By.xpath("//li[@id='leads_previous']/a[text()='Previous']");
    private By buttonNumber = By.xpath("//div[@id='leads_paginate']//li[@class='paginate_button active']/a");
    private By buttonNext = By.xpath("//li[@id='leads_next']/a[text()='Next']");

    //----------Locators for Leads table

    private By inputCheck = By.xpath("//input[@id='mass_select_all']");
    private By headerSTT = By.xpath("//th[@id='th-number']");
    private By headerName = By.xpath("//th[@id='th-name']");
    private By headerCompany = By.xpath("//th[@id='th-company']");
    private By headerEmail = By.xpath("//th[@id='th-email']");
    private By headerPhone = By.xpath("//th[@id='th-phone']");
    private By headerValue= By.xpath("//th[@id='th-lead-value']");
    private By headerTags = By.xpath("//th[@id='th-tags']");
    private By headerAssigned= By.xpath("//th[@id='th-assigned']");
    private By headerStatus = By.xpath("//th[@id='th-status']");
    private By headerSource = By.xpath("//th[@id='th-source']");
    private By headerLastContact= By.xpath("//th[@id='th-last-contact']");
    private By headerCreated = By.xpath("//th[@id='th-date-created']");


    // Locators for Add New Leads Page

    private By headerAddNewLead = By.xpath("//h4[normalize-space()='Add new lead']");

    private By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;
    }
//    private By iconClosePopupLeadDetail(String headerLeadDetail) {
//        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
//        return xpath;
//    }


    //bỏ
    private By labelStatus = By.xpath("//label[@for='status']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By inputSearchStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");
    //  private By dropdownListStatus = By.xpath("//div[@app-field-wrapper='status']//span[normalize-space()='Active']");
    private By iconAddNewStatus = By.xpath("//div[@app-field-wrapper='status']//div[@class='input-group-btn']");
    private By getValueStatus(String valueStatus) {
        By xpathStatus = By.xpath("//div[@app-field-wrapper='status']//span[normalize-space()='" + valueStatus +"']");
        return xpathStatus;
    }


    private By labelSource = By.xpath("//label[text()='Source']");
    private By dropdownSource = By.xpath("//button[@data-id='source']");
    private By inputSearchSource = By.xpath("//button[@data-id='source']/following-sibling::div//input[@type='search']");

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    // private By dropdownListSource = By.xpath("//div[@app-field-wrapper='source']//span[text()='Google']");
    private By iconAddNewSource = By.xpath("//div[@app-field-wrapper='source']//div[@class='input-group-btn']");
    private By getValueSource(String valueSource) {
        By xpathSource = By.xpath("//div[@app-field-wrapper='source']//span[text()='" + valueSource + "']");
        return xpathSource;
    }


    private By labelAssigned = By.xpath("//label[@for='assigned']");
    private By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    private By inputSearchAssigned = By.xpath("//button[@data-id='assigned']/following-sibling::div//input[@type='search']");
    // private By dropdownListAssigned = By.xpath("//div[@app-field-wrapper='assigned']//span[normalize-space()='Admin Anh Tester']");
    private By getValueAssigned(String valueAssigned) {
        By xpathAssigned= By.xpath("//div[@app-field-wrapper='assigned']//span[normalize-space()='"+valueAssigned+"']");
        return xpathAssigned;
    }

    private By iconTag = By.xpath("//div[@id='inputTagsWrapper']//i[@class='fa fa-tag']");
    private By labelTag = By.xpath("//label[@for='tags']");
    //private By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By inputTag = By.xpath("//label[@for='tags']/following-sibling::ul//input[@placeholder='Tag']");
    private By listdropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div");
    private By getValueTag(String valueTag) {
        By xpathTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div[text()='" + valueTag + "']");
        return xpathTag;
    }
    // private By inputEditTag = By.xpath("//div[@id='inputTagsWrapper']/input[@id='tags']");
    private By inputEditTag = By.xpath("//input[@id='tags']");
    //   private By inputEditTag = By.xpath("//input[@id='tags']/following-sibling::ul//span[@class='tagit-label']");
    // private By inputEditTag = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    private By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");


    private By labelName = By.xpath("//form[@id='lead_form']//div[@app-field-wrapper='name']/label[@for='name']");
    private By inputName = By.xpath("//form[@id='lead_form']//input[@id='name']");

    private By labelAddress = By.xpath("//div[@app-field-wrapper='address']//label[@for='address']");
    private By inputAddress = By.xpath("//div[@app-field-wrapper='address']//textarea[@id='address']");

    private By labelPosition = By.xpath("//form[@id='lead_form']//label[text()='Position']");
    private By inputPosition = By.xpath("//form[@id='lead_form']//input[@id='title']");

    private By labelCity = By.xpath("//div[@app-field-wrapper='city']//label[@for='city']");
    private By inputCity = By.xpath("//div[@app-field-wrapper='city']//input[@id='city']");

    private By labelEmailAddress = By.xpath("//form[@id='lead_form']//label[@for='email']");
    private By inputEmailAddress = By.xpath("//form[@id='lead_form']//input[@id='email']");

    private By labelState = By.xpath("//div[@app-field-wrapper='state']//label[@for='state']");
    private By inputState = By.xpath("//div[@app-field-wrapper='state']//input[@id='state']");

    private By labelWebsite = By.xpath("//form[@id='lead_form']//label[@for='website']");
    private By inputWebsite = By.xpath("//form[@id='lead_form']//input[@id='website']");

    private By labelCountry = By.xpath("//div[@app-field-wrapper='country']//label[@for='country']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input[@type='search']");
    // private By dropdownListCountry = By.xpath("//div[@app-field-wrapper='country']//span[text()='Vietnam']");
    private By getValueCountry(String valueCountry) {
        By xpathCountry = By.xpath("//div[@app-field-wrapper='country']//span[text()='" + valueCountry + "']");
        return xpathCountry;
    }

    private By labelPhone = By.xpath("//div[@app-field-wrapper='phonenumber']//label[@for='phonenumber']");
    private By inputPhone = By.xpath("//div[@app-field-wrapper='phonenumber']//input[@id='phonenumber']");

    private By labelZipCode = By.xpath("//div[@app-field-wrapper='zip']/label[@for='zip']");
    private By inputZipCode = By.xpath("//div[@app-field-wrapper='zip']//input[@id='zip']");

    private By labelLeadValue = By.xpath("//label[@for='lead_value']");
    private By inputLeadValue = By.xpath("//div[@data-toggle='tooltip']//input[@name='lead_value']");
    private By iconLeadValue = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[6]/div/div");

    private By labelDefaultLanguage = By.xpath("//label[@for='default_language']");
    private By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");
    private By dropdownListDefaultLanguage = By.xpath("//div[@id='bs-select-9']//span[normalize-space()='Vietnamese']");
    private By getValueDefaultLanguage(String valueDefaultLanguage) {
        By xpathDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//span[contains(normalize-space(),'" + valueDefaultLanguage + "')]");
        return xpathDefaultLanguage;
    }

    private By labelCompany = By.xpath("//div[@app-field-wrapper='company']//label[@for='company']");
    private By inputCompany= By.xpath("//div[@app-field-wrapper='company']//input[@id='company']");

    private By labelDescription = By.xpath("//label[@for='description']");
    private By inputDescription = By.xpath("//div[@app-field-wrapper='description']//textarea[@id='description']");

    private By labelDateContacted = By.xpath("//label[@for='custom_contact_date']");
    private By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    private By iconDateContacted = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[9]/div[2]/div/div[1]/div/div/div");

    private By inputLastContacted = By.xpath("//label[@for='lastcontact']/following-sibling::div/input[@id='lastcontact']");

    private By labelCheckboxprivate = By.xpath("//label[@for='lead_private']");
    private By checkboxprivate = By.xpath("//input[@id='lead_private']");

    private By labelCheckboxContactedToday = By.xpath("//label[@for='contacted_today']");
    private By checkboxContactedToday= By.xpath("//input[@id='contacted_today']");

    private By buttonClose= By.xpath("//form[@id='lead_form']/div[2]/button[normalize-space()='Close']");

    private By buttonSave = By.xpath("//button[normalize-space()='Save' and @id='lead-form-submit']");

    private By alertErrorMessageRequired = By.xpath("//p[starts-with(text(), 'This field is required.')]");
    private By alertErrorMessageLeadValue = By.xpath("//p[@id='lead_value-error' and text() = 'Please enter a valid number.']");
    private By alertErrorMessageEmail = By.xpath("//div[@app-field-wrapper='email']//p[@id='email-error']");

    private By headerEditPage = By.xpath("//div[@id='lead-modal']//h4[@class='modal-title']");
    private By tabProfile = By.xpath("//ul[@role='tablist']/li[@class='active']");


    private By addLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead added successfully.']/parent::div");
    private By updateLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead updated successfully.']/parent::div");
    private By deleteLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead deleted']/parent::div");

    private By iconClosePopupLeadDetail(String headerLeadDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }


    //------------------------------------------------------------------------

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

    public void fillDataLeads(String status, String source, String assigned, String tag, String name, String address, String position,
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

    public void verifyEmailResult(boolean expectValid, String expectedErrorMsg) {
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

    public void clickIconClosePopupLeadDetail(String name, int flagEdit) throws InterruptedException {
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

    public void searchLeads(String leadsName) throws InterruptedException {

        WebUI.clearTextElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, leadsName);

        // Check xem có tìm thấy dòng nào không
        //    List<WebElement> rows = driver.findElements(By.xpath(firstRowItemLeads));

        List<WebElement> rows = WebUI.getWebElements(driver, firstRowItemLeads);
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Lead vừa tạo trong danh sách!");

        System.out.println("Đã tìm thấy Lead search: " + rows.get(0).getText());
        // Thread.sleep(1000);
    }

    public void compareFieldAttribute(WebDriver driver, String expectedValue, By by, String attributeType) {
        String actual = WebUI.getElementAttribute(driver, by, attributeType);
        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual
        );
    }


    public void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "FAILED: Checkbox [" + checked + "] chưa được chọn.");
    }


    public void verifyEditLead(
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

}


