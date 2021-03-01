package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentPage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10,webDriverWait15;
    Logger logger = Logger.getLogger(getClass());
    public ParentPage (WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        webDriverWait10 = new WebDriverWait(webDriver,10);
        webDriverWait15 = new WebDriverWait(webDriver,15);

    }
    protected void enterTextIntoElement(WebElement webElement, String text){
        try{
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        }catch (Exception e){
            printErrorMessageAndStopTest(e);
        }
    }

    private void printErrorMessageAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    protected void clickOnElement(WebElement webElement){
        try{
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");

        }catch(Exception e){
            printErrorMessageAndStopTest(e);
        }
    }

    protected boolean isElementDisplayed(WebElement webElement){
        try{
            webDriverWait10.until(ExpectedConditions.visibilityOf(webElement));
            boolean state = webElement.isDisplayed();
            logger.info("Element displayed : " + state);
            return state;
        }catch (Exception e){
            logger.info("Element displayed : false");
            return false;
        }
    }
    protected void checkIsElementVisible (WebElement webElement){
        Assert.assertTrue("Element is not visible", isElementDisplayed(webElement));
    }


}
