import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemPage extends  AmazonPage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public ItemPage(WebDriver driver) {
       super(driver);
    }

    public ItemAddedPage addToCart() {
        addToCartButton.click();
        return new ItemAddedPage(driver);
    }

}
