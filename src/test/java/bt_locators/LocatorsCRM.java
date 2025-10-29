package bt_locators;

import org.openqa.selenium.WebDriver;

public class LocatorsCRM {
    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public String headerLoginPage = "//h1[normalize-space() = 'Login']";
    public String inputEmail = "//input[@id='email']";
    public String inputPassword = "//input[@id='password']";
    public String buttonLogin = "//button[normalize-space()='Login']";
    public String checkboxRememberMe = "//input[@id='remember']";
    public String labelRememberMe = "//label[@for='remember']";
    public String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public String alertErrorMessage = "//div[contains(text(), 'Invalid email')]";
    public String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Locators for menu Leads
    public String menuLeads = "//span[@class='menu-text' and normalize-space()='Leads']";

    //Locators for Leads Page

    public String urlLeads = "https://crm.anhtester.com/admin/leads";
    public String buttonNewLead = "//a[normalize-space()='New Lead']";
    public String buttonLeadsSummary = "//a[normalize-space()='Leads Summary']";
    public String buttonSwitchToKanban = "//a[@data-title='Switch to Kanban']";
    public String buttonFilterBy = "//button[normalize-space()='Filter by']";
    public String headerLeadPage = "//h4[normalize-space()='Leads Summary']";

    public String dropdownLength = "//select[@name='leads_length']";
    public String buttonExport = "//button[normalize-space()='Export']";
    public String buttonBulkActions = "//button[normalize-space()='Bulk Actions']";
    public String buttonReload = "//button[@title='Reload']";

    public String inputSearch = "//div[@id='leads_filter']//input[@type='search']";

    //----------Locators for Leads button
    public String linkView = "//tr[@id='lead_248']//a[normalize-space()='View']";
    public String linkEdit = "//tr[@id='lead_248']//a[normalize-space()='Edit']";
    public String linkDelete = "//tr[@id='lead_248']//a[normalize-space()='Delete']";

    public String buttonPrevious = "//li[@id='leads_previous']/a[text()='Previous']";
    public String buttonNumber = "//li[@class='paginate_button active']/a";
    public String buttonNext = "//li[@id='leads_next']/a[text()='Next']";

    //----------Locators for Leads table

    public String inputCheck = "//input[@id='mass_select_all']";
    public String labelSTT = "//th[@id='th-number']";
    public String labelName = "//th[@id='th-name']";
    public String labelCompany = "//th[@id='th-company']";
    public String labelEmail = "//th[@id='th-email']";
    public String labelPhone = "//th[@id='th-phone']";
    public String labelValue= "//th[@id='th-lead-value']";
    public String labelTags = "//th[@id='th-tags']";
    public String labelAssigned= "//th[@id='th-assigned']";
    public String labelStatus = "//th[@id='th-status']";
    public String labelSource = "//th[@id='th-source']";
    public String labelLastContact= "//th[@id='th-last-contact']";
    public String labelCreated = "//th[@id='th-date-created']";


    // Locators for Add New Leads Page

    public String headerAddNewLead = "//h4[normalize-space()='Add new lead']";


    public String reqStatus = "//label[@for='status']/small[normalize-space()='*']";
    public String LabelStatus = "//label[@for='status']";
    public String dropdownStatus = "//button[@data-id='status']";
    public String inputSearchStatus = "//button[@data-id='status']/following-sibling::div//input";
    public String dropdownListStatus = "//div[@id='bs-select-5']//a[@id='bs-select-5-3']/span";
    public String addNewStatus = "//div[@app-field-wrapper='status']//div[@class='input-group-btn']";


    public String reqSource = "//label[@for='source']/small[normalize-space()='*']";
    public String LabelSource = "//label[text()='Source']";
    public String dropdownSource = "//button[@data-id='source']";
    public String inputSearchSource = "//button[@data-id='source']/following-sibling::div//input";
    public String dropdownListSource = "//a[@id='bs-select-6-2']/span";
    public String addNewSource = "//div[@app-field-wrapper='source']//div[@class='input-group-btn']";


    public String LabelAssigned = "//label[@for='assigned']";
    public String dropdownAssigned = "//button[@data-id='assigned']";
    public String inputSearchAssigned = "//button[@data-id='assigned']/following-sibling::div//input";
    public String dropdownListAssigned = "//div[@id='bs-select-7']//span[normalize-space()='Admin Anh Tester']";

