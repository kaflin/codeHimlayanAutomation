package pageObjectModel.Login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testData.Credential;

import java.util.concurrent.TimeUnit;

public class LoginToMainApplication {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(LoginToMainApplication.class.getName());

    @FindBy(xpath = "//input[@name='username']")
    WebElement userName;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginToMainApplication(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() throws InterruptedException {
        log.info("Logging to Main application");
        Thread.sleep(5000);
        userName.sendKeys(Credential.userName);
        password.sendKeys(Credential.password);
        loginButton.click();
        Thread.sleep(5000);
    }



}
