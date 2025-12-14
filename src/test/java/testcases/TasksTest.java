package testcases;

import common.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.LoginPage;
import pages.TasksPage;

public class TasksTest extends BaseTest {
    String taskName = "Yến Nhi Task 1";
    String hourlyRate = "10";
    String startDate = "14-12-2025";
    String dueDate = "18-12-2025";
    String priority = "High";
    String repeatEvery = "1 Month";
    String totalCycles = "56622";
    String relatedTo = "Customer";
    String typeRelatedTo = "Anh Tester 2811A2";
    String assignee = "Admin Anh Tester";
    String follower = "Admin Example";
    String tag = "JSC_NEW";
    String description;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private TasksPage tasksPage;
    private LeadsPage leadsPage;


    @Test(priority = 1)
    public void testAddAndVerifyTask(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();

        TasksTest btTasks = new TasksTest();

        btTasks.taskName = "Yến Nhi Task 1";

        tasksPage.clickBtnAddNewTask();
        tasksPage.addNewTasks(btTasks.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);
        tasksPage.clickButtonSave();
        tasksPage.clickClosePopupTaskDetail(btTasks.taskName, 0);
        tasksPage.searchTasks(btTasks.taskName);

        tasksPage.verifyEditTask(btTasks.taskName, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);

    }

    @Test(priority = 2)
    public void testEditask() throws InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        tasksPage = dashboardPage.clickMenuTask();

        TasksTest btTasks = new TasksTest();

        btTasks.taskName = "Yến Nhi Task 2";

        tasksPage.clickBtnAddNewTask();
        tasksPage.addNewTasks(btTasks.taskName, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);
        tasksPage.clickButtonSave();
        tasksPage.clickClosePopupTaskDetail(btTasks.taskName, 0);
        tasksPage.searchTasks(btTasks.taskName);

        tasksPage.verifyEditTask(btTasks.taskName, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);

        btTasks.taskName = "Yến Nhi Task 2";
        btTasks.hourlyRate  = "20";
        btTasks.startDate  = "20-12-2025";
        btTasks.dueDate  = "25-12-2025";
        btTasks.priority  = "High";
        btTasks.repeatEvery  = "2 Months";
        btTasks.relatedTo  = "Lead";
        btTasks.typeRelatedTo  = "Yến Nhi";
        btTasks.tag = "HTest";
        btTasks.description = "description iframe";

        tasksPage.editTasks(btTasks.taskName, btTasks.hourlyRate, btTasks.startDate, btTasks.dueDate ,  btTasks.priority , btTasks.repeatEvery , btTasks.relatedTo , btTasks.typeRelatedTo, btTasks.tag,  btTasks.description);
        tasksPage.clickButtonSave();
        tasksPage.clickClosePopupTaskDetail(btTasks.taskName, 1);
        tasksPage.searchTasks(btTasks.taskName);

    }
/*
    @Test(priority = 3)
    public void testAddLeadAndTask() throws InterruptedException{
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();

        leadsPage = dashboardPage.clickMenuLead();
        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 6";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi6@gmail.com";
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

        //click btn addnewLead
        leadsPage.clickIconLeadsSummary();
        leadsPage.verifyLeadSummaryDisplay();
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName, 0);
        leadsPage.searchLeads(testBT.leadName);

        tasksPage = dashboardPage.clickMenuTask();

        TasksTest btTasks = new TasksTest();

        btTasks.taskName = testBT.leadName + " - " + testBT.emailAddress;
        btTasks.hourlyRate = "10";
        btTasks.startDate = "14-12-2025";
        btTasks.dueDate = "18-12-2025";
        btTasks.priority = "High";
        btTasks.repeatEvery = "1 Month";
        btTasks.totalCycles = "56622";
        btTasks.relatedTo = "Lead";
       // btTasks.typeRelatedTo = "Yến Nhi";
        btTasks.typeRelatedTo = testBT.leadName;
        btTasks.assignee = "Admin Anh Tester";
        btTasks.follower = "Admin Example";
        btTasks.tag = "JSC_NEW";

        tasksPage.clickBtnAddNewTask();
        tasksPage.addNewTasks(btTasks.taskName, btTasks.hourlyRate, btTasks.startDate, btTasks.dueDate, btTasks.priority, btTasks.repeatEvery, btTasks.totalCycles, btTasks.relatedTo, btTasks.typeRelatedTo, btTasks.assignee, btTasks.follower, btTasks.tag);
        tasksPage.clickButtonSave();
        tasksPage.clickClosePopupTaskDetail(btTasks.taskName, 0);
        tasksPage.searchTasks(btTasks.taskName);
    }

 */
}
