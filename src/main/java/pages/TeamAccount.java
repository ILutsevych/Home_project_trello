package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamAccount extends ParentPage {
    @FindBy(xpath = ".//a[@href = '#' and contains(@class,'quiet')]")
    private WebElement deleteButton;
    @FindBy(xpath = ".//input [@type='submit']")
    private WebElement deleteForeverButton;

    public TeamAccount(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnDeleteButton(){
        clickOnElement(deleteButton);
        logger.info("Button delete is clicked");
    }
    public void clickOnDeleteForever(){
        clickOnElement(deleteForeverButton);
        logger.info("Button Delete forever is clicked");
    }
}
