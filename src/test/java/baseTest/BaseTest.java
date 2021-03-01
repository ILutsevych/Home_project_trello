package baseTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected LoggedOutPage loggedOutPage;
    protected TeamPage teamPage;
    protected TeamAccount teamAccount;
    protected BoardPage boardPage;

    @Before
    public void setUp(){
        File fileFF = new File("./drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Browser was opened");
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        loggedOutPage = new LoggedOutPage(webDriver);
        teamPage = new TeamPage(webDriver);
        teamAccount = new TeamAccount(webDriver);
        boardPage = new BoardPage(webDriver);


//        myProfilePage = new MyProfilePage(webDriver);
//        singlePostPage = new SinglePostPage(webDriver);
    }
    @After
    public void tearDown(){
        webDriver.quit();
        logger.info("Browser was closed");
    }
    protected void checkExpectedResult(String message, boolean actualResult){
        Assert.assertTrue(message,actualResult);
    }
}
