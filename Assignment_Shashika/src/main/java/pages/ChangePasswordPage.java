package pages;

import baseTest.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage {
    // click on Side Menu icon
    @FindBy(xpath = "//*[@id=\"create\"]/nav/header/ul[1]/li/a/span")
    WebElement link_Side_Menu;
    //Click on profile in the menu
    @FindBy(xpath = "//*[@id=\"sidemenu\"]/div/a[8]")
    WebElement link_profile;
    //click on change password link
    @FindBy(xpath = "//*[contains(text(),'Update your password »')]")
    WebElement link_ChangePassword;
    // add new password
    @FindBy(xpath = "//*[@type='password' and @name='user[password]']")
    WebElement tf_new_password;
    // add repeat password
    @FindBy(xpath = "//*[@type='password' and @name='user[passwordConfirm]']")
    WebElement tf_repeat_password;
    // click on submit button
    @FindBy(xpath = "//button[contains(text(),'Save Password')]")
    WebElement button_submit;
    // change password success
    @FindBy(xpath = "//*[contains(text(),'Password updated!')]")
    WebElement success_msg;


    // verify change password
    public String verifyPasswordChangeSuccess() {
        String resultText = success_msg.getText();
        return resultText;
    }

    public ChangePasswordPage() {
        PageFactory.initElements(driver, this);
    }

    public void changePassword(String newPassword, String repeatPassword) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        link_Side_Menu.click();
        link_profile.click();
        js.executeScript("arguments[0].click();", link_ChangePassword);
        tf_new_password.sendKeys(newPassword);
        tf_repeat_password.sendKeys(repeatPassword);
        button_submit.click();
    }
}
