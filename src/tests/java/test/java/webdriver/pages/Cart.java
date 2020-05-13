package test.java.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Cart extends AbstractBasePage{

    public Cart(WebDriver webdriver) {
        super(webdriver);
    }

    public void removeItemsFromCart(){
        defaultLongWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Remove"))).click();
    }

    public boolean isCheckoutButtonVisible(){
       return defaultLongWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Checkout"))).isDisplayed();
    }
}
