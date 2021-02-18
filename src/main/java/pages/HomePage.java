package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//a[@href = '/login']")
    private WebElement enterButton;
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openHomePage(){
        try {
            webDriver.get("https://trello.com/home");
            logger.info("Home Page was opened");
        }catch(Exception e){
            logger.error("Can not open Home page");
            Assert.fail("Can not open Home page");
        }
    }
    public void clickOnButtonEnter(){
        clickOnElement(enterButton);
    }
}
