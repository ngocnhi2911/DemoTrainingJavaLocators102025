package thuc_hanh;

import bt_locators.LocatorsLeadsCRM;
import bt_locators.LocatorsTasksCRM;
import common.BaseTest;
import keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

// import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsLeadsCRM.dropdownStatus;
import static bt_locators.LocatorsLeadsCRM.inputSearchStatus;
import static bt_locators.LocatorsTasksCRM.*;
// import static bt_webelement_webdriver.AddNewLeads.addNewLeads;


public class BTTasks extends BaseTest {
    String taskName = "";
    String hourlyRate = "";
    String startDate = "";
    String dueDate = "";
    String priority = "";
    String repeatEvery = "";
    String totalCycles = "";
    String relatedTo = "";
    String typeRelatedTo = "";
    String assignee = "";
    String follower = "";
    String tag = "";
    String description = "";


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

    public static void addNewTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                    String totalCycles, String relatedTo,
                                    String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException{

        Actions action = new Actions(driver);

        // boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).isSelected();
        boolean isSelectedPublic = WebUI.checkSeletedElement(driver, checkboxPublic);
        if(isSelectedPublic == false)
        {
            //action.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic))).perform();
            WebUI.actionClick(driver, checkboxPublic);
        }
        Thread.sleep(1000);


      //  boolean isSelectedBillable = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).isSelected();
        boolean isSelectedBillable = WebUI.checkSeletedElement(driver, checkboxBillable);
        if(isSelectedBillable == true)
        {
           // action.click(driver.findElement(By.xpath(checkboxBillable))).perform();
            WebUI.actionClick(driver, checkboxBillable);
        }
        Thread.sleep(1000);


        WebUI.actionClick(driver, LocatorsTasksCRM.linkAttachFiles);
        Thread.sleep(1000);

        WebUI.actionSendKeys(driver, inputSubject, subject);
     //   action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSubject)), subject).perform();
        Thread.sleep(1000);

        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.actionSendKeys(driver, inputHourlyRate, hourlyRate);
//        driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)).clear();
//        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)), hourlyRate).perform();
        Thread.sleep(1000);


        WebUI.clearTextElement(driver, inputStartDate);
        WebUI.actionSendKeys(driver, inputStartDate, startDate);
//        WebElement dateStartDate= driver.findElement(By.xpath(LocatorsTasksCRM.inputStartDate));
//        dateStartDate.clear();
//        action.sendKeys(dateStartDate, startDate).perform();
        Thread.sleep(1000);


        WebUI.actionSendKeys(driver, inputDueDate, dueDate);
//        WebElement dateDueDate = driver.findElement(By.xpath(LocatorsTasksCRM.inputDueDate));
//        action.sendKeys(dateDueDate, dueDate).perform();
        Thread.sleep(1000);


        // B1: Click mở dropdown Prioryty
     //   action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownPrioryty))).perform();
        WebUI.actionClick(driver, dropdownPrioryty);
        WebUI.actionClick(driver, getValuePrioryty(priority));
        Thread.sleep(1000);
//        String xpathPrioryty = getValuePrioryty(priority);
//        Thread.sleep(1000);
//        // B4: Tìm phần tử tương ứng và click
//        action.click(driver.findElement(By.xpath(xpathPrioryty))).perform();
//        Thread.sleep(3000);
        //-------------


        WebUI.actionClick(driver, dropdownRepeatEvery);
        WebUI.actionClick(driver, getValueRepeatEvery(repeatEvery));

//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatEvery))).perform();
//        Thread.sleep(1000);
//        String xpathRepeatEvery = getValueRepeatEvery(repeatEvery);
//        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath(xpathRepeatEvery))).perform();
//        Thread.sleep(3000);


        boolean isSelectedInfinity = WebUI.checkSeletedElement(driver, checkboxInfinity);
      //  boolean isSelectedInfinity = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity)).isSelected();
        if(isSelectedInfinity == true)
        {
            // action.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity))).perform();
            WebUI.actionClick(driver, checkboxInfinity);
        }
        Thread.sleep(2000);

//        WebElement inpTotalCycles = driver.findElement(By.xpath(LocatorsTasksCRM.inputTotalCycles));
//        inpTotalCycles.clear();
//        action.sendKeys(inpTotalCycles, totalCycles).perform();

        WebUI.clearTextElement(driver, inputTotalCycles);
        WebUI.actionSendKeys(driver, inputTotalCycles, totalCycles);

//        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)); //trỏ tới element
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", elementBtnSave);

        WebUI.scrollAtTop(driver, buttonSave);


//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatTo))).perform();
//        Thread.sleep(1000);
//        String xpathRepeatTo = getValueRepeatTo(relatedTo);
//        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath(xpathRepeatTo))).perform();
//        Thread.sleep(3000);

        WebUI.actionClick(driver, dropdownRepeatTo);
        WebUI.actionClick(driver, getValueRepeatTo(relatedTo));
        //-------------


//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownValueForRepeatTo))).perform();
//        Thread.sleep(1000);
//        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchValueForRepeatTo)), "An test 02").perform();
//        String xpathValueForRepeatTo = getValueForRepeatTo(typeRelatedTo);
//        Thread.sleep(2000);
//        action.click(driver.findElement(By.xpath(xpathValueForRepeatTo))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownValueForRepeatTo);
        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, typeRelatedTo);
        Thread.sleep(1000);
        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, " ");
       // WebUI.actionSendKeys(driver, inputSearchValueForRepeatTo, typeRelatedTo);
        WebUI.actionClick(driver, getValueForRepeatTo(typeRelatedTo));

