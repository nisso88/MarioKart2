import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemAddedPage extends AmazonPage {


    public ItemAddedPage(WebDriver driver) {
       super(driver);
    }

    public Header getHeader() {
        return header;
    }
}
