package tests;

import dataModels.Address;
import dataModels.User;
import enums.State;
import modal.BaseModal;
import modal.NewAddressModal;
import modal.NewUserModal;
import myUtils.PropertyReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Listeners(TestLisener.class)
public abstract class BaseTest {
    public final static String BASE_URL = PropertyReader.getProperty("base_url");
    public final static String BASE_USERNAME = PropertyReader.getProperty("username");
    public final static String BASE_PASSWORD = PropertyReader.getProperty("password");
    protected static Faker faker = new Faker();
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
    protected NewAddressModal newAddressModal;
    protected NewUserModal newUserModal;
    protected MyAddressesPage myAddressesPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(ITestContext testContext) throws Exception {
        String browserName = System.getProperty("browser", "chrome");
        String headless = System.getProperty("headless", "false");
        if(browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(headless.equals("true")) {
                options.addArguments("--headless");}
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
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
       newAddressModal = new NewAddressModal(driver);
       newUserModal = new NewUserModal(driver);
       myAddressesPage = new MyAddressesPage(driver);
        testContext.setAttribute("driver", driver);

    }


    @BeforeMethod(alwaysRun = true)
    public void negative() {
        driver.get(BASE_URL);
    }
    @AfterMethod(alwaysRun = true)
    public void cleanUp(){
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
