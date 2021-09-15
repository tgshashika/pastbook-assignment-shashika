package sigin;

import baseTest.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.tools.ant.taskdefs.optional.junit.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import util.ScreenCast;


public class SignInTest extends BasePage {
    private SignInPage signInPage;
    private ScreenCast screenCast;

    @BeforeMethod
    public void setUps() {
        setUp();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Valid login with exist User")
    @Story("Story Name: Sign In with email")
    @Test
    public void verifySignIn() throws InterruptedException {
        signInPage = new SignInPage();
        screenCast = new ScreenCast();
        signInPage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
        Assert.assertEquals(signInPage.verifySignInSuccess(), "Welcome back!\n" + "Here's your most recent PastBook", "Login fail");
        screenCast.captureScreen();
    }

    @Description("Post Condition: Close Browser after executing Test")
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
