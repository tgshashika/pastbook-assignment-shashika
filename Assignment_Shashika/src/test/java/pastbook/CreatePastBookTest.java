package pastbook;

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
import pages.CreateBookPage;
import pages.SignInPage;
import pages.SignOutPage;
import testData.PastBookTestData;
import util.ScreenCast;

import java.io.FileInputStream;

public class CreatePastBookTest extends BasePage {
    private SignInPage signInPage;
    private CreateBookPage createBookPage;
    private PastBookTestData pastBookTestData = new PastBookTestData();
    private ScreenCast screenCast;

    @Description("Pre Condition: SignIn")
    @BeforeMethod
    public void setUps() {
        setUp();
        signInPage = new SignInPage();
        signInPage.SignIn(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify Create PastBook")
    @Story("Story Name: Create Past Book")
    @Test
    public void verifyCreatePastBook() throws InterruptedException {
        createBookPage = new CreateBookPage();
        screenCast = new ScreenCast();
        createBookPage.createBook(pastBookTestData.title(), pastBookTestData.filePath);
        Assert.assertEquals(createBookPage.verifyCreatePastBookSuccess(), "Here's your book with 1 moments!", "Book Creation fail");
        screenCast.captureScreen();
    }

    @Description("Post Condition: Close Browser after executing Test")
    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

}
