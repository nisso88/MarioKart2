import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AmazonPage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {

        return header;
    }
}
