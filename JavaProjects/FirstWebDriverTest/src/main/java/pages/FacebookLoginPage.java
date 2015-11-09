package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * Created by NewMan on 04.11.2015.
 */
public class FacebookLoginPage {
    public static final String PAGE_TITLE = "Facebook - Log In or Sign Up";
    public static final String PAGE_URL = "http://www.facebook.com";

    //In this way we can initialize element at once and than use it where we need
    @FindBy(id="email") WebElement field_Email;
    @FindBy(id="pass") WebElement field_Password;
    @FindBy(css = "#loginbutton>input") WebElement button_Login;
    @FindBy(name = "firstname") WebElement field_FirstNameSignUp;
    @FindBy(name = "lastname") WebElement field_LastNameSignUp;
    @FindBy(name = "reg_email__") WebElement field_EmailMobileSignUp;
    @FindBy(name = "reg_email_confirmation__") WebElement field_ConfirmEmailMobileSignUp;
    @FindBy(name = "reg_passwd__") WebElement field_PasswordSignUp;

    @FindBy(id = "month") WebElement dropdown_Month;
    @FindBy(id = "day") WebElement dropdown_Day;
    @FindBy(id = "year") WebElement dropdown_Year;


                                                                // String field_Email = "#email";
                                                                // String field_Password ="#pass";

    WebDriver driver;

    public FacebookLoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setText_EmailLogin(String text){
                                                //WebElement element = driver.findElement(By.cssSelector(field_Email));
        field_Email.sendKeys(text);
        Assert.assertEquals(field_Email.getAttribute("value"), text);

    }

    public void setText_PasswordLogin(String text){
                                                //WebElement element = driver.findElement(By.cssSelector(field_Password));
        field_Password.sendKeys(text);
        Assert.assertEquals(field_Password.getAttribute("value"),text);
    }

    public void clickLoginMain() {
                                            // WebElement element = driver.findElement(By.xpath("//*[@id='u_0_x']"));
        button_Login.click();
        }


    public void setField_FirstNameSignUp(String firstNameSignUp){
        field_FirstNameSignUp.sendKeys(firstNameSignUp);
    }
    public void setField_LastNameSignUp(String lastNameSignUp){
        field_LastNameSignUp.sendKeys(lastNameSignUp);
    }
    public void setField_EmailMobileSignUp(String emailMobileSignUp){
        field_EmailMobileSignUp.sendKeys(emailMobileSignUp);
        field_ConfirmEmailMobileSignUp.sendKeys(emailMobileSignUp);
    }
    public void setField_PasswordSignUp(String passwordSignUp){
        field_PasswordSignUp.sendKeys(passwordSignUp);
    }


    public void selectMonth(String value){
        Select select = new Select(dropdown_Month);
        select.selectByValue(value);

    }
    public void selectDay(String value){
        Select select = new Select(dropdown_Day);
        select.selectByValue(value);

    }
    public void selectYear(String value){
        Select select = new Select(dropdown_Year);
        select.selectByValue(value);

    }

}
