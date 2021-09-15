import baseTest.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SignInPage;

public class BaseTest extends BasePage {
    public WebDriver driver;
    public SignInPage signInPage;

    @BeforeMethod
    public void setUps() {
        setUp();
        signInPage = new SignInPage();
        signInPage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
       closeBrowser();
   }
}