//        WebUI.clickElement(driver, dropdownValueForRepeatTo);
//        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, typeRelatedTo);
//        WebUI.clickElement(driver, getValueForRepeatTo(typeRelatedTo));



        // Assignees
//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownAssignees))).perform();
//        Thread.sleep(1000);
//        List<WebElement> selectedAssignees = driver.findElements(By.xpath(listSelectedDropdownAssignees));
//        for (WebElement cb : selectedAssignees) {
//            cb.click();
//            Thread.sleep(1000);
//        }
//        action.click(driver.findElement(By.xpath(labelAssignees))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownAssignees);
        List<WebElement> selectedAssignees = WebUI.getWebElements(driver, listSelectedDropdownAssignees);
        for (WebElement cb : selectedAssignees) {
            cb.click();
            Thread.sleep(1000);
        }
        WebUI.actionClick(driver, labelAssignees);



//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownAssignees))).perform();
//        Thread.sleep(1000);
//        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchAssignees)), assignee).perform();
//        Thread.sleep(2000);
//        action.click(driver.findElement(By.xpath(getValueAssignees(assignee)))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownAssignees);
        WebUI.actionSendKeys(driver, inputSearchAssignees, assignee);
        WebUI.actionClick(driver, getValueAssignees(assignee));


        // Followers
//        action.click(driver.findElement(By.xpath(dropdownFollowers))).perform();
//        Thread.sleep(1000);
//        List<WebElement> selectedFollowers = driver.findElements(By.xpath(listSelectedDropdownFollowers));
//        for (WebElement cb : selectedFollowers) {
//            cb.click();
//            Thread.sleep(1000);
//        }
//        action.click(driver.findElement(By.xpath(labelFollowers))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownFollowers);
        List<WebElement> selectedFollowers = WebUI.getWebElements(driver, listSelectedDropdownFollowers);
        for (WebElement cb : selectedFollowers) {
            cb.click();
            Thread.sleep(1000);
        }
        WebUI.actionClick(driver, labelFollowers);


