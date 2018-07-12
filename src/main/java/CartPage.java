import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CartPage extends  AmazonPage{

    @FindBy(id = "sc-subtotal-label-activecart")
    private WebElement subTotalLabel;

    @FindBy(id = "sc-subtotal-amount-activecart")
    private WebElement subTotalAmount;

    public CartPage(WebDriver driver) {
       super(driver);
    }

    public CartPage changeItemQuantity(int itemNumber, int quantity) {
        itemNumber++;

        // findElements

        String itemSelector = "div[data-item-count='" + Integer.toString(itemNumber) + "']";
        WebElement cartItem = driver.findElement(By.cssSelector(itemSelector));

        String oldText = subTotalLabel.getText();

        Select quantityDropdown = new Select(cartItem.findElement(By.name("quantity")));

        String selectedQuantity = quantityDropdown.getFirstSelectedOption().getText();

        if(Integer.parseInt(selectedQuantity.trim()) == quantity)
            return this;

        quantityDropdown.selectByValue(Integer.toString(quantity));

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(NoSuchElementException.class);

        wait.until(driver -> {
            String newText = subTotalLabel.getText();
            return !newText.equalsIgnoreCase(oldText);
        });

        return this;
    }

    public String getTotalPrice() {
        return subTotalAmount.getText();
    }

    public Header getHeader()
    {
        return header;
    }
}
