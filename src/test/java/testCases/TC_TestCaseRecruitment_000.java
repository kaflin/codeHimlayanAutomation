package testCases;
import base.BaseClass;
import org.openqa.selenium.devtools.v85.systeminfo.model.VideoDecodeAcceleratorCapability;
import org.testng.annotations.Test;
import pageObjectModel.Login.LoginToMainApplication;
import pageObjectModel.Vacancies.Vacancy;
import pageObjectModel.recruitmentModule.Recruitment;

import java.time.Duration;

public class TC_TestCaseRecruitment_000 extends BaseClass {
    LoginToMainApplication loginToMainApplication;
    Recruitment recruitment;
    Vacancy vacancy;

    @Test(priority = 1)
    public void verifyTitle() {
        logger.info("Verifying title of OrangeHRM page");
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle); //soft Assert is for verify if condition is failed ,Then it will not stop executing the code
    }
    @Test(priority = 2)
    public void login() throws InterruptedException {
        loginToMainApplication=new LoginToMainApplication(driver);
        loginToMainApplication.login();
    }
    @Test(priority = 3)
    public void recruitment() throws InterruptedException {
        recruitment = new Recruitment(driver);
        recruitment.addFirstCandidates();
        driver.navigate().back();
        recruitment.addSecondCandidates();
        driver.navigate().back();
        recruitment.searchCandidateByJobTitle();
    }

    @Test(priority = 4)
    public void vacancy() throws InterruptedException {
        vacancy=new Vacancy(driver);
        vacancy.clickRecruitmentModule();
        vacancy.clickOnVacanciesButton();
        vacancy.addVacancies();
        driver.navigate().refresh();
        Thread.sleep(10000);
        vacancy.addVacancies();
        vacancy.searchVacanciesByJobTitle();
    }
}
