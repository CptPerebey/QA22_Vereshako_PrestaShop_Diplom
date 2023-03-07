package tests;

import io.qameta.allure.Attachment;
import myUtils.AllureUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Date;

public class TestLisener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        System.out.println("Test " + result.getName() + " started at" + new Date().toString());
    }

    @Override
    @Attachment(value = "screenshot", type = "image/png")
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        System.out.println("Test " + result.getName() + " succeeded");
    }

    @Override
    @Attachment(value = "screenshot", type = "image/png")
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        System.out.println("Test " + result.getName() + " failed");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        AllureUtils.attachScreenshot(driver);
    }
}
