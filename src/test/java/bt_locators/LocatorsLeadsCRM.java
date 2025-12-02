package bt_locators;

import org.openqa.selenium.By;

public class LocatorsLeadsCRM {

    //Locators for menu Leads
    public static By menuLeads = By.xpath("//span[@class='menu-text' and normalize-space()='Leads']");
    public static By menuDashboard = By.xpath("//span[@class='menu-text' and normalize-space()='Dashboard']");

    //Locators for Leads Page

    public static By urlLeads = By.xpath("https://crm.anhtester.com/admin/leads");
    public static By buttonNewLead = By.xpath("//a[normalize-space()='New Lead']");
    public static By iconLeadsSummary = By.xpath("//a[@data-title='Leads Summary']");
    public static By iconSwitchToKanban = By.xpath("//a[@data-title='Switch to Kanban']");
    public static By iconFilterBy = By.xpath("//div[@id='vueApp']//button[@type='button']");
    public static By headerLeadPage = By.xpath("//h4[normalize-space()='Leads Summary']");

    public static By dropdownLength = By.xpath("//select[@name='leads_length']");
    public static By buttonExport = By.xpath("//button[normalize-space()='Export']");
    public static By buttonBulkActions = By.xpath("//button[normalize-space()='Bulk Actions']");
    public static By iconReload = By.xpath("//button[@title='Reload']");

    public static By inputSearch = By.xpath("//div[@id='leads_filter']//input[@type='search']");
    // Tìm kiếm phần tử đầu tiên của bảng
    public static By firstRowItemLeads = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a");
    public static By iconCloseProfile = By.xpath("//div[@id='lead-modal']//button[@class='close']");

    public static By firstRow = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]");

    //----------Locators for Leads button

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    public static By linkView = By.xpath("//tr[@id='lead_248']//a[normalize-space()='View']");
  //  public static By linkEdit = By.xpath("//table[@id='leads']//tbody/tr[1]/td[3]/a/following-sibling::div/a[normalize-space()='Edit']");
    public static By linkEdit = By.xpath("//table[@id='leads']/tbody/tr[1]//a[normalize-space()='Edit']");
    public static By linkDelete = By.xpath("//table[@id='leads']/tbody/tr[1]//a[normalize-space()='Delete']");

    public static By buttonPrevious = By.xpath("//li[@id='leads_previous']/a[text()='Previous']");
    public static By buttonNumber = By.xpath("//div[@id='leads_paginate']//li[@class='paginate_button active']/a");
    public static By buttonNext = By.xpath("//li[@id='leads_next']/a[text()='Next']");

    //----------Locators for Leads table

    public static By inputCheck = By.xpath("//input[@id='mass_select_all']");
    public static By headerSTT = By.xpath("//th[@id='th-number']");
    public static By headerName = By.xpath("//th[@id='th-name']");
    public static By headerCompany = By.xpath("//th[@id='th-company']");
    public static By headerEmail = By.xpath("//th[@id='th-email']");
    public static By headerPhone = By.xpath("//th[@id='th-phone']");
    public static By headerValue= By.xpath("//th[@id='th-lead-value']");
    public static By headerTags = By.xpath("//th[@id='th-tags']");
    public static By headerAssigned= By.xpath("//th[@id='th-assigned']");
    public static By headerStatus = By.xpath("//th[@id='th-status']");
    public static By headerSource = By.xpath("//th[@id='th-source']");
    public static By headerLastContact= By.xpath("//th[@id='th-last-contact']");
    public static By headerCreated = By.xpath("//th[@id='th-date-created']");


    // Locators for Add New Leads Page

    public static By headerAddNewLead = By.xpath("//h4[normalize-space()='Add new lead']");

    public static By getFirstRowItemLeadName(String leadName) {
        By xpath = By.xpath("//table[@id='leads']//a[normalize-space()='" + leadName + "']");
        return xpath;
    }
