package pages;

import baseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
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
    // Enter password
    @FindBy(xpath = "//*[@type='password' and @name='password']")
    WebElement tf_password;
    // success message of login
    @FindBy(xpath = "//*[contains(text(),'Welcome back! ')]")
    WebElement success_msg;

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    // // verify login success
    public String verifySignInSuccess() {
        String resultText = success_msg.getText();
        return resultText;
    }

    public void SignIn(String UserName, String Password) {
        link_Side_Menu.click();
        final String mainWindowHandle = driver.getWindowHandle();
        link_sign_in.click();
        for (String activeHandle : driver.getWindowHandles()) {
            if (!activeHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(activeHandle);
            }
        }
        link_email_signIn.click();
        tf_email.sendKeys(UserName);
        button_submit.click();
        tf_password.sendKeys(Password);
        button_submit.click();
        driver.switchTo().window(mainWindowHandle);
    }
}