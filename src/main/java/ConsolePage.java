import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolePage extends AmazonPage  {

    @FindBy(id = "anonCarousel1")
    public WebElement catsection;

    public ConsolePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public GamesPage openCategory(String textLink) {
        catsection.findElement(By.linkText(textLink)).click();
        return new GamesPage(driver);
    }

}
