package thuc_hanh;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeadsPage;
import pages.LoginPage;

public class LeadsTest extends BaseTest {
    String status;
    String source;
    String assigned;
    String tag;
    String leadName;
    String address;
    String position;
    String city;
    String emailAddress;
    String state;
    String website;
    String country;
    String phone;
    String zipCode;
    String leadValue;
    String language;
    String company;
    String description;
    String dateContacted;
    int flag;
    int flagEdit;

    private LoginPage loginPage;
    private LeadsPage leadsPage;
    private DashboardPage dashboardPage;


    @Test(priority = 1)
    public void testAddAndVerifyLead() throws InterruptedException{
        loginPage = new LoginPage(driver);

        // loginPage.loginCRM();
        //dashboardPage = new DashboardPage(driver);
       // dashboardPage.(....)
        dashboardPage = loginPage.loginCRM();
        // khi gọi loginPage.loginCRM(): nghĩa là hàm loginCRM() sẽ đc chạy và khởi tạo trang DashboardPage (do có câu lệnh return new DashboardPage(driver))
        // dashboardPage = ... --> lấy đối tượng dashboardPage hứng nhận sự khởi tạo đó từ login
        // --> Nghĩa là : Khi login xong sẽ trả về trang dashboard, rồi từ gàm dashborard gọi hàm thao tác tiếp tục trong trang Dashboard mà k cần khởi tạo độc lập
        // Khi login thành công, dashboard mới mang giá trị để đi tiếp. Nếu login k thành công, dashboard sẽ k có giá trị để khởi tạo


        leadsPage = dashboardPage.clickMenuLead();
        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 1";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi1@gmail.com";
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

        //click menu Lead
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName, 0);
        leadsPage.searchLeads(testBT.leadName);
    }


    @Test(priority = 2)
    public void testVerifyEditLead() throws InterruptedException{
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 2";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi2@gmail.com";
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

        //click menu Lead
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName, 0);
        leadsPage.searchLeads(testBT.leadName);

        leadsPage. verifyEditLead(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted);
        Thread.sleep(2000);

    }


    @Test(priority = 3)
    public void testEditLead() throws Exception {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 3";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi3@gmail.com";
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

        //click menu Lead
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName,0);
        leadsPage.searchLeads(testBT.leadName);

        leadsPage.verifyEditLead(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted);
        Thread.sleep(2000);

        testBT.status = "Active";
        testBT.source = "Facebook";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 3";
        testBT.address = "Thanh Oai";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi3@gmail.com";
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
        testBT.flag = 0;
        testBT.flagEdit = 1;

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);
        Thread.sleep(2000);
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName,0);
        leadsPage.searchLeads(testBT.leadName);

    }


    @Test(priority = 4)
    public void testDeleteLead() throws InterruptedException{
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 4";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi4@gmail.com";
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

        //click menu Lead
        leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName, 0);
        leadsPage.searchLeads(testBT.leadName);

        Thread.sleep(2000);
        leadsPage.clickButtonDelete(testBT.leadName);
        leadsPage.confirmAlertDelete();
        leadsPage.verifyAfterDeleteLead(testBT.leadName);

        //  deleteLead(leadName);
        Thread.sleep(2000);
    }


    @Test(priority = 5)
    public void testAddAndVeriyActive() throws InterruptedException{
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM();
        leadsPage = dashboardPage.clickMenuLead();
        leadsPage.clickLeadsSummary();


        int totalActiveBeforeAdd = Integer.parseInt(leadsPage.getTotalLeadTotalActive());

        LeadsTest testBT = new LeadsTest();

        testBT.status = "Active";
        testBT.source = "Google";
        testBT.assigned = "Admin Anh Tester";
        testBT.tag = "JSC_NEW";
        testBT.leadName = "Yến Nhi 5";
        testBT.address = "Đại Linh";
        testBT.position = "Tester";
        testBT.city = "Việt Nam";
        testBT.emailAddress = "ngocnhi5@gmail.com";
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

        //click menu Lead
       // leadsPage.verifyMenuLead();

        //click btn addnewLead
        leadsPage.verifyBtnAddNewLead();

        leadsPage.fillDataLeads(testBT.status, testBT.source, testBT.assigned, testBT.tag, testBT.leadName, testBT.address, testBT.position, testBT.city,
                testBT.emailAddress, testBT.state, testBT.website, testBT.country, testBT.phone, testBT.zipCode, testBT.leadValue, testBT.language,
                testBT.company, testBT.description, testBT.dateContacted,testBT.flag, testBT.flagEdit);

        leadsPage.verifyEmailResult(true, "");
        leadsPage.clickButtonSave();
        leadsPage.clickIconClosePopupLeadDetail(testBT.leadName, 0);
        leadsPage.searchLeads(testBT.leadName);
       // leadsPage.reloadPage();
        leadsPage.clickLeadsSummary();


        int totalActiveAfterAdd = Integer.parseInt(leadsPage.getTotalLeadTotalActive());

        System.out.println("Before = " + totalActiveBeforeAdd);
        System.out.println("After  = " + totalActiveAfterAdd);

        if (testBT.status.equals("Active")) {
            Assert.assertEquals(totalActiveAfterAdd, totalActiveBeforeAdd + 1,
                    "Số lượng status Active không khớp");
        } else {
            Assert.assertEquals(totalActiveAfterAdd, totalActiveBeforeAdd,
                    "Số lượng status Active không khớp");
        }
    }



}
