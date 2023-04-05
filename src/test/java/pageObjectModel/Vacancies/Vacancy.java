package pageObjectModel.Vacancies;
import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

public class Vacancy {
    WebDriver driver;
    public static final Logger log = Logger.getLogger(Vacancy.class.getName());
    Faker faker =new Faker();

    @FindBy(xpath = "//span[text()='Recruitment']")
    WebElement recruitment;

    @FindBy(xpath = "//li/a[text()=\"Vacancies\"]")
    WebElement vacanciesPage;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement vacanciesAddButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input")
    WebElement vacanciesName;

    @FindBy(xpath = "//*[text()='-- Select --']")
    WebElement jobSelect;

    @FindBy(xpath = "//textarea[@placeholder='Type description here']")
    WebElement description;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement hiringManagerName;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div/div/div[2]/input")
    WebElement noOfPosition;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement vacancySubmitButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div")
    WebElement searchSelect;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchVacancyButton;


    public Vacancy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickRecruitmentModule() throws InterruptedException {
        log.info("Clicking To Recruitment Module");
        recruitment.click();
        Thread.sleep(5000);
    }
    public void clickOnVacanciesButton() throws InterruptedException {
        log.info("Clicking To Vacancies Button");
        vacanciesPage.click();
        Thread.sleep(5000);
        vacanciesAddButton.click();
        Thread.sleep(5000);
    }
    public void addVacancies() throws InterruptedException {
        log.info("Adding To Vacancies");
        vacanciesName.sendKeys("Account Assistant");


        jobSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));


        // Wait for the options to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-text")));

      // Find the option you want to select and click it
        WebElement option = driver.findElement(By.xpath("//*[text()='Software Engineer']"));
        option.click();

        log.info("Job selected successfully");

        new WebDriverWait(driver, Duration.ofSeconds(10));
        description.sendKeys("jvkfk  kgkkgk zdksjhsk  dkckzkvusj");
        hiringManagerName.sendKeys("Odis Adalwin");
        noOfPosition.sendKeys("8");
        vacancySubmitButton.click();
        Thread.sleep(5000);
    }
    public void searchVacanciesByJobTitle() throws InterruptedException {
        log.info("Searching Vacancies By Active status");
        driver.navigate().back();
        Thread.sleep(5000);
        searchSelect.click();
        new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the options to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.oxd-select-text")));

        // Find the option you want to select and click it
        WebElement option = driver.findElement(By.xpath("//*[text()='Software Engineer']"));
        option.click();

        new WebDriverWait(driver, Duration.ofSeconds(10));
        searchVacancyButton.click();
        Thread.sleep(10000);
        log.info("Vacancies Searched successfully");

    }



}
