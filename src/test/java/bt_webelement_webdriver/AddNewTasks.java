package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import bt_locators.LocatorsTasksCRM;
import common.BaseTest;
import login_crm.LoginCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.buttonNewLead;
import static bt_locators.LocatorsLeadsCRM.headerAddNewLead;
import static bt_locators.LocatorsTasksCRM.*;
import static login_crm.LoginCRM.*;
// import static bt_webelement_webdriver.AddNewLeads.addNewLeads;


public class AddNewTasks extends BaseTest {



//    public static void verifyMenuTasks() throws InterruptedException {
//        //click menu Lead
//        driver.findElement(By.xpath(menuTasks)).click();
//        Thread.sleep(2000);
//        verifyDisplay(headerTasksPage, "Đã tới trang Tasks", "FAILED!!! Không truy cập được vào trang Tasks");
//
//    }
//
//    public static void verifyBtnAddNewTasks() throws InterruptedException {
//        //click button New Lead
//        driver.findElement(By.xpath(buttonNewTasks)).click();
//        Thread.sleep(1000);
//        verifyDisplay(headerAddNewTask, "Mở pop-up Add new task thành công", "FAILED!!! Không mở được pop-up Add new task");
//
//    }

    public void verifyMenuTask() throws InterruptedException {
        //click menu Lead
        driver.findElement(By.xpath(menuTasks)).click();
        Thread.sleep(2000);
        Assert.assertTrue(checkExistsElement(headerTasksPage), "Không truy cập được vào trang Tasks!");
    }


    public void verifyBtnAddNewTask() throws InterruptedException {
        //click button New Lead
        driver.findElement(By.xpath(buttonNewTasks)).click();
        Thread.sleep(1000);
        Assert.assertTrue(checkExistsElement(headerAddNewTask), "Mở popup Add New Task không thành công");

    }

    public static void addNewTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                    String totalCycles, String relatedTo,
                                    String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException{

        Actions action = new Actions(driver);

        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).isSelected();
        if(isSelectedPublic == false)
        {
            action.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic))).perform();
        }
        Thread.sleep(1000);


        boolean isSelectedBillable = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).isSelected();
        if(isSelectedBillable == true)
        {
            action.click(driver.findElement(By.xpath(checkboxBillable))).perform();
        }
        Thread.sleep(1000);


        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.linkAttachFiles))).perform();
        Thread.sleep(1000);

        // driver.findElement(By.xpath(LocatorsTasksCRM.inputSubject)).sendKeys(subject);
        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSubject)), subject).perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)).clear();
        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)), hourlyRate).perform();
        Thread.sleep(1000);


//        // B1: Lấy thời gian hiện tại
//        LocalDateTime now = LocalDateTime.now();
//        // B2: Định dạng theo format của hệ thống
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String currentDateTime = now.format(formatter);
//        // B3
        WebElement dateStartDate= driver.findElement(By.xpath(LocatorsTasksCRM.inputStartDate));
        dateStartDate.clear();
        action.sendKeys(dateStartDate, startDate).perform();
        Thread.sleep(1000);