//        action.click(driver.findElement(By.xpath(LocatorsTasksCRM.dropdownFollowers))).perform();
//        Thread.sleep(1000);
//        action.sendKeys(driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchFollowers)), follower).perform();
//        Thread.sleep(1000);
//        action.click(driver.findElement(By.xpath(getValueFollowers(follower)))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownFollowers);
        WebUI.actionSendKeys(driver, inputSearchFollowers, follower);
        WebUI.actionClick(driver, getValueFollowers(follower));


        // driver.findElement(By.xpath(LocatorsTasksCRM.inputTag)).click();// Tag
        WebUI.actionClick(driver, inputTag);
        Thread.sleep(1000);
        List<WebElement> allOptions = WebUI.getWebElements(driver, listdropdownTag);
      //  List<WebElement> allOptions = driver.findElements(By.xpath(LocatorsTasksCRM.listdropdownTag));
        Thread.sleep(3000);
        for (WebElement option : allOptions) {
            if (option.getText().equals(tag)) {
                option.click();   // click vào WebElement tìm được
                break;            // thoát vòng lặp sau khi click
            }
        }
        Thread.sleep(3000);

      //  driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)).click();
        WebUI.actionClick(driver, buttonSave);
        Thread.sleep(1000);
        // Check sau khi save có lỗi required không
       // List<WebElement> errorsRequired = driver.findElements(By.xpath(LocatorsTasksCRM.alertErrorMessageRequired));
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

    public static void searchTasks(String tasksName) throws InterruptedException {
//        driver.findElement(By.xpath(LocatorsTasksCRM.iconCloseProfile)).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(LocatorsTasksCRM.menuTasks)).click();
//        Thread.sleep(2000);
//        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).clear();
//        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).sendKeys(tasksName);
//        Thread.sleep(2000);

        WebUI.clickElement(driver, iconCloseProfile);
        WebUI.clickElement(driver, menuTasks);
        WebUI.clearTextElement(driver, inputSearch);
        WebUI.setTextElement(driver, inputSearch, tasksName);

       // List<WebElement> rows = driver.findElements(By.xpath(LocatorsTasksCRM.firstRowItemTasks));

        List<WebElement> rows = WebUI.getWebElements(driver,firstRowItemTasks);
        Assert.assertTrue(rows.size() > 0, "FAILED: Không tìm thấy Task vừa tạo trong danh sách!");
        System.out.println("Đã tìm thấy Task search: " + rows.get(0).getText());
        Thread.sleep(1000);
    }

//    public static void compareFieldAttribute(String expectedValue, String xpathActual, String attributeActual) {
//        String expected = expectedValue;
//        String actual = driver.findElement(By.xpath(xpathActual)).getAttribute(attributeActual);
//        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expected + " nhưng giá trị thực tế là: " + actual);
//    }

    public static void compareFieldAttribute(WebDriver driver, String expectedValue, By by, String attributeType) {
        String actual = WebUI.getElementAttribute(driver, by, attributeType);
        Assert.assertEquals(actual, expectedValue, "FAIL: Giá trị mong muốn là: " + expectedValue + " nhưng giá trị thực tế là: " + actual
        );
    }

    public static void verifyCheckboxSelected(String checkbox) {
        boolean checked = driver.findElement(By.xpath(checkbox)).isSelected();
        Assert.assertTrue(checked, "FAILED: Checkbox [" + checked + "] chưa được chọn.");
    }


    public static void verifyEditTask(String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                String totalCycles, String relatedTo,
                                String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException {
      //  WebElement firstRow = driver.findElement(By.xpath(LocatorsTasksCRM.firstRow));

        WebElement firstRow = WebUI.getWebElement(driver, LocatorsTasksCRM.firstRow);
        // B2: Hover chuột vào dòng đầu tiên
        Actions actions = new Actions(driver);
        actions.moveToElement(firstRow).perform();
        Thread.sleep(3000);

//        driver.findElement(By.xpath(LocatorsTasksCRM.linkEdit)).click();
//        Thread.sleep(3000);
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


    public static void editTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                  String relatedTo, String typeRelatedTo, String tag, String description) throws Exception {

        Actions actions = new Actions(driver);
        Robot robot = new Robot();


       // boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).isSelected();

        boolean isSelectedPublic = WebUI.checkSeletedElement(driver, checkboxPublic);
        if(isSelectedPublic == true)
        {
          //  actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic))).perform();
            WebUI.actionClick(driver, checkboxPublic);
        }



      //  boolean isSelectedBillable = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).isSelected();
        boolean isSelectedBillable = WebUI.checkSeletedElement(driver, checkboxBillable);
        if(isSelectedBillable == false)
        {
          //  actions.click(driver.findElement(By.xpath(checkboxBillable))).perform();
            WebUI.actionClick(driver, checkboxBillable);
        }



//        pressCombo(KeyEvent.VK_CONTROL, KeyEvent.VK_A);
//        pressCombo(KeyEvent.VK_DELETE);

//        WebElement elementSubject = driver.findElement(By.xpath(inputSubject));
//        actions.click(elementSubject).perform();
//        Thread.sleep(1000);
//        actions.keyDown(Keys.CONTROL) .sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
//        Thread.sleep(1000);
//        actions.sendKeys(elementSubject, subject).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, inputSubject);
        WebUI.clearTextElement(driver, inputSubject);
        WebUI.actionSendKeys(driver, inputSubject, subject);


//        WebElement elementHourlyRate = driver.findElement(By.xpath(inputHourlyRate));
//        actions.click(elementHourlyRate).perform();
//        Thread.sleep(1000);
//        actions.keyDown(Keys.CONTROL) .sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
//        Thread.sleep(1000);
//      //  elementHourlyRate.clear();
//        actions.sendKeys(elementHourlyRate, hourlyRate).perform();
//        Thread.sleep(1000);

        WebUI.actionClick(driver, inputHourlyRate);
        WebUI.clearTextElement(driver, inputHourlyRate);
        WebUI.actionSendKeys(driver, inputHourlyRate, hourlyRate);

//        WebElement elementStartDate = driver.findElement(By.xpath(inputStartDate));
//        actions.click(elementStartDate).perform();
//        Thread.sleep(2000);
//        actions.keyDown(Keys.CONTROL) .sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
//        Thread.sleep(2000);
//        actions.sendKeys(elementStartDate, startDate).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, inputStartDate);
        WebUI.clearTextElement(driver, inputStartDate);
        WebUI.actionSendKeys(driver, inputStartDate, startDate);

//        WebElement elementDueDate= driver.findElement(By.xpath(inputDueDate));
//        actions.click(elementDueDate).perform();
//        Thread.sleep(1000);
//        actions.keyDown(Keys.CONTROL) .sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).build().perform();
//        Thread.sleep(1000);
//        actions.sendKeys(elementDueDate, dueDate).perform();
//        Thread.sleep(1000);

        WebUI.actionClick(driver, inputDueDate);
        WebUI.clearTextElement(driver, inputDueDate);
        WebUI.actionSendKeys(driver, inputDueDate, dueDate);



        //Priority
//        actions.click(driver.findElement(By.xpath(dropdownPrioryty))).perform();
//        Thread.sleep(1000);
//        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValuePrioryty(priority)))).perform();
//        Thread.sleep(1000);

        WebUI.actionClick(driver, dropdownPrioryty);
        WebUI.actionClick(driver, LocatorsTasksCRM.getValuePrioryty(priority));

        //Repeat every
//        actions.click(driver.findElement(By.xpath(dropdownRepeatEvery))).perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValueRepeatEvery(repeatEvery)))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownRepeatEvery);
        WebUI.actionClick(driver, LocatorsTasksCRM.getValueRepeatEvery(repeatEvery));

//        WebElement elementBtnSave = driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)); //trỏ tới element
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", elementBtnSave); //true là cuộn xuống dưới, false là cuộn lên trên

        WebUI.scrollAtTop(driver, buttonSave);

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
//        actions.click(driver.findElement(By.xpath(dropdownRepeatTo))).perform();
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath(LocatorsTasksCRM.getValueRepeatTo(relatedTo)))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownRepeatTo);
        WebUI.actionClick(driver, LocatorsTasksCRM.getValueRepeatTo(relatedTo));


