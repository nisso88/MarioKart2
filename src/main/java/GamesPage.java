import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamesPage extends AmazonPage {

    @FindBy(id = "mainResults")
    private WebElement allResults;

    public GamesPage(WebDriver driver) {
        super(driver);
    }

    public ItemPage openItem(int index) {
        String id = "result_" + Integer.toString(index);
        WebElement item = allResults.findElement(By.id(id));
        WebElement mainLink = item.findElement(By.className("a-link-normal"));
        mainLink.click();
        return new ItemPage(driver);
    }
}
