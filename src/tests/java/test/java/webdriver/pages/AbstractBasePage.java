package test.java.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;


public abstract class AbstractBasePage {

    protected WebDriverWait defaultWait;
    protected WebDriverWait defaultLongWait;
    protected RemoteWebDriver driver;

    /**
     * Constructor.
     *
     * @param webdriver Selenium class.
     */
    public AbstractBasePage(WebDriver webdriver) {
        driver = (RemoteWebDriver) webdriver;
        defaultWait = new WebDriverWait(driver, 15);
        defaultLongWait = new WebDriverWait(driver, 30);
    }
}
