package pages;

import keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.util.List;


public class TasksPage {
    private WebDriver driver;

    public TasksPage(WebDriver driver){
        this.driver = driver;
    }

    private By url = By.xpath("https://crm.anhtester.com/admin/authentication");

    //Locators for Login Page
    private By headerLoginPage = By.xpath("//h1[normalize-space() = 'Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By checkboxRememberMe = By.xpath("//input[@id='remember']");
    private By labelRememberMe = By.xpath("//label[@for='remember']");
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password?']");
    private By errorMessageInvalidEmailOrPassword = By.xpath("//div[@id='alerts']/div");
    private By alertErrorMessageEmailRequired = By.xpath("//div[text()='The Email Address field is required.']");
    private By alertErrorMessagePasswordRequired = By.xpath("//div[text()='The Password field is required.']");

    //Locators for menu Tasks
    private By menuTasks = By.xpath("//ul[@id='side-menu']//span[@class='menu-text' and normalize-space()='Tasks']");

    //Locators for Task Page
    private By urlTasks = By.xpath("https://crm.anhtester.com/admin/tasks");
    private By headerTasksPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By buttonNewTasks = By.xpath("//a[normalize-space()='New Task']");


    private By inputSearch = By.xpath("//div[@id='tasks_filter']//input[@type='search']");
    // Tìm kiếm phần tử đầu tiên của bảng
    private By firstRowItemTasks = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]/a");
    private By iconCloseProfile = By.xpath("//div[@id='task-modal']//button[@class='close']");


    private By firstRow = By.xpath("//table[@id='tasks']//tbody/tr[1]/td[3]");

    private By linkEdit = By.xpath("//table[@id='tasks']/tbody/tr[1]//a[normalize-space()='Edit']");
    private By inputEditTag = By.xpath("//div[@id='inputTagsWrapper']/input[@id='tags']");

    // Locators for Add New Leads Page
    private By headerAddNewTask = By.xpath("//div[@id='_task_modal']//h4[normalize-space()='Add new task']");

    private By checkboxPublic = By.xpath("//input[@id='task_is_public']");
    private By labelPublic = By.xpath("//input[@id='task_is_public']/following-sibling::label");

    private By checkboxBillable= By.xpath("//input[@id='task_is_billable']");
    private By labelBillable = By.xpath("//input[@id='task_is_billable']/following-sibling::label");

    private By linkAttachFiles = By.xpath("//div[@id='new-task-attachments']/preceding-sibling::a");

    private By labelAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::label");
    private By inputAttachment = By.xpath("//div[@id='new-task-attachments']/descendant::input[@name='attachments[0]']");
    private By buttonAddAttachment = By.xpath("//input[@name='attachments[0]']/following::button[contains(@class,'add_more_attachments')]");

    // dùng hàm linh động
    private By buttonRemoteAttachment = By.xpath("(//div[@class='attachment']//button[contains(@class,'remove_attachment')])[1]");

    private By labelSubject = By.xpath("//div[@app-field-wrapper='name']/label");
    private By inputSubject= By.xpath("//input[@id='name']");

    private By labelHourlyRate = By.xpath("//div[@app-field-wrapper='hourly_rate']/label[@for='hourly_rate']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");

    private By labelStartDate = By.xpath("//div[@app-field-wrapper='startdate']/label[@for='startdate']");
    private By inputStartDate = By.xpath("//div[@app-field-wrapper='startdate']//input[@id='startdate']");
    private By iconStartDate = By.xpath("//input[@id='startdate']/following-sibling::div");


