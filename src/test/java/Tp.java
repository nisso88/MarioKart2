import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.is;
import java.util.concurrent.TimeUnit;


public class Tp {
    WebDriver driver;

    @Before
    public void init()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr/");
    }

    @Test
    public void test()
    {
        HomePage homePage = new HomePage(driver);
        ConsolePage consolePage = homePage.getHeader().openVideoGames("Nintendo Switch");
        //ConsolePage gamesPage = homePage.header.openVideoGames("Nintendo Switch");
        //ConsolePage booksPage = homePage.header.openBooks("Tous les livres");
        //ConsolePage cartPage = homePage.header.openCart();
        GamesPage gamesPage = consolePage.openCategory("Jeux");
        ItemPage item = gamesPage.openItem(0); // premier resultat
        ItemAddedPage itemAddedPage = item.addToCart();
        CartPage cartPage = itemAddedPage.getHeader().openCart();
        cartPage.changeItemQuantity(0, 3); // changer la quantite de notre premier article a 3
        Assert.assertThat(cartPage.getTotalPrice(), is("EUR 149,97"));

    }

    @After
    public void close()
    {
        driver.quit();
    }
}
