package test.java.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;


public class Cart extends AbstractBasePage{

    public Cart(WebDriver webdriver) {
        super(webdriver);
    }

    public void removeItemFromCart() throws InterruptedException {
        sleep(2000);
        defaultWait.until(ExpectedConditions.visibilityOfElementLocated(By
                .cssSelector("a.remove.d-none.d-md-inline-block"))).click();
    }

    public boolean isCheckoutButtonVisible(){
       return defaultLongWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Checkout")))
               .isDisplayed();
    }
}