    private By labelDueDate = By.xpath("//label[@for='duedate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    private By iconDueDate= By.xpath("//input[@id='duedate']/following-sibling::div");


    private By labelPrioryty = By.xpath("//label[@for='priority']");
    private By dropdownPrioryty = By.xpath("//button[@data-id='priority']");
    // dùng hàm, vì giá trị có thể thay đổi, dùng hàm để truyền giá trị vào
    private By getValuePrioryty(String valuePrioryty) {
        By xpathPrioryty = By.xpath("//button[@data-id='priority']/following-sibling::div//span[normalize-space()='" +valuePrioryty+ "']");
        return xpathPrioryty;
    }


    private By labelRepeatEvery = By.xpath("//label[@for='repeat_every']");
    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
    private By getValueRepeatEvery(String valueRepeatEvery) {
        By xpathRepeatEvery = By.xpath("//button[@data-id='repeat_every']/following-sibling::div//span[normalize-space()='" +valueRepeatEvery+ "']");
        return xpathRepeatEvery;
    }


    private By labelTotalCycles = By.xpath("//label[@for='cycles']");
    private By inputTotalCycles = By.xpath("//input[@id='cycles']");
    private By checkboxInfinity = By.xpath("//input[@id='unlimited_cycles']");
    private By labelInfinity = By.xpath("//label[@for='unlimited_cycles']");


    private By labelRepeatTo = By.xpath("//label[@for='rel_type']");
    private By dropdownRepeatTo = By.xpath("//button[@data-id='rel_type']");
    private By getValueRepeatTo(String valueRepeatTo) {
        By xpathRepeatTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//span[normalize-space()='" +valueRepeatTo+ "']");
        return xpathRepeatTo;
    }


    private By labelValueForRepeatTo = By.xpath("//label[@for='rel_id']");
    private By dropdownValueForRepeatTo = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input[@type='search']");
    private By getValueForRepeatTo(String valueForRepeatTo) {
        By xpathValueForRepeatTo = By.xpath("//button[@data-id='rel_id']/following-sibling::div//span[normalize-space()='"+valueForRepeatTo +"']");
        return xpathValueForRepeatTo;
    }


    private By labelAssignees = By.xpath("//label[@for='assignees']");
    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By listSelectedDropdownAssignees = By.xpath("//select[@id='assignees']/following-sibling::div//ul//li[@class='selected']");
    private By inputSearchAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//input[@type='search']");
    private By getValueAssignees(String valueAssignees) {
        By xpathAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//span[normalize-space()='" +valueAssignees+ "']");
        return xpathAssignees;
    }


    private By labelFollowers = By.xpath("//label[@for='followers[]']");
    private By dropdownFollowers= By.xpath("//button[@data-id='followers[]']");
    private By listSelectedDropdownFollowers = By.xpath("//select[@id='followers[]']/following-sibling::div//ul//li[@class='selected']");
    private By inputSearchFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//input[@type='search']");
    private By getValueFollowers(String valueFollowers) {
        By xpathFollowers = By.xpath("//button[@data-id='followers[]']/following-sibling::div//span[normalize-space()='" +valueFollowers+ "']");
        return xpathFollowers;
    }


    private By labelTag = By.xpath("//label[@for='tags']");
    private By inputTag = By.xpath("//div[@id='inputTagsWrapper']//input[@placeholder='Tag']");
    private By listdropdownTag = By.xpath("//div[@id='inputTagsWrapper']//ul[@id='ui-id-2']//div");
    private By getValueTag (String valueTag ) {
        By xpathTag  = By.xpath("//input[@id='tags']/following-sibling::ul[@id='ui-id-2']//div[normalize-space()='" +valueTag+ "']");
        return xpathTag ;
    }
    private By iconCloseTag = By.xpath("//a[@class='tagit-close' and normalize-space()='×']");

    private By labelTaskDescription = By.xpath("//div[@id='inputTagsWrapper']/following::p[text()='Task Description']");
    private By inputDescription = By.xpath("//textarea[@id='description']");
    //private By inputTaskDescription = By.xpath("//iframe[@id='description_ifr']");
    private By iframeDescription = By.xpath("//body[@id='tinymce']");

    private By buttonClose= By.xpath("//button[@type='submit' and text()='Save']/preceding-sibling::button");

    private By buttonSave = By.xpath("//button[@type='submit' and text()='Save']");

    private By alertErrorMessageRequired = By.xpath("//p[@id='name-error' and text()='This field is required.']");



    public void verifyMenuTask() throws InterruptedException {
        //click menu Lead
        WebUI.clickElement(driver, menuTasks);
        Thread.sleep(1000);

        Assert.assertTrue(WebUI.checkExistsElement(driver, headerTasksPage), "Không truy cập được vào trang Tasks!");
    }


    public void verifyBtnAddNewTask() throws InterruptedException {
        //click button New Lead
        // driver.findElement(By.xpath(buttonNewTasks)).click();
        WebUI.clickElement(driver, buttonNewTasks);
        Thread.sleep(1000);
        Assert.assertTrue(WebUI.checkExistsElement(driver, headerAddNewTask), "Mở popup Add New Task không thành công");

    }

    public  void addNewTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                    String totalCycles, String relatedTo,
                                    String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException{

        Actions action = new Actions(driver);

        boolean isSelectedPublic = WebUI.checkSeletedElement(driver, checkboxPublic);
        if(isSelectedPublic == false)
        {
            WebUI.actionClick(driver, checkboxPublic);
        }



        boolean isSelectedBillable = WebUI.checkSeletedElement(driver, checkboxBillable);
        if(isSelectedBillable == true)
        {
            WebUI.actionClick(driver, checkboxBillable);
        }

        WebUI.actionClick(driver, linkAttachFiles);
        WebUI.actionSendKeys(driver, inputSubject, subject);


        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.actionSendKeys(driver, inputHourlyRate, hourlyRate);

        WebUI.clearTextElement(driver, inputStartDate);
        WebUI.actionSendKeys(driver, inputStartDate, startDate);

        WebUI.actionSendKeys(driver, inputDueDate, dueDate);

        WebUI.actionClick(driver, dropdownPrioryty);
        WebUI.actionClick(driver, getValuePrioryty(priority));

        WebUI.actionClick(driver, dropdownRepeatEvery);
        WebUI.actionClick(driver, getValueRepeatEvery(repeatEvery));


        boolean isSelectedInfinity = WebUI.checkSeletedElement(driver, checkboxInfinity);
        if(isSelectedInfinity == true)
        {
            WebUI.actionClick(driver, checkboxInfinity);
        }


        WebUI.clearTextElement(driver, inputTotalCycles);
        WebUI.actionSendKeys(driver, inputTotalCycles, totalCycles);

        WebUI.scrollAtBottom(driver, buttonSave);


        WebUI.actionClick(driver, dropdownRepeatTo);
        WebUI.actionClick(driver, getValueRepeatTo(relatedTo));


//        WebUI.actionClick(driver, dropdownValueForRepeatTo);
//        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, typeRelatedTo);
//        Thread.sleep(1000);
//       WebUI.setTextElement(driver, inputSearchValueForRepeatTo, " ");
//        WebUI.actionClick(driver, getValueForRepeatTo(typeRelatedTo));

        WebUI.clickElement(driver, dropdownValueForRepeatTo);
        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, typeRelatedTo);
        WebUI.sleep(1);
        Actions actions = new Actions(driver);
        actions.click(WebUI.getWebElement(driver, inputSearchValueForRepeatTo)).sendKeys(" ").build().perform();
        WebUI.clickElement(driver, getValueForRepeatTo(typeRelatedTo));
        WebUI.sleep(3);


        //Assignees
        WebUI.actionClick(driver, dropdownAssignees);
        List<WebElement> selectedAssignees = WebUI.getWebElements(driver, listSelectedDropdownAssignees);
        for (WebElement cb : selectedAssignees) {
            cb.click();
            Thread.sleep(1000);
        }
        WebUI.actionClick(driver, labelAssignees);


        WebUI.actionClick(driver, dropdownAssignees);
        WebUI.actionSendKeys(driver, inputSearchAssignees, assignee);
        WebUI.actionClick(driver, getValueAssignees(assignee));

        //Followers
        WebUI.actionClick(driver, dropdownFollowers);
        List<WebElement> selectedFollowers = WebUI.getWebElements(driver, listSelectedDropdownFollowers);
        for (WebElement cb : selectedFollowers) {
            cb.click();
            Thread.sleep(1000);
        }
        WebUI.actionClick(driver, labelFollowers);


        WebUI.actionClick(driver, dropdownFollowers);
        WebUI.actionSendKeys(driver, inputSearchFollowers, follower);
        WebUI.actionClick(driver, getValueFollowers(follower));


        // Tag
        WebUI.actionClick(driver, inputTag);
        Thread.sleep(1000);
        List<WebElement> allOptions = WebUI.getWebElements(driver, listdropdownTag);
        for (WebElement option : allOptions) {
            if (option.getText().equals(tag)) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }


        WebUI.actionClick(driver, buttonSave);
        Thread.sleep(1000);

        // Check sau khi save có lỗi required không
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
        Thread.sleep(1000);

    }