    public String iconTag = "//div[@id='inputTagsWrapper']//i[@class='fa fa-tag']";
    public String labelTag = "//label[@for='tags']";
    public String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public String dropdownTag = "//ul[@id='ui-id-2']";
    public String dropdownListTag = "//ul[@id='ui-id-2']//div[@id='ui-id-75']";

    public String reqName = "//label[@for='source']/small[normalize-space()='*']";
    public String LabelName = "//form[@id='lead_form']//div[@app-field-wrapper='name']/label[@for='name']";
    public String inputName = "//form[@id='lead_form']//input[@id='name']";

    public String LabelAddress = "//div[@app-field-wrapper='address']//label[@for='address']";
    public String inputAddress = "//div[@app-field-wrapper='address']//textarea[@id='address']";

    public String LabelPosition = "//form[@id='lead_form']//label[text()='Position']";
    public String inputPosition = "//form[@id='lead_form']//input[@id='title']";

    public String LabelCity = "//div[@app-field-wrapper='city']//label[@for='city']";
    public String inputCity = "//div[@app-field-wrapper='city']//input[@id='city']";

    public String LabelEmailAddress = "//form[@id='lead_form']//label[@for='email']";
    public String inputEmailAddress = "//form[@id='lead_form']//input[@id='email']";

    public String LabelState = "//div[@app-field-wrapper='state']//label[@for='state']";
    public String inputState = "//div[@app-field-wrapper='state']//input[@id='state']";

    public String LabelWebsite = "//form[@id='lead_form']//label[@for='website']";
    public String inputWebsite = "//form[@id='lead_form']//input[@id='website']";

    public String LabelCountry = "//div[@app-field-wrapper='country']//label[@for='country']";
    public String dropdownCountry = "//button[@data-id='country']";
    public String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input";
    public String dropdownListCountry = "//a[@id='bs-select-8-243']";

    public String LabelPhone = "//div[@app-field-wrapper='phonenumber']//label[@for='phonenumber']";
    public String inputPhone = "//div[@app-field-wrapper='phonenumber']//input[@id='phonenumber']";

    public String LabelZipCode = "//div[@app-field-wrapper='zip']/label[@for='zip']";
    public String inputZipCode = "//div[@app-field-wrapper='zip']//input[@id='zip']";

    public String LabelLeadValue = "//label[@for='lead_value']";
    public String inputLeadValue = "//div[@data-toggle='tooltip']//input[@name='lead_value']";
    public String iconLeadValue = "/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[7]/div[6]/div/div";

    public String LabelDefaultLanguage = "//label[@for='default_language']";
    public String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public String inputSearchDefaultLanguage = "//button[@data-id='default_language']/following-sibling::div//input";
    public String dropdownListDefaultLanguage = "//div[@id='bs-select-9']//a[@id='bs-select-9-17']/span";

    public String LabelCompany = "//div[@app-field-wrapper='company']//label[@for='company']";
    public String inputCompany= "//div[@app-field-wrapper='company']//input[@id='company']";

    public String LabelDescription = "//label[@for='description']";
    public String inputDescription = "//div[@app-field-wrapper='description']//textarea[@id='description']";

    public String LabelDateContacted = "//label[@for='custom_contact_date']";
    public String inputDateContacted = "//input[@id='custom_contact_date']";
    public String iconDateContacted = "/html/body/div[11]/div/div/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div[9]/div[2]/div/div[1]/div/div/div";

    public String LabelPublic = "//label[@for='lead_public']";
    public String checkboxPublic = "//input[@id='lead_public']";

    public String LabelContactedToday = "//label[@for='contacted_today']";
    public String checkboxContactedToday= "//input[@id='contacted_today']";

    public String buttonClose= "//form[@id='lead_form']/div[2]/button[normalize-space()='Close']";

    public String buttonSave = "//form[@id='lead_form']/div[2]/button[@id='lead-form-submit']";

    public String alertErrorMessageRequired = "//p[starts-with(text(), 'This field is required.')]";
    public String alertErrorMessageValidNumber = "//p[@id='lead_value-error' and text() = 'Please enter a valid number.']";



}