//    public static By iconClosePopupLeadDetail(String headerLeadDetail) {
//        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
//        return xpath;
//    }


    //bỏ
    public static By labelStatus = By.xpath("//label[@for='status']");
    public static By dropdownStatus = By.xpath("//button[@data-id='status']");
    public static By inputSearchStatus = By.xpath("//button[@data-id='status']/following-sibling::div//input[@type='search']");
  //  public static By dropdownListStatus = By.xpath("//div[@app-field-wrapper='status']//span[normalize-space()='Active']");
    public static By iconAddNewStatus = By.xpath("//div[@app-field-wrapper='status']//div[@class='input-group-btn']");
    public static By getValueStatus(String valueStatus) {
        By xpathStatus = By.xpath("//div[@app-field-wrapper='status']//span[normalize-space()='" + valueStatus +"']");
        return xpathStatus;
    }


    public static By labelSource = By.xpath("//label[text()='Source']");
    public static By dropdownSource = By.xpath("//button[@data-id='source']");
    public static By inputSearchSource = By.xpath("//button[@data-id='source']/following-sibling::div//input[@type='search']");

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
   // public static By dropdownListSource = By.xpath("//div[@app-field-wrapper='source']//span[text()='Google']");
    public static By iconAddNewSource = By.xpath("//div[@app-field-wrapper='source']//div[@class='input-group-btn']");
    public static By getValueSource(String valueSource) {
        By xpathSource = By.xpath("//div[@app-field-wrapper='source']//span[text()='" + valueSource + "']");
        return xpathSource;
    }


    public static By labelAssigned = By.xpath("//label[@for='assigned']");
    public static By dropdownAssigned = By.xpath("//button[@data-id='assigned']");
    public static By inputSearchAssigned = By.xpath("//button[@data-id='assigned']/following-sibling::div//input[@type='search']");
   // public static By dropdownListAssigned = By.xpath("//div[@app-field-wrapper='assigned']//span[normalize-space()='Admin Anh Tester']");
    public static By getValueAssigned(String valueAssigned) {
        By xpathAssigned= By.xpath("//div[@app-field-wrapper='assigned']//span[normalize-space()='"+valueAssigned+"']");
        return xpathAssigned;
    }

    public static By iconTag = By.xpath("//div[@id='inputTagsWrapper']//i[@class='fa fa-tag']");
    public static By labelTag = By.xpath("//label[@for='tags']");
    //public static By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    public static By inputTag = By.xpath("//label[@for='tags']/following-sibling::ul//input[@placeholder='Tag']");
    public static By listdropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div");
    public static By getValueTag(String valueTag) {
        By xpathTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div[text()='" + valueTag + "']");
        return xpathTag;
    }
   // public static By inputEditTag = By.xpath("//div[@id='inputTagsWrapper']/input[@id='tags']");
   public static By inputEditTag = By.xpath("//input[@id='tags']");
  //   public static By inputEditTag = By.xpath("//input[@id='tags']/following-sibling::ul//span[@class='tagit-label']");
  // public static By inputEditTag = By.xpath("(//input[@id='tags']/following-sibling::ul)/descendant::span[@class='tagit-label']");
    public static By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");


    public static By labelName = By.xpath("//form[@id='lead_form']//div[@app-field-wrapper='name']/label[@for='name']");
    public static By inputName = By.xpath("//form[@id='lead_form']//input[@id='name']");

    public static By labelAddress = By.xpath("//div[@app-field-wrapper='address']//label[@for='address']");
    public static By inputAddress = By.xpath("//div[@app-field-wrapper='address']//textarea[@id='address']");

    public static By labelPosition = By.xpath("//form[@id='lead_form']//label[text()='Position']");
    public static By inputPosition = By.xpath("//form[@id='lead_form']//input[@id='title']");

    public static By labelCity = By.xpath("//div[@app-field-wrapper='city']//label[@for='city']");
    public static By inputCity = By.xpath("//div[@app-field-wrapper='city']//input[@id='city']");

    public static By labelEmailAddress = By.xpath("//form[@id='lead_form']//label[@for='email']");
    public static By inputEmailAddress = By.xpath("//form[@id='lead_form']//input[@id='email']");

    public static By labelState = By.xpath("//div[@app-field-wrapper='state']//label[@for='state']");
    public static By inputState = By.xpath("//div[@app-field-wrapper='state']//input[@id='state']");

    public static By labelWebsite = By.xpath("//form[@id='lead_form']//label[@for='website']");
    public static By inputWebsite = By.xpath("//form[@id='lead_form']//input[@id='website']");

    public static By labelCountry = By.xpath("//div[@app-field-wrapper='country']//label[@for='country']");
    public static By dropdownCountry = By.xpath("//button[@data-id='country']");
    public static By inputSearchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input[@type='search']");
   // public static By dropdownListCountry = By.xpath("//div[@app-field-wrapper='country']//span[text()='Vietnam']");
    public static By getValueCountry(String valueCountry) {
        By xpathCountry = By.xpath("//div[@app-field-wrapper='country']//span[text()='" + valueCountry + "']");
        return xpathCountry;
    }

    public static By labelPhone = By.xpath("//div[@app-field-wrapper='phonenumber']//label[@for='phonenumber']");
    public static By inputPhone = By.xpath("//div[@app-field-wrapper='phonenumber']//input[@id='phonenumber']");

    public static By labelZipCode = By.xpath("//div[@app-field-wrapper='zip']/label[@for='zip']");
    public static By inputZipCode = By.xpath("//div[@app-field-wrapper='zip']//input[@id='zip']");

    public static By labelLeadValue = By.xpath("//label[@for='lead_value']");
    public static By inputLeadValue = By.xpath("//div[@data-toggle='tooltip']//input[@name='lead_value']");
    public static By iconLeadValue = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[6]/div/div");

    public static By labelDefaultLanguage = By.xpath("//label[@for='default_language']");
    public static By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    public static By inputSearchDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//input[@type='search']");
    public static By dropdownListDefaultLanguage = By.xpath("//div[@id='bs-select-9']//span[normalize-space()='Vietnamese']");
    public static By getValueDefaultLanguage(String valueDefaultLanguage) {
        By xpathDefaultLanguage = By.xpath("//button[@data-id='default_language']/following-sibling::div//span[contains(normalize-space(),'" + valueDefaultLanguage + "')]");
        return xpathDefaultLanguage;
    }

    public static By labelCompany = By.xpath("//div[@app-field-wrapper='company']//label[@for='company']");
    public static By inputCompany= By.xpath("//div[@app-field-wrapper='company']//input[@id='company']");

    public static By labelDescription = By.xpath("//label[@for='description']");
    public static By inputDescription = By.xpath("//div[@app-field-wrapper='description']//textarea[@id='description']");

    public static By labelDateContacted = By.xpath("//label[@for='custom_contact_date']");
    public static By inputDateContacted = By.xpath("//input[@id='custom_contact_date']");
    public static By iconDateContacted = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[9]/div[2]/div/div[1]/div/div/div");

    public static By inputLastContacted = By.xpath("//label[@for='lastcontact']/following-sibling::div/input[@id='lastcontact']");

    public static By labelCheckboxPublic = By.xpath("//label[@for='lead_public']");
    public static By checkboxPublic = By.xpath("//input[@id='lead_public']");

    public static By labelCheckboxContactedToday = By.xpath("//label[@for='contacted_today']");
    public static By checkboxContactedToday= By.xpath("//input[@id='contacted_today']");

    public static By buttonClose= By.xpath("//form[@id='lead_form']/div[2]/button[normalize-space()='Close']");

    public static By buttonSave = By.xpath("//button[normalize-space()='Save' and @id='lead-form-submit']");

    public static By alertErrorMessageRequired = By.xpath("//p[starts-with(text(), 'This field is required.')]");
    public static By alertErrorMessageLeadValue = By.xpath("//p[@id='lead_value-error' and text() = 'Please enter a valid number.']");
    public static By alertErrorMessageEmail = By.xpath("//div[@app-field-wrapper='email']//p[@id='email-error']");

    public static By headerEditPage = By.xpath("//div[@id='lead-modal']//h4[@class='modal-title']");
    public static By tabProfile = By.xpath("//ul[@role='tablist']/li[@class='active']");


    public static By addLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead added successfully.']/parent::div");
    public static By updateLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead updated successfully.']/parent::div");
    public static By deleteLeadSuccessMessage = By.xpath("//span[@class='alert-title' and normalize-space()='Lead deleted']/parent::div");

    public static By iconClosePopupLeadDetail(String headerLeadDetail) {
        By xpath = By.xpath("//h4[contains(normalize-space(),'" + headerLeadDetail + "')]/preceding-sibling::button[@aria-label='Close']");
        return xpath;
    }


}
