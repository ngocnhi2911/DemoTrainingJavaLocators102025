package bt_locators;

import org.openqa.selenium.By;

public class LocatorsTasksCRM {
    public static By url = By.xpath("https://crm.anhtester.com/admin/authentication");

    //Locators for Login Page
    public static By headerLoginPage = By.xpath("//h1[normalize-space() = 'Login']");
    public static By inputEmail = By.xpath("//input[@id='email']");
    public static By inputPassword = By.xpath("//input[@id='password']");
    public static By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    public static By checkboxRememberMe = By.xpath("//input[@id='remember']");
    public static By labelRememberMe = By.xpath("//label[@for='remember']");
    public static By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    public static By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div");
    public static By alertErrorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.']");
    public static By alertErrorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.']");

    //Locators for menu Tasks
    public static By menuTasks = By.xpath("//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Tasks']");

    //Locators for Task Page
    public static By urlTasks = By.xpath("https://crm.anhtester.com/admin/tasks");
    public static By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    public static By buttonNewTasks = By.xpath("//a[normalize-space()='New Task']");


    public static By inputSearch = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    // Tìm kiếm phần tử đầu tiên của bảng
    public static By firstRowItemTasks = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");
    public static By iconCloseProfile = By.xpath("//div[@id='task-modal']//button[@class='close']");


    public static By firstRow = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]");

    public static By linkEdit = By.xpath("//table[@id='tasks']/tbody/tr[1]//a[normalize-space()='Edit']");
    public static By inputEditTag = By.xpath("//div[@id='inputTagsWrapper']/input[@id='tags']");

    // Locators for Add New Leads Page
    public static By headerAddNewTask = By.xpath("//div[@id='_task_modal']//h4[normalize-space()='Add new task']");

    public static By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    public static By labelPublic = By.xpath("//input[@id='task_is_public']/following-sibling::label");

    public static By checkboxBillable= By.xpath("//input[@id='task_is_billable']");
    public static By labelBillable = By.xpath("//input[@id='task_is_billable']/following-sibling::label");

    public static By linkAttachFiles = By.xpath("//div[@id='new-task-attachments']/preceding-sibling::a");

    public static By labelAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::label");
    public static By inputAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@name='attachments[0]']");
    public static By buttonAddAttachment = By.xpath("//input[@name='attachments[0]']/following::button[contains(@class,'add_more_attachments')]");

    // dùng hàm linh động
    public static By buttonRemoteAttachment = By.xpath("(//div[@class='attachment']//button[contains(@class,'remove_attachment')])[1]");

    public static By labelSubject = By.xpath("//div[@app-field-wrapper='name']/label");
    public static By inputSubject= By.xpath("//input[@id='name']");

    public static By labelHourlyRate = By.xpath("//div[@app-field-wrapper='hourly_rate']/label[@for='hourly_rate']");
    public static By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");

    public static By labelStartDate = By.xpath("//div[@app-field-wrapper='startdate']/label[@for='startdate']");
    public static By inputStartDate = By.xpath("//div[@app-field-wrapper='startdate']//input[@id='startdate']");
    public static By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div");


    public static By labelDueDate = By.xpath("//label[@for='duedate']");
    public static By inputDueDate = By.xpath("//input[@id='duedate']");
    public static By iconDueDate= By.xpath("//input[@id='duedate']/following-sibling::div");


    public static By labelPrioryty = By.xpath("//label[@for='priority']");
    public static By dropdownPrioryty = By.xpath("//button[@data-id='priority']");
    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    public static By getValuePrioryty(String valuePrioryty) {
        By xpathPrioryty = By.xpath("//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +valuePrioryty+ "']");
        return xpathPrioryty;
    }


    public static By labelRepeatEvery = By.xpath("//label[@for='repeat_every']");
    public static By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
    public static By getValueRepeatEvery(String valueRepeatEvery) {
        By xpathRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +valueRepeatEvery+ "']");
        return xpathRepeatEvery;
    }


    public static By labelTotalCycles = By.xpath("//label[@for='cycles']");
    public static By inputTotalCycles = By.xpath("//input[@id='cycles']");
    public static By checkboxInfinity = By.xpath("//input[@id='unlimited_cycles']");
    public static By labelInfinity = By.xpath("//label[@for='unlimited_cycles']");


    public static By labelRepeatTo = By.xpath("//label[@for='rel_type']");
    public static By dropdownRepeatTo = By.xpath("//button[@data-id='rel_type']");
    public static By getValueRepeatTo(String valueRepeatTo) {
        By xpathRepeatTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']");
        return xpathRepeatTo;
    }


    public static By labelValueForRepeatTo = By.xpath("//label[@for='rel_id']");
    public static By dropdownValueForRepeatTo = By.xpath("//button[@data-id='rel_id']");
    public static By inputSearchValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");
    public static By getValueForRepeatTo(String valueForRepeatTo) {
        By xpathValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']");
        return xpathValueForRepeatTo;
    }


    public static By labelAssignees = By.xpath("//label[@for='assignees']");
    public static By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    public static By listSelectedDropdownAssignees = By.xpath("//select[@id='assignees']/following-sibling::div//ul//li[@class='selected']");
    public static By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");
    public static By getValueAssignees(String valueAssignees) {
        By xpathAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +valueAssignees+ "']");
        return xpathAssignees;
    }


    public static By labelFollowers = By.xpath("//label[@for='followers[]']");
    public static By dropdownFollowers= By.xpath("//button[@data-id='followers[]']");
    public static By listSelectedDropdownFollowers = By.xpath("//select[@id='followers[]']/following-sibling::div//ul//li[@class='selected']");
    public static By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");
    public static By getValueFollowers(String valueFollowers) {
        By xpathFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +valueFollowers+ "']");
        return xpathFollowers;
    }


    public static By labelTag = By.xpath("//label[@for='tags']");
    public static By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    public static By listdropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div");
    public static By getValueTag (String valueTag ) {
        By xpathTag  = By.xpath("//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +valueTag+ "']");
        return xpathTag ;
    }
    public static By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");

    public static By labelTaskDescription = By.xpath("//div[@id='inputTagsWrapper']/following::p[text()='Task Description']");
    public static By inputDescription = By.xpath("//textarea[@id='description']");
    //public static By inputTaskDescription = By.xpath("//iframe[@id='description_ifr']");
    public static By iframeDescription = By.xpath("//body[@id='tinymce']");

    public static By buttonClose= By.xpath("//button[@type='submit' and text()='Save']/preceding-sibling::button");

    public static By buttonSave = By.xpath("//button[@type='submit' and text()='Save']");

    public static By alertErrorMessageRequired = By.xpath("//p[@id='name-error' and text()='This field is required.']");


}
