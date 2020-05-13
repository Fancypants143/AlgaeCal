package test.java.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainMenu extends AbstractBasePage {

    public MainMenu(WebDriver webdriver) {
        super(webdriver);
    }

    //hover over methods
    public void hoverOverProducts(){
        WebElement productsLink = driver.findElement(By.linkText("PRODUCTS"));
        //actions to hover over products to display dropdown options
        Actions action = new Actions(driver);
        action.moveToElement(productsLink).perform();
    }

    public void hoverOverOsteoporosis(){
        WebElement productsLink = driver.findElement(By.linkText("OSTEOPOROSIS"));
        //actions to hover over products to display dropdown options
        Actions action = new Actions(driver);
        action.moveToElement(productsLink).perform();
    }

    public void hoverOverMenuText(String text){
        WebElement productsLink = driver.findElement(By.linkText(text));
        //actions to hover over products to display dropdown options
        Actions action = new Actions(driver);
        action.moveToElement(productsLink).perform();
    }

    //click methods

    public BoneBuilderPack clickBoneBuilderLink(){
        driver.findElement(By.linkText("BONE BUILDER PACK")).click();
        defaultLongWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("purchase-options-table")));
        return new BoneBuilderPack(driver);
    }
}