//        // B1: Lấy thời gian hiện tại và cộng thêm 1 ngày
//        LocalDateTime now1 = LocalDateTime.now().plusDays(1);
//        // B2: Định dạng theo format của hệ thống
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String currentDateTime1 = now1.format(formatter1);
//        //B3
        WebElement dateDueDate = driver.findElement(By.xpath(LocatorsTasksCRM.inputDueDate));
        action.sendKeys(dateDueDate, dueDate).perform();
        Thread.sleep(1000);


        // B1: Click mở dropdown Prioryty
        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownPrioryty))).perform();
        Thread.sleep(1000);
        String xpathPrioryty = getValuePrioryty(priority);
        Thread.sleep(1000);
        // B4: Tìm phần tử tương ứng và click
        action.click(driver.findElement(By.xpath(xpathPrioryty))).perform();
        Thread.sleep(3000);
        //-------------



        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatEvery))).perform();
        Thread.sleep(1000);
        String xpathRepeatEvery = getValueRepeatEvery(repeatEvery);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath(xpathRepeatEvery))).perform();
        Thread.sleep(3000);


        boolean isSelectedInfinity = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity)).isSelected();
        if(isSelectedInfinity == true)
        {
            action.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity))).perform();
        }
        Thread.sleep(2000);

        WebElement inpTotalCycles = driver.findElement(By.xpath(LocatorsTasksCRM.inputTotalCycles));
        inpTotalCycles.clear();
        action.sendKeys(inpTotalCycles, totalCycles).perform();


        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatTo))).perform();
        Thread.sleep(1000);
        String xpathRepeatTo = getValueRepeatTo(relatedTo);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath(xpathRepeatTo))).perform();
        Thread.sleep(3000);
        //-------------


        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownValueForRepeatTo))).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchValueForRepeatTo)), "An test 02").perform();
        String xpathValueForRepeatTo = getValueForRepeatTo(typeRelatedTo);
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath(xpathValueForRepeatTo))).perform();
        Thread.sleep(2000);



        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownAssignees))).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchAssignees)), "Admin Anh Tester").perform();
        String xpathAssignees = getValueAssignees(assignee);
        Thread.sleep(2000);
        action.click(driver.findElement(By.xpath(xpathAssignees))).perform();
        Thread.sleep(2000);


        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownFollowers))).perform();
        Thread.sleep(1000);
        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchFollowers)), "Admin Example").perform();
        String xpathFollowers = getValueFollowers(follower);
        Thread.sleep(1000);
        action.click(driver.findElement(By.xpath(xpathFollowers))).perform();
        Thread.sleep(2000);


        driver.findElement(By.xpath(LocatorsTasksCRM.inputTag)).click();  // Tag
        Thread.sleep(1000);
        List<WebElement> allOptions = driver.findElements(By.xpath(LocatorsTasksCRM.listdropdownTag));
        Thread.sleep(3000);
        for (WebElement option : allOptions) {
            if (option.getText().equals(tag)) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)).click();
        Thread.sleep(1000);
        // Check sau khi save có lỗi required không
        List<WebElement> errorsRequired = driver.findElements(By.xpath(LocatorsTasksCRM.alertErrorMessageRequired));

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

    public static void searchTasks(String tasksName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsTasksCRM.iconCloseProfile)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasksCRM.menuTasks)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).sendKeys(tasksName);
        Thread.sleep(2000);

        List<WebElement> rows = driver.findElements(By.xpath(LocatorsTasksCRM.firstRowItemTasks));
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Task vừa tạo trong danh sách!");
        System.out.println("Đã tìm thấy Task search: " + rows.get(0).getText());
        Thread.sleep(1000);
    }

    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeActual) {
        String expected = expectedValue;
        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "FAILED: Checkbox [" + checked + "] chưa được chọn.");
    }


    public static void verifyEditTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException {
        WebElement firstRow = driver.findElement(By.xpath(LocatorsTasksCRM.firstRow));
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);

        driver.findElement(By.xpath(LocatorsTasksCRM.linkEdit)).click();
        Thread.sleep(3000);

    //    verifyCheckboxSelected(LocatorsTasksCRM.checkboxPublic);
     //   verifyCheckboxSelected(checkboxBillable);
        compareFieldAttribute(subject, inputSubject, "value");
        compareFieldAttribute(hourlyRate, inputHourlyRate, "value");
        compareFieldAttribute(startDate, inputStartDate, "value");
        compareFieldAttribute(dueDate, inputDueDate, "value");
        compareFieldAttribute(priority, dropdownPrioryty, "title");
        compareFieldAttribute(repeatEvery, dropdownRepeatEvery, "title");
    //    verifyCheckboxSelected(checkboxInfinity);
        compareFieldAttribute(totalCycles, inputTotalCycles, "value");
        compareFieldAttribute(relatedTo, dropdownRepeatTo, "title");
        compareFieldAttribute(typeRelatedTo, dropdownValueForRepeatTo, "title");
        compareFieldAttribute(tag, LocatorsTasksCRM.inputEditTag, "value");

    }

    public static void pressCombo(int... keys) throws Exception {
        Robot r = new Robot();
        // Nhấn giữ tất cả phím
        for (int key : keys) {
            r.keyPress(key);
        }
        // Nhả tất cả phím
        for (int key : keys) {
            r.keyRelease(key);
        }
    }


    public static void editTasks (String subjectEdit, String hourlyRateEdit, String startDateEdit, String dueDateEdit, String priorityEdit, String repeatEveryEdit,
                                  String relatedToEdit, String typeRelatedToEdit) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();


        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).isSelected();
        if(isSelectedPublic == true)
        {
            actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic))).perform();
        }
        Thread.sleep(1000);


        boolean isSelectedBillable = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).isSelected();
        if(isSelectedBillable == false)
        {
            actions.click(driver.findElement(By.xpath(checkboxBillable))).perform();
        }
        Thread.sleep(1000);