//        actions.click(driver.findElement(By.xpath(dropdownValueForRepeatTo))).perform();
//        Thread.sleep(200);
//        actions.sendKeys(driver.findElement(By.xpath(inputSearchValueForRepeatTo)), typeRelatedTo).perform();
//        Thread.sleep(2000);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        Thread.sleep(2000);
//        actions.click(driver.findElement(By.xpath(getValueForRepeatTo(typeRelatedTo)))).perform();
//        Thread.sleep(2000);

        WebUI.actionClick(driver, dropdownValueForRepeatTo);
       // WebUI.actionSendKeys(driver, inputSearchValueForRepeatTo, typeRelatedTo);
        WebUI.setTextAndKeyElement(driver, inputSearchValueForRepeatTo, typeRelatedTo, Keys.ENTER);
        Thread.sleep(1000);
        WebUI.setTextElement(driver, inputSearchValueForRepeatTo, " ");
        WebUI.actionClick(driver, getValueForRepeatTo(typeRelatedTo));


        //tag
//        Thread.sleep(1000);
//        WebElement elementCloseTag = driver.findElement(By.xpath(LocatorsTasksCRM.iconCloseTag));
//        actions.click(elementCloseTag).perform();
//        Thread.sleep(1000);
//        WebElement inputTag = driver.findElement(By.xpath(LocatorsTasksCRM.inputTag));
//        actions.sendKeys(inputTag, tag).perform();
//        Thread.sleep(1000);

        WebUI.actionClick(driver, iconCloseTag);
        WebUI.actionSendKeys(driver, LocatorsTasksCRM.inputTag, tag);

