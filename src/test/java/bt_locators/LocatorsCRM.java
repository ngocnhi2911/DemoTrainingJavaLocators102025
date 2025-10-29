package bt_locators;

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
    public String dropdownLength = "//select[@name='leads_length']";
    public String buttonExport = "//button[normalize-space()='Export']";
    public String buttonBulkActions = "//button[normalize-space()='Bulk Actions']";
    public String buttonReload = "//button[@title='Reload']";

    public String inputSearch = "//div[@id='leads_filter']//input[@type='search']";

    //----------Locators for Leads button
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
    public String dropdownStatus = "//button[@data-id='status']";
    public String inputSearchStatus = "//button[@data-id='status']/following-sibling::div//input";
    public String dropdownSource = "//button[@data-id='source']";
    public String inputSearchSource = "//button[@data-id='source']/following-sibling::div//input";
    public String dropdownAssigned = "//button[@data-id='assigned']";
    public String inputSearchAssigned = "//button[@data-id='assigned']/following-sibling::div//input";
    public String labelTag = "//label[@for='tags']";
    public String inputTag = "//input[@placeholder='Tag']";
    public String inputName = "//form[@id='lead_form']//input[@id='name']";
    public String inputAddress = "//div[@app-field-wrapper='address']//textarea[@id='address']";
    public String inputPosition= "//form[@id='lead_form']//input[@id='title']";
    public String inputCity = "//div[@app-field-wrapper='city']//input[@id='city']";
    public String inputEmailAddress = "//form[@id='lead_form']//input[@id='email']";
    public String inputState = "//div[@app-field-wrapper='state']//input[@id='state']";
    public String inputWebsite = "//form[@id='lead_form']//input[@id='website']";
    public String dropdownCountry = "//button[@data-id='country']";
    public String inputSearchCountry = "//button[@data-id='country']/following-sibling::div//input";
    public String inputPhone = "//div[@app-field-wrapper='phonenumber']//input[@id='phonenumber']";
    public String inputZipCode = "//div[@app-field-wrapper='zip']//input[@id='zip']";
    public String inputLeadValue = "//div[@data-toggle='tooltip']//input[@name='lead_value']";
    public String dropdownDefaultLanguage = "//button[@data-id='default_language']";
    public String inputSearchDefaultLanguage = "//button[@data-id='default_language']/following-sibling::div//input";
    public String inputCompany= "//div[@app-field-wrapper='company']//input[@id='company']";
    public String inputDescription = "//div[@app-field-wrapper='description']//textarea[@id='description']";
    public String checkboxPublic = "//input[@id='lead_public']";
    public String checkboxContactedToday= "//input[@id='contacted_today']";
    public String buttonClose= "//form[@id='lead_form']/div[2]/button[normalize-space()='Close']";
    public String buttonSave = "//form[@id='lead_form']/div[2]/button[@id='lead-form-submit']";
    public String alertErrorMessageRequired = "//p[starts-with(text(), 'This field is required.')]";


}
