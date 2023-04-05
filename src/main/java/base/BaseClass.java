package base;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BaseClass.class.getName());
    public Actions action;
    public SoftAssert softAssert = new SoftAssert();
    public String baseDirectory = System.getProperty("user.dir");

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setup(@Optional("chrome") String br) throws InterruptedException {
        logger.info("Opening OrangeHRM");
        String log4jConfPath = baseDirectory + "/src/main/resources/config/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        if (br.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", baseDirectory + readConfig.getChromePath());
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        action = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