//        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
//        pressCombo(KeyEvent.VK_DELETE);

        WebElement elementSubject = driver.findElement(By.xpath(inputSubject));
        actions.click(elementSubject).perform();
        Thread.sleep(1000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
        actions.sendKeys(elementSubject, subjectEdit).perform();
        Thread.sleep(2000);


        WebElement elementHourlyRate = driver.findElement(By.xpath(inputHourlyRate));
        actions.click(elementHourlyRate).perform();
        Thread.sleep(1000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
      //  elementHourlyRate.clear();
        actions.sendKeys(elementHourlyRate, hourlyRateEdit).perform();
        Thread.sleep(1000);

        WebElement elementStartDate = driver.findElement(By.xpath(inputStartDate));
        actions.click(elementStartDate).perform();
        Thread.sleep(2000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(2000);
        actions.sendKeys(elementStartDate, startDateEdit).perform();
        Thread.sleep(2000);

        WebElement elementDueDate= driver.findElement(By.xpath(inputDueDate));
        actions.click(elementDueDate).perform();
        Thread.sleep(1000);
        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
        pressCombo(KeyEvent.VK_DELETE);
        Thread.sleep(1000);
        actions.sendKeys(elementDueDate, dueDateEdit).perform();
        Thread.sleep(1000);



        //Priority
        actions.click(driver.findElement(By.xpath(dropdownPrioryty))).perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValuePrioryty(priorityEdit)))).perform();
        Thread.sleep(1000);

        //Repeat every
        actions.click(driver.findElement(By.xpath(dropdownRepeatEvery))).perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValueRepeatEvery(repeatEveryEdit)))).perform();
        Thread.sleep(2000);


//        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatTo))).perform();
//        Thread.sleep(1000);
//        String xpathRepeatTo = getValueRepeatTo(relatedToEdit);
//        Thread.sleep(1000);
//        actions.click(driver.findElement(By.xpath(xpathRepeatTo))).perform();
//        Thread.sleep(3000);
//        //-------------
//
//
//        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownValueForRepeatTo))).perform();
//        Thread.sleep(1000);
//        actions.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchValueForRepeatTo)), typeRelatedToEdit).perform();
//        String xpathValueForRepeatTo = getValueForRepeatTo(typeRelatedToEdit);
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath(xpathValueForRepeatTo))).perform();
//        Thread.sleep(2000);


        //Related To
        actions.click(driver.findElement(By.xpath(dropdownRepeatTo))).perform();
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValueRepeatTo(relatedToEdit)))).perform();
        Thread.sleep(2000);


        actions.click(driver.findElement(By.xpath(dropdownValueForRepeatTo))).perform();
        Thread.sleep(200);
        actions.sendKeys(driver.findElement(By.xpath(inputSearchValueForRepeatTo)), typeRelatedToEdit).perform();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        actions.click(driver.findElement(By.xpath(getValueForRepeatTo(typeRelatedToEdit)))).perform();
        Thread.sleep(2000);


   }


    public void clickButtonSave() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)).click();
        Thread.sleep(2000);
    }







    @Test(priority = 1)
    public void testAddAndVerifyTask() throws InterruptedException{
        String subject = "Yến Nhi Task 1";
        String hourlyRate = "10";
        String startDate = "14-12-2025";
        String dueDate = "18-12-2025";
        String priority = "High";
        String repeatEvery = "1 Month";
        String totalCycles = "56622";
        String relatedTo = "Customer";
        String typeRelatedTo = "An test 02";
        String assignee = "Admin Anh Tester";
        String follower = "Admin Example";
        String tag = "JSC_NEW";

        verifyMenuTask();
        verifyBtnAddNewTask();

        addNewTasks(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);

    }

    @Test(priority = 1)
    public void testEditask() throws Exception {
        String subject = "Yến Nhi Task 2";
        String hourlyRate = "10";
        String startDate = "14-12-2025";
        String dueDate = "18-12-2025";
        String priority = "High";
        String repeatEvery = "1 Month";
        String totalCycles = "56622";
        String relatedTo = "Customer";
        String typeRelatedTo = "An test 02";
        String assignee = "Admin Anh Tester";
        String follower = "Admin Example";
        String tag = "JSC_NEW";

        verifyMenuTask();
        verifyBtnAddNewTask();

        addNewTasks(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);
        Thread.sleep(2000);

        searchTasks("Yến Nhi Task 2");
        Thread.sleep(2000);

        verifyEditTask(subject, hourlyRate + ".00", startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);
        Thread.sleep(2000);


        String subjectEdit = "Yến Nhi Task 2";
        String hourlyRateEdit  = "20";
        String startDateEdit  = "20-12-2025";
        String dueDateEdit  = "25-12-2025";
        String priorityEdit  = "High";
        String repeatEveryEdit  = "2 Months";
        String relatedToEdit  = "Lead";
        String typeRelatedToEdit  = "Yến Nhi";

        editTasks(subjectEdit, hourlyRateEdit, startDateEdit, dueDateEdit , priorityEdit , repeatEveryEdit , relatedToEdit , typeRelatedToEdit);

        Thread.sleep(4000);
        clickButtonSave();
        Thread.sleep(4000);
    }
}
