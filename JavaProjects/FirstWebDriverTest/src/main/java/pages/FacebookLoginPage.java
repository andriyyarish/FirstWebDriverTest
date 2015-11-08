package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

}
