package com.facebook.tests;

import com.gargoylesoftware.htmlunit.util.StringUtils;
import com.qaautomation.data.FacebookData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FacebookLoginPage;
import pages.FacebookLoginPageError;
import pages.FacebookMainFeed;
import org.apache.commons.lang3.StringUtils.*;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created by NewMan on 03.11.2015.
 */
public class Login_Tests {


    public WebDriver driver;
    FacebookLoginPage fBLoginPage;
    FacebookLoginPageError fBLoginPageError;
    FacebookMainFeed fbMainFeed;

    @BeforeClass (alwaysRun = true)
    public void setUp(){
         this.driver = new FirefoxDriver();
        fBLoginPage = PageFactory.initElements(driver,FacebookLoginPage.class);
        fBLoginPageError = PageFactory.initElements(driver, FacebookLoginPageError.class);
        fbMainFeed = PageFactory.initElements(driver,FacebookMainFeed.class);
                                                            //new FacebookLoginPage(driver);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }


    @Test (groups={"p0","checkLoadPage"}) // each group will be run separetly browser will be closed after each group passed

        public void loadPage(){
        driver.get(fBLoginPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fBLoginPage.PAGE_TITLE);
        }

    @Test (groups ={"p2","checkLogin"}, dependsOnMethods = "loadPage") //// each group will be run separetly
        public  void fiilOutEmailField(){
        fBLoginPage.setText_EmailLogin("coolandriy@rambler.ru");

        }

    @Test(groups ={"p2","checkLogin"} ,dependsOnMethods = "fiilOutEmailField")
    public void fillAutPassword () {
        fBLoginPage.setText_PasswordLogin("Sheva789"); // Assertion is in PageObject metod
    }

    @Test(groups = {"p2","CheckLogin"}, dependsOnMethods = "fillAutPassword")
    public void clickLogin ()  {
        fBLoginPage.clickLoginMain();
    }

    @Test (groups = {"p3"}, dataProviderClass = FacebookData.class,   dataProvider = "login")
    public void loginToMain(String email, String password, String errorType) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.get(fBLoginPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fBLoginPage.PAGE_TITLE);
        fBLoginPage.setText_EmailLogin(email);
        fBLoginPage.setText_PasswordLogin(password);
        fBLoginPage.clickLoginMain();

// this Block go=ive possibility ti check possitive and negative cases because we can get different type of pages for possitive and negaive cases
        if (!isBlank(errorType)) {
           Boolean result = fBLoginPageError.checkErrorheader(errorType);
            Assert.assertTrue(result,"Expected error" + errorType);
        }
        else {
            String username_field = fbMainFeed.getuserNameText();
            Assert.assertTrue(!username_field.isEmpty());
        }

    }

    // lesson 9  work with DDL
    @Test (groups = {"p4"})
    public void fillRegisterData(){
        driver.manage().deleteAllCookies();
        driver.get(fBLoginPage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fBLoginPage.PAGE_TITLE);

        fBLoginPage.setField_FirstNameSignUp("andy");
        fBLoginPage.setField_LastNameSignUp("yarish");
        fBLoginPage.setField_EmailMobileSignUp("andycucumber@gmail.com");
        fBLoginPage.setField_PasswordSignUp("Sheva789");
        fBLoginPage.selectDay("22");
        fBLoginPage.selectMonth("12");
        fBLoginPage.selectYear("2000");

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }



}
