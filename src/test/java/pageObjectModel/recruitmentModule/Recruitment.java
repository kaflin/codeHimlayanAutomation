package pageObjectModel.recruitmentModule;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjectModel.Login.LoginToMainApplication;
import testData.Credential;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Recruitment {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(Recruitment.class.getName());
    Faker faker =new Faker();

    @FindBy(xpath = "//span[text()='Recruitment']")
    WebElement recruitment;

    @FindBy(xpath = "//ul/li/a[text()='Candidates']")
    WebElement navCandidates;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//*[text()='-- Select --']")
    WebElement vacancySelect;


   @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input")
    WebElement email;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input")
    WebElement contactNumber;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-upload oxd-file-input-icon\"]")
    WebElement browseFile;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    WebElement keywords;

    @FindBy(xpath = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")
    WebElement dateIcon;

    @FindBy(css=".oxd-textarea")
    WebElement textArea;

    @FindBy(xpath = "//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
    WebElement consentCheckbox;

    @FindBy(xpath ="//button[@type=\"submit\"]")
    WebElement saveButton;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;




    public Recruitment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRecruitmentModule() throws InterruptedException {
        log.info("Clicking To Recruitment Module");
        recruitment.click();
        Thread.sleep(5000);
    }

    public void clickAddButton() throws InterruptedException {
        log.info("Clicking on Add Button");
        addButton.click();
        Thread.sleep(5000);
    }
    public void addCandidates() throws InterruptedException {
            log.info("Adding Candidates");
            firstName.sendKeys(faker.name().firstName());
            middleName.sendKeys(faker.name().name());
            lastName.sendKeys(faker.name().lastName());
            vacancySelect.click();

            // Wait for the options to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-text")));

            // Find the option you want to select and click it
            WebElement option = driver.findElement(By.xpath("//*[text()='Software Engineer']"));
            option.click();

            log.info("Vacancy selected successfully");

            email.sendKeys(faker.name().firstName() + "@gmail.com");
            contactNumber.sendKeys("9867488538");
            new WebDriverWait(driver, Duration.ofSeconds(10));

//        browseFile.click();
//        browseFile.sendKeys("file:///home/suraj/Downloads/Resume(3).pdf");
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,300)");
            keywords.sendKeys(faker.name().firstName() + "," + faker.name().lastName());

            dateIcon.click();
            Thread.sleep(5000);
            Date d = new Date(1);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date = formatter.format(d);
            String splitter[] = date.split("-");
            String month_year = splitter[1];
            String day = splitter[0];
            System.out.println(month_year);
            System.out.println(day);
            log.info("Date selected successfully");

            textArea.sendKeys("My name is maria .I live in Nepal of lamjung district");


            consentCheckbox.click();
            saveButton.click();
            Thread.sleep(10000);
        }
    public void addFirstCandidates() throws InterruptedException {
        log.info("Adding First Candidate");
        clickRecruitmentModule();
        clickAddButton();
        addCandidates();
        Thread.sleep(10000);
    }

    public void addSecondCandidates() throws InterruptedException {
        log.info("Adding Second Candidate");
        clickRecruitmentModule();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        clickAddButton();
        addCandidates();
        Thread.sleep(10000);
    }

    public void searchCandidateByJobTitle() throws InterruptedException {
        log.info("Searching added candidate");
        recruitment.click();
        Thread.sleep(10000);
        vacancySelect.click();

        // Wait for the options to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-text")));

        // Find the option you want to select and click it
        WebElement option = driver.findElement(By.xpath("//*[text()='Software Engineer']"));
        option.click();
        log.info("Vacancy selected successfully");
        searchButton.click();
        Thread.sleep(5000);
    }

}