    public void searchTasks(String tasksName) throws InterruptedException {
        WebUI.clickElement(driver, iconCloseProfile);
        WebUI.clickElement(driver, menuTasks);
        WebUI.clearTextElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, tasksName);


        List<WebElement> rows = WebUI.getWebElements(driver,firstRowItemTasks);
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Task vừa tạo trong danh sách!");
        System.out.println("Đã tìm thấy Task search: " + rows.get(0).getText());
        Thread.sleep(1000);
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


    public void verifyEditTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                      String totalCycles, String relatedTo,
                                      String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException {

        WebElement firstRows = WebUI.getWebElement(driver, firstRow);
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRows).perform();
        Thread.sleep(3000);


        WebUI.clickElement(driver, linkEdit);

        //    verifyCheckboxSelected(LocatorsTasksCRM.checkboxPublic);
        //   verifyCheckboxSelected(checkboxBillable);
//        compareFieldAttribute(subject, inputSubject, "value");
//        compareFieldAttribute(hourlyRate, inputHourlyRate, "value");
//        compareFieldAttribute(startDate, inputStartDate, "value");
//        compareFieldAttribute(dueDate, inputDueDate, "value");
//        compareFieldAttribute(priority, dropdownPrioryty, "title");
//        compareFieldAttribute(repeatEvery, dropdownRepeatEvery, "title");
//    //    verifyCheckboxSelected(checkboxInfinity);
//        compareFieldAttribute(totalCycles, inputTotalCycles, "value");
//        compareFieldAttribute(relatedTo, dropdownRepeatTo, "title");
//        compareFieldAttribute(typeRelatedTo, dropdownValueForRepeatTo, "title");
//        compareFieldAttribute(tag, LocatorsTasksCRM.inputEditTag, "value");

