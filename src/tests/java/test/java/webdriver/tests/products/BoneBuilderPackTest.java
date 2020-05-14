package test.java.webdriver.tests.products;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import test.java.webdriver.pages.BoneBuilderPack;
import test.java.webdriver.pages.Cart;
import test.java.webdriver.pages.MainMenu;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class BoneBuilderPackTest{

    private static final String boneBuilderThreeMonthPackText = "Bone Builder Pack 3 Month Supply";
    private static final String boneBuilderSixMonthPackText = "Bone Builder Pack 6 Month Supply";
    private static final String boneBuilderTwelveMonthPackText = "Bone Builder Pack 12 Month Supply";
    private static final String emptyCartText = "Your cart is currently empty.";

    private String testName;
    WebDriver driver;
    MainMenu mainMenu;

    /**
     * Will print to the console when the test starts and ends
     */
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            testName = description.getMethodName();
            System.out.println("--- STARTING TEST: " + testName + " ---");
        }

        protected void finished(Description description) {
            testName = description.getMethodName();
            System.out.println("--- ENDING TEST: " + testName + " ---\n");
        }
    };

    /**
     * Executed before each test
     */
    @Before
    public void setup() throws InterruptedException {

        //suppress Chrome Warning from console  - Fix Timed out receiving message from renderer
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");

        //using for setup to manage the WebDriver binaries
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //
        driver.get("https://www.algaecal.com/");
        mainMenu = new MainMenu(driver);
    }

    /**
     * Executed after each test
     */
    @After
    public void cleanup() {
        driver.quit();
    }

    /**
     * This test verifies the three add to cart buttons function on the Bone Builder Product Page.
     *
     * @Author Tammy Saucedo
     * @UserStory AlgaeCal QA Test
     */
    @Test
    public void clickAllAddToCartButtonsAndRemoveAll() throws InterruptedException {

        mainMenu.hoverOverProducts();

        //add cart 3 month supply, remove from cart
        BoneBuilderPack boneBuilderPage = mainMenu.clickBoneBuilderLink();
        Cart cartPage = boneBuilderPage.clickCartByIndexOnPage(0);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderThreeMonthPackText);

        //add cart 6 month supply, remove from cart
        mainMenu.hoverOverProducts();
        boneBuilderPage = mainMenu.clickBoneBuilderLink();
        cartPage = boneBuilderPage.clickCartByIndexOnPage(1);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderSixMonthPackText);

        //add cart 12 month supply, remove from cart
        mainMenu.hoverOverProducts();
        boneBuilderPage = mainMenu.clickBoneBuilderLink();
        cartPage = boneBuilderPage.clickCartByIndexOnPage(2);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderTwelveMonthPackText);

        for(int i=0;i<3;i++)
        {
            cartPage.removeItemsFromCart();
            driver.navigate().refresh();

        }

        validateTextOnPageExist(emptyCartText);
    }

    /**
     * This test verifies the 3 month supply add to cart button function on the Bone Builder Product Page.
     *
     * @Author Tammy Saucedo
     * @UserStory AlgaeCal QA Test
     */
    @Test
    public void clickThreeMonthAddToCartButton() throws InterruptedException {

        //add cart 3 month supply, remove from cart
        mainMenu.hoverOverProducts();
        BoneBuilderPack boneBuilderPage = mainMenu.clickBoneBuilderLink();
        Cart cartPage = boneBuilderPage.clickCartByIndexOnPage(0);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderThreeMonthPackText);
        cartPage.removeItemsFromCart();
        validateTextOnPageExist(emptyCartText);
    }

    /**
     * This test verifies the 6 month supply add to cart button function on the Bone Builder Product Page.
     *
     * @Author Tammy Saucedo
     * @UserStory AlgaeCal QA Test
     */
    @Test
    public void clickSixMonthAddToCartButton() throws InterruptedException {
        //add cart 6 month supply, remove from cart
        mainMenu.hoverOverProducts();
        BoneBuilderPack boneBuilderPage = mainMenu.clickBoneBuilderLink();
        Cart cartPage = boneBuilderPage.clickCartByIndexOnPage(1);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderSixMonthPackText);
        cartPage.removeItemsFromCart();
        validateTextOnPageExist(emptyCartText);
    }

    /**
     * This test verifies the 12 month supply add to cart button function on the Bone Builder Product Page.
     *
     * @Author Tammy Saucedo
     * @UserStory AlgaeCal QA Test
     */
    @Test
    public void clickTwelveMonthAddToCartButton() throws InterruptedException {
        //add cart 12 month supply, remove from cart
        mainMenu.hoverOverProducts();
        BoneBuilderPack boneBuilderPage = mainMenu.clickBoneBuilderLink();
        Cart cartPage = boneBuilderPage.clickCartByIndexOnPage(2);
        assertTrue(cartPage.isCheckoutButtonVisible());
        validateTextOnPageExist(boneBuilderTwelveMonthPackText);
        cartPage.removeItemsFromCart();
        validateTextOnPageExist(emptyCartText);
    }

    private void validateTextOnPageExist(String text) throws InterruptedException {
        sleep(3000);
        assertTrue("Error, Text does not exist on page. " + text,
                driver.getPageSource().contains(text));
    }
}


