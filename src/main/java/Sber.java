import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;



import static org.junit.Assert.assertTrue;

public class Sber {
    WebDriver driver;
    String baseUrl;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseUrl = "https://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);


    }

    @Test
    public void testSberbank () {
        driver.findElement(By.xpath("//li[@class='alt-menu-collapser alt-menu-collapser_branch alt-menu-collapser_opened alt-menu-mid__item']")).click();
        driver.findElement(By.xpath("//li[@class='alt-menu-collapser alt-menu-collapser_branch alt-menu-collapser_closed alt-menu-collapser_delayed-hover alt-menu-mid__item']//div[@class='alt-menu-collapser__area alt-menu-collapser__area_cols_3']//div[@class='alt-menu-collapser__hidder']//div[@class='alt-menu-collapser__column']//div[@class='alt-menu-list__item alt-menu-list__item_leaf alt-menu-list__item_closed alt-menu-list__item_level_1']//a[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1']")).click();
        assertTrue(driver.findElement(By.xpath("//li[@class='alt-menu-collapser alt-menu-collapser_branch alt-menu-collapser_closed alt-menu-collapser_delayed-hover alt-menu-mid__item']//div[@class='alt-menu-collapser__area alt-menu-collapser__area_cols_3']//div[@class='alt-menu-collapser__hidder']//div[@class='alt-menu-collapser__column']//div[@class='alt-menu-list__item alt-menu-list__item_leaf alt-menu-list__item_closed alt-menu-list__item_level_1']//a[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1']")).getText().contains("Страхование путешественников"));
        driver.findElement(By.xpath("//img[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")).click();
        driver.findElement(By.xpath("//div[@class='b-form-box-title ng-binding'][contains(text(),'Минимальная')]")).click();
        driver.findElement(By.xpath("//span[@ng-click='save()']")).click();
        fillField(By.name("insured0_surname"),"Петров");
        fillField(By.name("insured0_name"),"Иван");

        driver.switchTo().frame(
                driver.findElement(By.xpath("//input[@id='dp1518347944900']")));
        setDatepicker(driver, "#datepicker", "01/09/1987");

        fillField(By.name("surname"),"Петров");
        fillField(By.name("name"),"Иван");
        fillField(By.name("middlename"),"Александрович");

        driver.switchTo().frame(
                driver.findElement(By.xpath("//input[@id='dp1518347944898']")));
        setDatepicker(driver, "#datepicker", "01/09/1987");

        WebElement checkBox1;
        WebElement checkBox3;

        checkBox1 = driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[2]/div/fieldset[8]/span[1]"));
        checkBox3 = driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[2]/div/fieldset[8]/span[2]"));

        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

//checkBox3 is selected by default
        if(checkBox3.isSelected()){
            checkBox3.click();
        }






        }

    public void fillField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);



    }
    public void setDatepicker(WebDriver driver, String Selector, String date) {
        new WebDriverWait(driver, 30000).until(
                (WebDriver d) -> d.findElement(By.xpath("//input[@id='dp1518347944900']")).isDisplayed());
        JavascriptExecutor.class.cast(driver).executeScript(
                String.format("$('%s').datepicker('setDate', '%s')", Selector, date));

}
    public void checkBox () {

    }

    @After
    public void afterTest () {
        driver.quit();

    }

}
