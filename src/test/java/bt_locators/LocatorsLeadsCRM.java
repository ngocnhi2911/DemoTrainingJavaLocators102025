package bt_locators;

public class LocatorsLeadsCRM {
    public static String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public static String headerLoginPage = "//h1[normalize-space() = 'Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String labelRememberMe = "//label[@for='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";

       //** Nếu có id --> Nên dùng id, (xác định thằng cha rồi đến thằng con) để check lỗi mình mong muốn có đúng k
    public static String errorMessageInvalidEmailOrPassword = "//div[@id='alerts']/div";

    public static String alertErrorMessage = "//div[contains(text(), 'Invalid email')]";
    public static String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public static String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Locators for menu Leads
    public static String menuLeads = "//span[@class='menu-text' and normalize-space()='Leads']";

    //Locators for Leads Page

    public static String urlLeads = "https://crm.anhtester.com/admin/leads";
    public static String buttonNewLead = "//a[normalize-space()='New Lead']";
    public static String iconLeadsSummary = "//a[normalize-space()='Leads Summary']";
    public static String iconSwitchToKanban = "//a[@data-title='Switch to Kanban']";
    public static String iconFilterBy = "//div[@id='vueApp']//button[@type='button']";
    public static String headerLeadPage = "//h4[normalize-space()='Leads Summary']";

    public static String dropdownLength = "//select[@name='leads_length']";
    public static String buttonExport = "//button[normalize-space()='Export']";
    public static String buttonBulkActions = "//button[normalize-space()='Bulk Actions']";
    public static String iconReload = "//button[@title='Reload']";

    public static String inputSearch = "//div[@id='leads_filter']//input[@type='search']";
    // Tìm kiếm phần tử đầu tiên của bảng
    public static String firstRowItemLeads = "//table[@id='leads']//tbody/tr[1]/td[3]/a";
    public static String iconCloseProfile = "//div[@id='lead-modal']//button[@class='close']";

    //----------Locators for Leads button

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    public static String linkView = "//tr[@id='lead_248']//a[normalize-space()='View']";
  //  public static String linkEdit = "//table[@id='leads']//tbody/tr[1]/td[3]/a/following-sibling::div/a[normalize-space()='Edit']";
    public static String linkEdit = "//table[@id='leads']/tbody/tr[1]//a[normalize-space()='Edit']";
    public static String linkDelete = "//tr[@id='lead_248']//a[normalize-space()='Delete']";

    public static String buttonPrevious = "//li[@id='leads_previous']/a[text()='Previous']";
    public static String buttonNumber = "//div[@id='leads_paginate']//li[@class='paginate_button active']/a";
    public static String buttonNext = "//li[@id='leads_next']/a[text()='Next']";

    //----------Locators for Leads table

    public static String inputCheck = "//input[@id='mass_select_all']";
    public static String headerSTT = "//th[@id='th-number']";
    public static String headerName = "//th[@id='th-name']";
    public static String headerCompany = "//th[@id='th-company']";
    public static String headerEmail = "//th[@id='th-email']";
    public static String headerPhone = "//th[@id='th-phone']";
    public static String headerValue= "//th[@id='th-lead-value']";
    public static String headerTags = "//th[@id='th-tags']";
    public static String headerAssigned= "//th[@id='th-assigned']";
    public static String headerStatus = "//th[@id='th-status']";
    public static String headerSource = "//th[@id='th-source']";
    public static String headerLastContact= "//th[@id='th-last-contact']";
    public static String headerCreated = "//th[@id='th-date-created']";


    // Locators for Add New Leads Page

    public static String headerAddNewLead = "//h4[normalize-space()='Add new lead']";


    //bỏ
    public static String labelStatus = "//label[@for='status']";
    public static String dropdownStatus = "//button[@data-id='status']";
    public static String inputSearchStatus = "//button[@data-id='status']/following-sibling::div//input[@type='search']";
  //  public static String dropdownListStatus = "//div[@app-field-wrapper='status']//span[normalize-space()='Active']";
    public static String iconAddNewStatus = "//div[@app-field-wrapper='status']//div[@class='input-group-btn']";
    public static String getValueStatus(String valueStatus) {
        String xpathStatus = "//div[@app-field-wrapper='status']//span[normalize-space()='" + valueStatus +"']";
        return xpathStatus;
    }


    public static String labelSource = "//label[text()='Source']";
    public static String dropdownSource = "//button[@data-id='source']";
    public static String inputSearchSource = "//button[@data-id='source']/following-sibling::div//input[@type='search']";

    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
   // public static String dropdownListSource = "//div[@app-field-wrapper='source']//span[text()='Google']";
    public static String iconAddNewSource = "//div[@app-field-wrapper='source']//div[@class='input-group-btn']";
    public static String getValueSource(String valueSource) {
        String xpathSource = "//div[@app-field-wrapper='source']//span[text()='" + valueSource + "']";
        return xpathSource;
    }


