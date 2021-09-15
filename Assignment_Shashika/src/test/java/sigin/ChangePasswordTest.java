package sigin;

import baseTest.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ChangePasswordPage;
import pages.CreateUserPage;
import pages.SignInPage;
import testData.SignInTestData;
import util.ScreenCast;

public class ChangePasswordTest extends BasePage {
    private CreateUserPage createUser;
    private ChangePasswordPage changePassword;
    private SignInTestData signInTestData = new SignInTestData();
    private ScreenCast screenCast;

    @Description("Pre Condition: Create user before updating Password")
    @BeforeMethod
    public void setUps() throws InterruptedException {
        setUp();
        createUser = new CreateUserPage();
        createUser.createUser(signInTestData.CreateUser());
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Change password")
    @Story("Story Name: Change Password")
    @Test
    public void verifyChangePassword() throws InterruptedException {
        changePassword = new ChangePasswordPage();
        screenCast = new ScreenCast();
        changePassword.changePassword(signInTestData.newPassword, signInTestData.newPassword);
        Assert.assertEquals(changePassword.verifyPasswordChangeSuccess(), "Password updated!", "Password change fail");
        screenCast.captureScreen();
    }

    @Description("Post Condition: Close Browser after executing Test")
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
