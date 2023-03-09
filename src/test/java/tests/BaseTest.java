package tests;

import modal.BaseModal;
import modal.NewAddressModal;
import modal.NewUserModal;
import myUtils.PropertyReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        String browserName = System.getProperty("browser", "Chrome");
        String headless = System.getProperty("headless", "true");
        if(browserName.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if(headless.equals("true")) {
                options.addArguments("--headless");}
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if(browserName.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new Exception("Incorrect browser name");
        }

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

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
