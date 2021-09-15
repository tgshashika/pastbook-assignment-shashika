package sigin;

import baseTest.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CreateUserPage;
import testData.SignInTestData;
import util.ScreenCast;

public class CreateEmailAccountTest extends BasePage {
    private CreateUserPage createUser;
    private SignInTestData signInTestData = new SignInTestData();
    private ScreenCast screenCast;

    @BeforeMethod
    public void setUps() {
        setUp();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Create Email User")
    @Story("Story Name: Create User")
    @Test
    public void verifyCreateEmailAccount() throws InterruptedException {
        createUser = new CreateUserPage();
        screenCast = new ScreenCast();
        createUser.createUser(signInTestData.CreateUser());
        Assert.assertEquals(createUser.verifyUserCreateSuccess(), "Create your PastBook in 1 minute!", "User creation fail");
        screenCast.captureScreen();
    }

    @Description("Post Condition: Close Browser after executing Test")
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