//        WebElement labelTag = driver.findElement(By.xpath(LocatorsTasksCRM.labelTag));
//        actions.click(labelTag).perform();
//        Thread.sleep(1000);
//        actions.click(labelTag).perform();

        WebUI.actionClick(driver, LocatorsTasksCRM.labelTag);
        Thread.sleep(1000);
        WebUI.actionClick(driver, LocatorsTasksCRM.labelTag);


        //iframe
      //  driver.findElement(By.xpath(LocatorsTasksCRM.inputDescription)).click();

        WebUI.clickElement(driver, inputDescription);
        Thread.sleep(2000);
        driver.switchTo().frame("description_ifr");

        WebElement iframeDescription = WebUI.getWebElement(driver, LocatorsTasksCRM.iframeDescription);
       // WebElement iframeDescription = driver.findElement(By.xpath(LocatorsTasksCRM.iframeDescription));
        iframeDescription.sendKeys(description);
        Thread.sleep(2000);
        driver.switchTo().parentFrame();
        Thread.sleep(2000);

   }

    public void clickButtonSave() throws InterruptedException {
      //  driver.findElement(By.xpath(LocatorsTasksCRM.buttonSave)).click();
        WebUI.clickElement(driver, buttonSave);
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testAddAndVerifyTask() throws InterruptedException{

        BTTasks btTasks = new BTTasks();

        btTasks.taskName = "Yến Nhi Task 1";
        btTasks.hourlyRate = "10";
        btTasks.startDate = "14-12-2025";
        btTasks.dueDate = "18-12-2025";
        btTasks.priority = "High";
        btTasks.repeatEvery = "1 Month";
        btTasks.totalCycles = "56622";
        btTasks.relatedTo = "Customer";
        btTasks.typeRelatedTo = "An test 02";
        btTasks.assignee = "Admin Anh Tester";
        btTasks.follower = "Admin Example";
        btTasks.tag = "JSC_NEW";

        verifyMenuTask();
        verifyBtnAddNewTask();
        addNewTasks(btTasks.taskName, btTasks.hourlyRate, btTasks.startDate, btTasks.dueDate, btTasks.priority, btTasks.repeatEvery, btTasks.totalCycles, btTasks.relatedTo, btTasks.typeRelatedTo, btTasks.assignee, btTasks.follower, btTasks.tag);
    }

    @Test(priority = 2)
    public void testEditask() throws Exception {

        BTTasks btTasks = new BTTasks();

        btTasks.taskName = "Yến Nhi Task 2";
        btTasks.hourlyRate = "10";
        btTasks.startDate = "14-12-2025";
        btTasks.dueDate = "18-12-2025";
        btTasks.priority = "High";
        btTasks.repeatEvery = "1 Month";
        btTasks.totalCycles = "56622";
        btTasks.relatedTo = "Customer";
        btTasks.typeRelatedTo = "An test 02";
        btTasks.assignee = "Admin Anh Tester";
        btTasks.follower = "Admin Example";
        btTasks.tag = "JSC_NEW";

        verifyMenuTask();
        verifyBtnAddNewTask();
        addNewTasks(btTasks.taskName, btTasks.hourlyRate, btTasks.startDate, btTasks.dueDate, btTasks.priority, btTasks.repeatEvery, btTasks.totalCycles, btTasks.relatedTo, btTasks.typeRelatedTo, btTasks.assignee, btTasks.follower, btTasks.tag);

        searchTasks(btTasks.taskName);
        Thread.sleep(2000);

        verifyEditTask( btTasks.taskName, btTasks.hourlyRate + ".00", btTasks.startDate, btTasks.dueDate, btTasks.priority, btTasks.repeatEvery, btTasks.totalCycles, btTasks.relatedTo, btTasks.typeRelatedTo, btTasks.assignee, btTasks.follower, btTasks.tag);
        Thread.sleep(2000);


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

        editTasks(btTasks.taskName, btTasks.hourlyRate, btTasks.startDate, btTasks.dueDate ,  btTasks.priority , btTasks.repeatEvery , btTasks.relatedTo , btTasks.typeRelatedTo, btTasks.tag,  btTasks.description);

        Thread.sleep(2000);
        clickButtonSave();
        Thread.sleep(2000);
    }




}
