package bt_locators;

public class LocatorsTasksCRM {
    public static String url = "https://crm.anhtester.com/admin/authentication";

    //Locators for Login Page
    public static String headerLoginPage = "//h1[normalize-space() = 'Login']";
    public static String inputEmail = "//input[@id='email']";
    public static String inputPassword = "//input[@id='password']";
    public static String buttonLogin = "//button[normalize-space()='Login']";
    public static String checkboxRememberMe = "//input[@id='remember']";
    public static String labelRememberMe = "//label[@for='remember']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String errorMessageInvalidEmailOrPassword = "//div[@id='alerts']/div";
    public static String alertErrorMessageEmailRequired = "//div[text()='The Email Address field is required.']";
    public static String alertErrorMessagePasswordRequired = "//div[text()='The Password field is required.']";

    //Locators for menu Tasks
    public static String menuTasks = "//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Tasks']";

    //Locators for Task Page
    public static String urlTasks = "https://crm.anhtester.com/admin/tasks";
    public static String headerTasksPage = "//span[normalize-space()='Tasks Summary']";
    public static String buttonNewTasks = "//a[normalize-space()='New Task']";


    public static String inputSearch = "//div[@id='tasks_filter']//input[@type='search']";
    // Tìm kiếm phần tử đầu tiên của bảng
    public static String firstRowItemTasks = "//table[@id='tasks']//tbody/tr[1]/td[3]/a";
    public static String iconCloseProfile = "//div[@id='task-modal']//button[@class='close']";


    public static String firstRow = "//table[@id='tasks']//tbody/tr[1]/td[3]";

    public static String linkEdit = "//table[@id='tasks']/tbody/tr[1]//a[normalize-space()='Edit']";
    public static String inputEditTag = "//div[@id='inputTagsWrapper']/input[@id='tags']";

    // Locators for Add New Leads Page
    public static String headerAddNewTask = "//div[@id='_task_modal']//h4[normalize-space()='Add new task']";

    public static String checkboxPublic = "//input[@id='task_is_public']";
    public static String labelPublic = "//input[@id='task_is_public']/following-sibling::label";

    public static String checkboxBillable= "//input[@id='task_is_billable']";
    public static String labelBillable = "//input[@id='task_is_billable']/following-sibling::label";

    public static String linkAttachFiles = "//div[@id='new-task-attachments']/preceding-sibling::a";

    public static String labelAttachment = "//div[@id='new-task-attachments']/descendant::label";
    public static String inputAttachment = "//div[@id='new-task-attachments']/descendant::input[@name='attachments[0]']";
    public static String buttonAddAttachment = "//input[@name='attachments[0]']/following::button[contains(@class,'add_more_attachments')]";

    // dùng hàm linh động
    public static String buttonRemoteAttachment = "(//div[@class='attachment']//button[contains(@class,'remove_attachment')])[1]";

    public static String labelSubject = "//div[@app-field-wrapper='name']/label";
    public static String inputSubject= "//input[@id='name']";

    public static String labelHourlyRate = "//div[@app-field-wrapper='hourly_rate']/label[@for='hourly_rate']";
    public static String inputHourlyRate = "//input[@id='hourly_rate']";

    public static String labelStartDate = "//div[@app-field-wrapper='startdate']/label[@for='startdate']";
    public static String inputStartDate = "//div[@app-field-wrapper='startdate']//input[@id='startdate']";
    public static String iconStartDate = "//input[@id='startdate']/following-sibling::div";


    public static String labelDueDate = "//label[@for='duedate']";
    public static String inputDueDate = "//input[@id='duedate']";
    public static String iconDueDate= "//input[@id='duedate']/following-sibling::div";


    public static String labelPrioryty = "//label[@for='priority']";
    public static String dropdownPrioryty = "//button[@data-id='priority']";
    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    public static String getValuePrioryty(String valuePrioryty) {
        String xpathPrioryty = "//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +valuePrioryty+ "']";
        return xpathPrioryty;
    }


    public static String labelRepeatEvery = "//label[@for='repeat_every']";
    public static String dropdownRepeatEvery = "//button[@data-id='repeat_every']";
    public static String getValueRepeatEvery(String valueRepeatEvery) {
        String xpathRepeatEvery = "//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +valueRepeatEvery+ "']";
        return xpathRepeatEvery;
    }


    public static String labelTotalCycles = "//label[@for='cycles']";
    public static String inputTotalCycles = "//input[@id='cycles']";
    public static String checkboxInfinity = "//input[@id='unlimited_cycles']";
    public static String labelInfinity = "//label[@for='unlimited_cycles']";


    public static String labelRepeatTo = "//label[@for='rel_type']";
    public static String dropdownRepeatTo = "//button[@data-id='rel_type']";
    public static String getValueRepeatTo(String valueRepeatTo) {
        String xpathRepeatTo = "//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']";
        return xpathRepeatTo;
    }


    public static String labelValueForRepeatTo = "//label[@for='rel_id']";
    public static String dropdownValueForRepeatTo = "//button[@data-id='rel_id']";
    public static String inputSearchValueForRepeatTo = "//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";
    public static String getValueForRepeatTo(String valueForRepeatTo) {
        String xpathValueForRepeatTo = "//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']";
        return xpathValueForRepeatTo;
    }

    public static String labelAssignees = "//label[@for='assignees']";
    public static String dropdownAssignees = "//button[@data-id='assignees']";
    public static String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String getValueAssignees(String valueAssignees) {
        String xpathAssignees = "//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +valueAssignees+ "']";
        return xpathAssignees;
    }


    public static String labelFollowers = "//label[@for='followers[]']";
    public static String dropdownFollowers= "//button[@data-id='followers[]']";
    public static String inputSearchFollowers = "//button[@data-id='followers[]']/following-sibling::div//input[@type='search']";
    public static String getValueFollowers(String valueFollowers) {
        String xpathFollowers = "//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +valueFollowers+ "']";
        return xpathFollowers;
    }


    public static String labelTag = "//label[@for='tags']";
    public static String inputTag = "//div[@id='inputTagsWrapper']//input[@placeholder='Tag']";
    public static String listdropdownTag = "//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div";
    public static String getValueTag (String valueTag ) {
        String xpathTag  = "//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +valueTag+ "']";
        return xpathTag ;
    }
    public static String iconCloseTag = "//a[@class='tagit-close' and normalize-space()='×']";

    public static String labelTaskDescription = "//div[@id='inputTagsWrapper']/following::p[text()='Task Description']";
    public static String inputDescription = "//textarea[@id='description']";
    //public static String inputTaskDescription = "//iframe[@id='description_ifr']";
    public static String iframeDescription = "//body[@id='tinymce']";

    public static String buttonClose= "//button[@type='submit' and text()='Save']/preceding-sibling::button";

    public static String buttonSave = "//button[@type='submit' and text()='Save']";

    public static String alertErrorMessageRequired = "//p[@id='name-error' and text()='This field is required.']";


}
