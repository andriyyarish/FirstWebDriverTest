package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by guest on 08.11.15.
 */
public class FacebookMainFeed {
    @FindBy(css = ".fbxWelcomeBoxName")
    WebElement linkWelcomeUsername;

    public String getuserNameText(){
       return linkWelcomeUsername.getText();

    }

}
