package pages;

import baseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOutPage extends BasePage {
    // click on Side Menu icon
    @FindBy(xpath = "//*[@id=\"browse\"]/nav/header/ul[1]/li/a/span")
    WebElement link_Side_Menu;
    // click on sign out button
    @FindBy(xpath = "//*[@id=\"sidemenu\"]/div/a[9]")
    WebElement link_sign_Out;
    // success message of log out
    @FindBy(xpath = "//*[contains(text(),'Already registered? Login here')]")
    WebElement success_msg;

    public SignOutPage() {
        PageFactory.initElements(driver, this);
    }

    // verify log out
    public String verifySignOutSuccess() {
        String resultText = success_msg.getText();
        return resultText;
    }

    public void signOut() throws InterruptedException {
        link_Side_Menu.click();
        link_sign_Out.click();

    }

}
