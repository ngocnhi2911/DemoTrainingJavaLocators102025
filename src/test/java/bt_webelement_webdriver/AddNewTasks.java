package bt_webelement_webdriver;

import bt_locators.LocatorsLeadsCRM;
import bt_locators.LocatorsTasksCRM;
import login_crm.LoginCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

// import static bt_locators.LocatorsLeadsCRM.*;
import static bt_locators.LocatorsTasksCRM.*;
import static login_crm.LoginCRM.*;
// import static bt_webelement_webdriver.AddNewLeads.addNewLeads;


public class AddNewTasks extends LoginCRM {

    public static void openNewTasksPage() throws InterruptedException {
        driver.findElement(By.xpath(LocatorsTasksCRM.menuTasks)).click();
        driver.findElement(By.xpath(LocatorsTasksCRM.buttonNewTasks)).click();
    }

    public static void addNewTasks (String subject, String hourlyRate, String startDate, String dueDate, String priority, String repeatEvery,
                                    String totalCycles, String relatedTo,
                                    String typeRelatedTo, String assignee, String follower, String tag) throws InterruptedException{
        openNewTasksPage();
        Thread.sleep(2000);

        boolean isSelectedPublic = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).isSelected();
        if(isSelectedPublic == false)
        {
            driver.findElement(By.xpath(LocatorsTasksCRM.checkboxPublic)).click();
        }
        Thread.sleep(1000);


        boolean isSelectedBillable = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).isSelected();
        if(isSelectedBillable == true)
        {
            driver.findElement(By.xpath(LocatorsTasksCRM.checkboxBillable)).click();
        }
        Thread.sleep(1000);


        driver.findElement(By.xpath(LocatorsTasksCRM.linkAttachFiles)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsTasksCRM.inputSubject)).sendKeys(subject);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsTasksCRM.inputHourlyRate)).sendKeys(hourlyRate);
        Thread.sleep(1000);


//        // B1: Lấy thời gian hiện tại
//        LocalDateTime now = LocalDateTime.now();
//        // B2: Định dạng theo format của hệ thống
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String currentDateTime = now.format(formatter);
//        // B3
        WebElement dateStartDate= driver.findElement(By.xpath(LocatorsTasksCRM.inputStartDate));
        dateStartDate.clear();
        dateStartDate.sendKeys(startDate);
        Thread.sleep(1000);



//        // B1: Lấy thời gian hiện tại và cộng thêm 1 ngày
//        LocalDateTime now1 = LocalDateTime.now().plusDays(1);
//        // B2: Định dạng theo format của hệ thống
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        String currentDateTime1 = now1.format(formatter1);
//        //B3
        WebElement dateDueDate = driver.findElement(By.xpath(LocatorsTasksCRM.inputDueDate));
        dateDueDate.sendKeys(dueDate);
        Thread.sleep(1000);


        // B1: Click mở dropdown Prioryty
        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownPrioryty)).click();
        Thread.sleep(1000);
        // B2: Nhập từ khóa cần tìm vào ô search --> để lọc danh sách
        // driver.findElement(By.xpath(LocatorsLeadsCRM.inputSearchCountry)).sendKeys("Vietnam");
        // B3: Tạo xpath tương ứng với giá trị muốn chọn
        String xpathPrioryty = getValuePrioryty(priority);
        Thread.sleep(1000);
        // B4: Tìm phần tử tương ứng và click
        driver.findElement(By.xpath(xpathPrioryty)).click();
        Thread.sleep(3000);
        //-------------


        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatEvery)).click();
        Thread.sleep(1000);
        String xpathRepeatEvery = getValueRepeatEvery(repeatEvery);
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpathRepeatEvery)).click();
        Thread.sleep(3000);


        boolean isSelectedInfinity = driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity)).isSelected();
        if(isSelectedInfinity == true)
        {
            driver.findElement(By.xpath(LocatorsTasksCRM.checkboxInfinity)).click();
        }
        Thread.sleep(2000);

        WebElement inpTotalCycles = driver.findElement(By.xpath(LocatorsTasksCRM.inputTotalCycles));
        inpTotalCycles.clear();
        inpTotalCycles.sendKeys(totalCycles);



        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownRepeatTo)).click();
        Thread.sleep(1000);
        String xpathRepeatTo = getValueRepeatTo(relatedTo);
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpathRepeatTo)).click();
        Thread.sleep(3000);
        //-------------

        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownValueForRepeatTo)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchValueForRepeatTo)).sendKeys("An test 02");
        String xpathValueForRepeatTo = getValueForRepeatTo(typeRelatedTo);
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathValueForRepeatTo)).click();
        Thread.sleep(2000);



        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownAssignees)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchAssignees)).sendKeys("Admin Anh Tester");
        String xpathAssignees = getValueAssignees(assignee);
        Thread.sleep(2000);
        driver.findElement(By.xpath(xpathAssignees)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsTasksCRM.dropdownFollowers)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearchFollowers)).sendKeys("Admin Example");
        String xpathFollowers = getValueFollowers(follower);
        Thread.sleep(1000);
        driver.findElement(By.xpath(xpathFollowers)).click();
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
        Thread.sleep(3000);

    }

    public static void searchTasks(String tasksName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsTasksCRM.iconCloseProfile)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasksCRM.menuTasks)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).clear();
        driver.findElement(By.xpath(LocatorsTasksCRM.inputSearch)).sendKeys(tasksName);
        Thread.sleep(2000);

        String firstRowTasks = driver.findElement(By.xpath(LocatorsTasksCRM.firstRowItemTasks)).getText();
        System.out.println("First row tasks: " + firstRowTasks);
        Thread.sleep(2000);
    }


//    public static void main(String[] args) throws InterruptedException {
//        createDriver();
//        openNewTasksPage();
//
//        testBT tbt = new testBT();
//
    ////        LocalDateTime nowadd = LocalDateTime.now();
    ////        DateTimeFormatter formatteradd = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    ////        String currentDateTimeAdd = nowadd.format(formatteradd);
    ////        addNewTasks("Yến Nhi " + currentDateTimeAdd);
    ////        searchTasks("Yến Nhi " + currentDateTimeAdd);
//
//        String subject = "Yến Nhi Task";
//        String hourlyRate = "10";
//        String startDate = "14-12-2025";
//        String dueDate = "18-12-2025";
//        String priority = "High";
//        String repeatEvery = "1 Month";
//        String totalCycles = "56622";
//        String relatedTo = "Customer";
//        String typeRelatedTo = "An test 02";
//        String assignee = "Admin Anh Tester";
//        String follower = "Admin Example";
//        String tag = "JSC_NEW";
//
//        tbt.addNewTasks(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);
//
//
//        closeDriver();
//
//    }

    @Test
    public void testAddAndVerifyTask() throws InterruptedException{
        openNewTasksPage();
        testBT tbt = new testBT();


        String subject = "Yến Nhi Task";
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

        tbt.addNewTasks(subject, hourlyRate, startDate, dueDate, priority, repeatEvery, totalCycles, relatedTo, typeRelatedTo, assignee, follower, tag);

    }
}