    public static String labelAssigned = "//label[@for='assigned']";
    public static String dropdownAssigned = "//button[@data-id='assigned']";
    public static String inputSearchAssigned = "//button[@data-id='assigned']/following-sibling::div//input[@type='search']";
   // public static String dropdownListAssigned = "//div[@app-field-wrapper='assigned']//span[normalize-space()='Admin Anh Tester']";
    public static String getValueAssigned(String valueAssigned) {
        String xpathAssigned= "//div[@app-field-wrapper='assigned']//span[normalize-space()='"+valueAssigned+"']";
        return xpathAssigned;
    }

    public static String iconTag = "//div[@id='inputTagsWrapper']//i[@class='fa fa-tag']";
    public static String labelTag = "//label[@for='tags']";
    public static String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String listdropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']/li[@class='ui-menu-item']/div";
  //  public static String dropdownListTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div[text()='hieu']";
    public static String getValueTag(String valueTag) {
        String xpathTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div[text()='" + valueTag + "']";
        return xpathTag;
    }


    public static String labelName = "//form[@id='lead_form']//div[@app-field-wrapper='name']/label[@for='name']";
    public static String inputName = "//form[@id='lead_form']//input[@id='name']";

    public static String labelAddress = "//div[@app-field-wrapper='address']//label[@for='address']";
    public static String inputAddress = "//div[@app-field-wrapper='address']//textarea[@id='address']";

    public static String labelPosition = "//form[@id='lead_form']//label[text()='Position']";
    public static String inputPosition = "//form[@id='lead_form']//input[@id='title']";

    public static String labelCity = "//div[@app-field-wrapper='city']//label[@for='city']";
    public static String inputCity = "//div[@app-field-wrapper='city']//input[@id='city']";

    public static String labelEmailAddress = "//form[@id='lead_form']//label[@for='email']";
    public static String inputEmailAddress = "//form[@id='lead_form']//input[@id='email']";

    public static String labelState = "//div[@app-field-wrapper='state']//label[@for='state']";
    public static String inputState = "//div[@app-field-wrapper='state']//input[@id='state']";

    public static String labelWebsite = "//form[@id='lead_form']//label[@for='website']";
    public static String inputWebsite = "//form[@id='lead_form']//input[@id='website']";

    public static String labelCountry = "//div[@app-field-wrapper='country']//label[@for='country']";
    public static String dropdownCountry = "//button[@data-id='country']";
    public static String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input[@type='search']";
   // public static String dropdownListCountry = "//div[@app-field-wrapper='country']//span[text()='Vietnam']";
    public static String getValueCountry(String valueCountry) {
        String xpathCountry = "//div[@app-field-wrapper='country']//span[text()='" + valueCountry + "']";
        return xpathCountry;
    }

    public static String labelPhone = "//div[@app-field-wrapper='phonenumber']//label[@for='phonenumber']";
    public static String inputPhone = "//div[@app-field-wrapper='phonenumber']//input[@id='phonenumber']";

    public static String labelZipCode = "//div[@app-field-wrapper='zip']/label[@for='zip']";
    public static String inputZipCode = "//div[@app-field-wrapper='zip']//input[@id='zip']";

    public static String labelLeadValue = "//label[@for='lead_value']";
    public static String inputLeadValue = "//div[@data-toggle='tooltip']//input[@name='lead_value']";
    public static String iconLeadValue = "/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[6]/div/div";

    public static String labelDefaultLanguage = "//label[@for='default_language']";
    public static String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public static String inputSearchDefaultLanguage = "//button[@data-id='default_language']/following-sibling::div//input[@type='search']";
    public static String dropdownListDefaultLanguage = "//div[@id='bs-select-9']//span[normalize-space()='Vietnamese']";
    public static String getValueDefaultLanguage(String valueDefaultLanguage) {
        String xpathDefaultLanguage = "//div[@id='bs-select-9']//span[normalize-space()='"+valueDefaultLanguage+"']";
        return xpathDefaultLanguage;
    }

    public static String labelCompany = "//div[@app-field-wrapper='company']//label[@for='company']";
    public static String inputCompany= "//div[@app-field-wrapper='company']//input[@id='company']";

    public static String labelDescription = "//label[@for='description']";
    public static String inputDescription = "//div[@app-field-wrapper='description']//textarea[@id='description']";

    public static String labelDateContacted = "//label[@for='custom_contact_date']";
    public static String inputDateContacted = "//input[@id='custom_contact_date']";
    public static String iconDateContacted = "/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[9]/div[2]/div/div[1]/div/div/div";

    public static String labelPublic = "//label[@for='lead_public']";
    public static String checkboxPublic = "//input[@id='lead_public']";

    public static String labelContactedToday = "//label[@for='contacted_today']";
    public static String checkboxContactedToday= "//input[@id='contacted_today']";

    public static String buttonClose= "//form[@id='lead_form']/div[2]/button[normalize-space()='Close']";

    public static String buttonSave = "//form[@id='lead_form']/div[2]/button[@id='lead-form-submit']";

    public static String alertErrorMessageRequired = "//p[starts-with(text(), 'This field is required.')]";
    public static String alertErrorMessageValidNumber = "//p[@id='lead_value-error' and text() = 'Please enter a valid number.']";



}
