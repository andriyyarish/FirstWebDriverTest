package com.facebook.tests;

import com.qaautomation.data.FacebookData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.FacebookLoginPage;
import pages.FacebookMainPage;

/**
 * Created by NewMan on 03.11.2015.
 */
public class Login_Tests {


    public WebDriver driver;
    FacebookLoginPage fBMainpage;

    @BeforeClass (alwaysRun = true)
    public void setUp(){
         this.driver = new FirefoxDriver();
        fBMainpage = PageFactory.initElements(driver,FacebookLoginPage.class);             //new FacebookLoginPage(driver);
    }

    @AfterClass (alwaysRun = true)
    public void tearDown(){
        this.driver.quit();
    }





    @Test (groups={"p0","checkLoadPage"}) // each group will be run separetly browser will be closed after each group passed

        public void loadPage(){
        driver.get(fBMainpage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fBMainpage.PAGE_TITLE);
        }

    @Test (groups ={"p2","checkLogin"}, dependsOnMethods = "loadPage") //// each group will be run separetly
        public  void fiilOutEmailField(){
        fBMainpage.setText_EmailLogin("coolandriy@rambler.ru");

        }

    @Test(groups ={"p2","checkLogin"} ,dependsOnMethods = "fiilOutEmailField")
    public void fillAutPassword () {
        fBMainpage.setText_PasswordLogin("Sheva789"); // Assertion is in PageObject metod
    }

    @Test(groups = {"p2","CheckLogin"}, dependsOnMethods = "fillAutPassword")
    public void clickLogin ()  {
        fBMainpage.clickLoginMain();
    }

    @Test (groups = {"p1"}, dataProviderClass = FacebookData.class,   dataProvider = "login")
    public void loginToMain(String email, String password){
        driver.get(fBMainpage.PAGE_URL);
        Assert.assertEquals(driver.getTitle(), fBMainpage.PAGE_TITLE);
        fBMainpage.setText_EmailLogin(email);
        fBMainpage.setText_PasswordLogin(password);
        fBMainpage.clickLoginMain();



        Assert.assertEquals(driver.getTitle(),"Facebook");

//asd//
    }


}
