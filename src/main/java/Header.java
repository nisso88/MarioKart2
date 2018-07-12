import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.linkText;

public class Header {

    private WebDriver driver;

    @FindBy(id = "nav-shop")
    WebElement categories;

    @FindBy(css= "span[data-nav-panelkey='VideogamesConsolesPanel']")
    WebElement catjeux;

    @FindBy(css= "span[data-nav-panelkey='BooksPanel']")
    WebElement catlivres;

    @FindBy (css = "#nav-flyout-shopAll>.nav-subcats")
    WebElement  sousCategorie;

    @FindBy(id ="nav-cart")
    WebElement panierButton;

    public Header(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ConsolePage openVideoGames(String textLink)
    {
        Actions actions = new Actions(driver);

        actions.moveToElement(categories);
        actions.build().perform();

        actions.moveToElement(catjeux);
        actions.build().perform();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(sousCategorie));

        driver.findElement(By.linkText(textLink)).click();
        return new ConsolePage(driver);
    }

    public ConsolePage openBooks(String textLink)
    {
        Actions actions = new Actions(driver);

        actions.moveToElement(categories);
        actions.build().perform();

        actions.moveToElement(catlivres);
        actions.build().perform();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(sousCategorie));

        driver.findElement(By.linkText(textLink)).click();
        return new ConsolePage(driver);

    }

    public  CartPage openCart ()
    {
        panierButton.click();
        return  new CartPage(driver);
    }
}


