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
import pages.SignOutPage;
import util.ScreenCast;


public class SignOutTest extends BasePage {

    private SignOutPage signOutPage;
    private SignInPage signInPage;
    private ScreenCast screenCast;


    @Description("Pre Condition: SignIn")
    @BeforeMethod
    public void setUps() {
        setUp();
        signInPage = new SignInPage();
        signInPage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Sign Out")
    @Story("Story Name: Sign In Out")
    @Test
    public void verifySignOut() throws InterruptedException {
        signOutPage = new SignOutPage();
        screenCast = new ScreenCast();
        signOutPage.signOut();
        Assert.assertEquals(signOutPage.verifySignOutSuccess(), "Already registered? Login here", "Sign Out fail");
        screenCast.captureScreen();
    }

    @Description("Post Condition: Close Browser after executing Test")
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
