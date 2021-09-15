package pages;

import baseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage extends BasePage {
    // click on Side Menu icon
    @FindBy(xpath = "//*[@id=\"home\"]/nav/header/ul[1]/li/a/span/span")
    WebElement link_Side_Menu;
    // click on sign in button
    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    WebElement link_sign_in;
    // click on email option to create user
    @FindBy(linkText = "or use email »")
    WebElement link_email_signIn;
    // enter Email
    @FindBy(name = "email")
    WebElement tf_email;
    // click on submit button
    @FindBy(xpath = "//*[@type='submit' and @data-signin='email']")
    WebElement button_submit;
    // success message of user creation
    @FindBy(xpath = "//*[@id=\"create\"]/div[6]/div[6]/div/div[2]/div/h1")
    WebElement success_msg;


    public CreateUserPage() {
        PageFactory.initElements(driver, this);
    }

    // verify user creation success
    public String verifyUserCreateSuccess() {
        String resultText = success_msg.getText();
        return resultText;
    }

    public void createUser(String UserName) throws InterruptedException {
        link_Side_Menu.click();
        final String mainWindowHandle = driver.getWindowHandle();
        link_sign_in.click();
        for (String activeHandle : driver.getWindowHandles()) {
            if (!activeHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(activeHandle);
            }
        }
        Thread.sleep(5000);
        link_email_signIn.click();
        tf_email.sendKeys(UserName);
        button_submit.click();
        driver.switchTo().window(mainWindowHandle);
    }
}
