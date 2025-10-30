package bt_locators;

public class LocatorsTasksCRM {
    public String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public String headerLoginPage = "//h1[normalize-space() = 'Login']";
    public String inputEmail = "//input[@id='email']";
    public String inputPassword = "//input[@id='password']";
    public String buttonLogin = "//button[normalize-space()='Login']";
    public String checkboxRememberMe = "//input[@id='remember']";
    public String labelRememberMe = "//label[@for='remember']";
    public String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public String errorMessageInvalidEmailOrPassword = "//div[@id='alerts']/div";
    public String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Locators for menu Tasks
    public String menuTasks = "//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Tasks']";

    //Locators for Task Page
    public String urlTasks = "https://crm.anhtester.com/admin/tasks";
    public String headerTasksPage = "//span[normalize-space()='Tasks Summary']";
    public String buttonNewTasks= "//a[normalize-space()='New Task']";


    // Locators for Add New Leads Page

    public String checkboxPublic = "//input[@id='task_is_public']";
    public String labelPublic = "//input[@id='task_is_public']/following-sibling::label";

    public String checkboxBillable= "//input[@id='task_is_billable']";
    public String labelBillable = "//input[@id='task_is_billable']/following-sibling::label";

    public String linkAttachFiles = "//div[@id='new-task-attachments']/preceding-sibling::a";

    public String labelAttachment = "//div[@id='new-task-attachments']/descendant::label";
    public String inputAttachment = "//div[@id='new-task-attachments']/descendant::input[@name='attachments[0]']";
    public String buttonAddAttachment = "//input[@name='attachments[0]']/following::button[contains(@class,'add_more_attachments')]";
    public String buttonRemoteAttachment = "(//div[@class='attachment']//button[contains(@class,'remove_attachment')])[1]";

    public String labelSubject = "//div[@app-field-wrapper='name']/label";
    public String inputSubject= "//input[@id='name']";

    public String labelHourlyRate = "//div[@app-field-wrapper='hourly_rate']/label[@for='hourly_rate']";
    public String inputHourlyRate = "//input[@id='hourly_rate']";

    public String labelStartDate = "//div[@app-field-wrapper='startdate']/label[@for='startdate']";
    public String inputStartDate = "//div[@app-field-wrapper='startdate']//input[@id='startdate']";
    public String iconStartDate = "//input[@id='startdate']/following-sibling::div";


    public String labelDueDate = "//label[@for='duedate']";
    public String inputDueDate = "//input[@id='duedate']";
    public String iconDueDate= "//input[@id='duedate']/following-sibling::div";


    public String labelPrioryty = "//label[@for='priority']";
    public String dropdownPrioryty = "//button[@data-id='priority']";
    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    public static String dropdownListPrioryty(String valuePrioryty) {
        String xpathPrioryty = "//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +valuePrioryty+ "']";
        return xpathPrioryty;
    }


    public String labelRepeatEvery = "//label[@for='repeat_every']";
    public String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String dropdownListRepeatEvery(String valueRepeatEvery) {
        String xpathRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +valueRepeatEvery+ "']";
        return xpathRepeatEvery;
    }


    public String labelTotalCycles = "//label[@for='cycles']";
    public String inputTotalCycles = "//input[@id='cycles']";
    public String checkboxInfinity = "//input[@id='unlimited_cycles']";
    public String labelInfinity = "//label[@for='unlimited_cycles']";


    public String labelRepeatTo = "//label[@for='rel_type']";
    public String dropdownRepeatTo = "//button[@data-id='rel_type']";
    public static String dropdownListRepeatTo(String valueRepeatTo) {
        String xpathRepeatTo = "//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']";
        return xpathRepeatTo;
    }


    public String labelValueForRepeatTo = "//label[@for='rel_id']";
    public String dropdownValueForRepeatTo = "//button[@data-id='rel_id']";
    public String inputSearchValueForRepeatTo = "//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";


    public String labelAssignees = "//label[@for='assignees']";
    public String dropdownAssignees = "//button[@data-id='assignees']";
    public String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String dropdownListAssignees(String valueAssignees) {
        String xpathAssignees = "//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +valueAssignees+ "']";
        return xpathAssignees;
    }


    public String labelFollowers = "//label[@for='followers[]']";
    public String dropdownFollowers= "//button[@data-id='followers[]']";
    public String inputSearchFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String dropdownListFollowers(String valueFollowers) {
        String xpathFollowers = "//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +valueFollowers+ "']";
        return xpathFollowers;
    }


    public String labelTag = "//label[@for='tags']";
    public String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public String dropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']";
    public static String dropdownListTag (String valueTag ) {
        String xpathTag  = "//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +valueTag+ "']";
        return xpathTag ;
    }

    public String labelTaskDescription = "//div[@id='inputTagsWrapper']/following::p[text()='Task Description']";
    public String inputTaskDescription = "//iframe[@id='description_ifr']";

    public String buttonClose= "//button[@type='submit' and text()='Save']/preceding-sibling::button";

    public String buttonSave = "//button[@type='submit' and text()='Save']";

    public String alertErrorMessageRequired = "//p[@id='name-error' and text()='This field is required.']";


}
