package pages;

import baseTest.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateBookPage extends BasePage {
    // Click on Side Menu icon
    @FindBy(xpath = "//*[@id=\"browse\"]/nav/header/ul[1]/li/a/span")
    WebElement link_Side_Menu;
    //Click on Create book in the menu
    @FindBy(xpath = "//*[@id=\"sidemenu\"]/div/a[2]")
    WebElement link_create_book;
    //Click on from Scratch
    @FindBy(xpath = "//*[@id=\"sidemenu\"]/div/div[1]/a[1]")
    WebElement link_from_Scratch;
    //Enter title
    @FindBy(xpath = "//*[@name='title' and @type='text']")
    WebElement tf_title;
    // Click create your past book button
    @FindBy(xpath = "//*[@id=\"create-button\"]")
    WebElement button_create_pastBook;
    // Click  "update your" picture button
    @FindBy(xpath = "//*[@id=\"add\"]/div[6]/div[11]/div/div/div/div/p[1]/a")
    WebElement link_upload_picture;
    // upload image
    @FindBy(xpath = "//input[@id='fsp-fileUpload']")
    WebElement if_upload_picture;
    // Click Upload button
    @FindBy(xpath = "//*[@title='Upload' and @class='fsp-button fsp-button--primary fsp-button-upload']")
    WebElement button_upload;
    // Click Continue button
    @FindBy(xpath = "//*[@id=\"add\"]/div[9]/div/div/div[3]/button[2]")
    WebElement button_Continue;
    // Verify Success of create past book
    @FindBy(xpath = "//*[@id=\"browse\"]/div[6]/div[15]/div/div[2]/div[1]")
    WebElement success_msg;


    //verify Create  Past book success
    public String verifyCreatePastBookSuccess() {
        String resultText = success_msg.getText();
        return resultText;
    }

    public CreateBookPage() {
        PageFactory.initElements(driver, this);
    }

    public void createBook(String title,String filePath) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        link_Side_Menu.click();
        link_create_book.click();
        link_from_Scratch.click();
        tf_title.sendKeys(title);
        js.executeScript("arguments[0].click();", button_create_pastBook);
        link_upload_picture.click();
        Thread.sleep(5000);
        if_upload_picture.sendKeys(filePath);
        button_upload.click();
        Thread.sleep(10000);
      js.executeScript("arguments[0].click();", button_Continue);
    }
}
