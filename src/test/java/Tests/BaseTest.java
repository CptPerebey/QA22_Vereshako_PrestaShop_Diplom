package Tests;

import Modal.BaseModal;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected AuthenticationPage authenticationPage;
    protected HeadPage headPage;
    protected CreatAccountPage creatAccountPage;
    protected MyAccountPage myAccountPage;
    protected WomenPage womenPage;
    protected ProductDetailsPage productDetailsPage;
    protected CardPage cardPage;
    protected BaseModal baseModal;
    protected WishListPage wishListPage;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browserName, ITestContext testContext) throws Exception {
        if(browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browserName.equals("fireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       authenticationPage = new AuthenticationPage(driver);
       headPage = new HeadPage(driver);
       creatAccountPage = new CreatAccountPage(driver);
       myAccountPage = new MyAccountPage(driver);
       womenPage = new WomenPage(driver);
       productDetailsPage = new ProductDetailsPage(driver);
       cardPage = new CardPage(driver);
       baseModal = new BaseModal(driver);
       wishListPage = new WishListPage(driver);

        testContext.setAttribute("driver", driver);

    }


    @BeforeMethod(alwaysRun = true)
    public void negative() {
        driver.get("http://prestashop.qatestlab.com.ua/ru/");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
