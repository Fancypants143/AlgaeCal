package test.java.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.Thread.sleep;

public class BoneBuilderPack extends AbstractBasePage {
    /**
     * Constructor.
     *
     * @param webdriver Selenium class.
     */
    public BoneBuilderPack(WebDriver webdriver) {
        super(webdriver);
    }

    public Cart clickCartByIndexOnPage(int cartIndex) {
        WebElement table = driver.findElement(By.className("purchase-options-table"));
        List<WebElement> cartButtons = table.findElements(By.tagName("button"));
        cartButtons.get(cartIndex).click();
        defaultLongWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your Shopping Cart')]")));
        return new Cart(driver);
    }
}
