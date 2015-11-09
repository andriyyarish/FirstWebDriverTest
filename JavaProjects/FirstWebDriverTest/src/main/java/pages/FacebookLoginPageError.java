package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.NoSuchElementException;

/**
 * Created by guest on 08.11.15.
 */
public class FacebookLoginPageError {

    public static final String PAGE_TITLE = "Facevook";
    public static final String PAGE_URL = "http://www.facebook.com";

    @FindBy(css = ".pam.login_error_box.uiBoxRed>div:first-child") WebElement errorHeader;


    // text parametr will come from DataProvider as expected result for current login/password set it will be null
    // for possitive cases and error message for negative cases
    // Need to use Try Catch block because we can get exception after first assertion
    public boolean checkErrorheader(String text){
        try {
            return errorHeader.getText().equals(text);
        }
        catch (NoSuchElementException e){
            return false;
        }

    }

}