        compareFieldAttribute(driver, subject, inputSubject, "value");
        compareFieldAttribute(driver, hourlyRate, inputHourlyRate, "value");
        compareFieldAttribute(driver, startDate, inputStartDate, "value");
        compareFieldAttribute(driver, dueDate, inputDueDate, "value");
        compareFieldAttribute(driver, priority, dropdownPrioryty, "title");
        compareFieldAttribute(driver, repeatEvery, dropdownRepeatEvery, "title");
        compareFieldAttribute(driver, totalCycles, inputTotalCycles, "value");
        compareFieldAttribute(driver, relatedTo, dropdownRepeatTo, "title");
        compareFieldAttribute(driver, typeRelatedTo, dropdownValueForRepeatTo, "title");
        //   compareFieldAttribute(driver, tag, LocatorsTasksCRM.inputEditTag, "value");

    }


    public void editTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String typeRelatedTo, String tag, String description) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();

        boolean isSelectedPublic = WebUI.checkSeletedElement(driver, checkboxPublic);
        if(isSelectedPublic == true)
        {
            WebUI.actionClick(driver, checkboxPublic);
        }

        boolean isSelectedBillable = WebUI.checkSeletedElement(driver, checkboxBillable);
        if(isSelectedBillable == false)
        {
            WebUI.actionClick(driver, checkboxBillable);
        }

        WebUI.actionClick(driver, inputSubject);
        WebUI.clearTextElement(driver, inputSubject);
        WebUI.actionSendKeys(driver, inputSubject, subject);

        WebUI.actionClick(driver, inputHourlyRate);
        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.actionSendKeys(driver, inputHourlyRate, hourlyRate);
      //  Thread.sleep(1000);

        WebUI.actionClick(driver, inputStartDate);
        WebUI.clearTextElement(driver, inputStartDate);
        WebUI.actionSendKeys(driver, inputStartDate, startDate);
      //  Thread.sleep(1000);

        WebUI.actionClick(driver, inputDueDate);
        WebUI.clearTextElement(driver, inputDueDate);
        WebUI.actionSendKeys(driver, inputDueDate, dueDate);
      //  Thread.sleep(1000);

        WebUI.actionClick(driver, dropdownPrioryty);
        WebUI.actionClick(driver, getValuePrioryty(priority));
      //  Thread.sleep(1000);


        WebUI.actionClick(driver, dropdownRepeatEvery);
        WebUI.actionClick(driver, getValueRepeatEvery(repeatEvery));
      //  Thread.sleep(1000);


        WebUI.scrollAtTop(driver, buttonSave);
     //   Thread.sleep(1000);


        WebUI.actionClick(driver, dropdownRepeatTo);
        WebUI.actionClick(driver, getValueRepeatTo(relatedTo));


        WebUI.actionClick(driver, dropdownValueForRepeatTo);
        WebUI.setTextAndKeyElement(driver, inputSearchValueForRepeatTo, typeRelatedTo, Keys.ENTER);
        Thread.sleep(1000);
        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, " ");
        WebUI.actionClick(driver, getValueForRepeatTo(typeRelatedTo));


        //tag
        WebUI.actionClick(driver, iconCloseTag);
        WebUI.actionSendKeys(driver, inputTag, tag);
        WebUI.actionClick(driver, labelTag);
        Thread.sleep(1000);
        WebUI.actionClick(driver, labelTag);


        //iframe
        WebUI.clickElement(driver, inputDescription);
        Thread.sleep(2000);
        driver.switchTo().frame("description_ifr");

        WebElement iframeDescriptions = WebUI.getWebElement(driver, iframeDescription);
        iframeDescriptions.sendKeys(description);
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        Thread.sleep(2000);

    }

    public void clickButtonSave() throws InterruptedException {
        WebUI.clickElement(driver, buttonSave);
    }

}
