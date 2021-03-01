package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggedOutPage extends ParentPage {
    public LoggedOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isTextThatApprovedLogOutVisible() {
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[contains(text(),'Спасибо, что используете Trello.')]"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    public boolean logInButtonIsVisible(){
        try{
            return webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@href='/login']"))).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
