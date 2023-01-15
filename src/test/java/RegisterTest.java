import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {

    public void registerNewUser(){
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Danu");
        driver.findElement(By.id("lastname")).sendKeys("Leordean");
        driver.findElement(By.id("email_address")).sendKeys("danu_leordean@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        WebElement registrationCompleted = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        String actualText = registrationCompleted.getText();
        String expectedText = "Hello, Danu Leordean!";

        if (actualText.equals(expectedText)) {
            System.out.println("Inregistrare corecta!");
        } else {
            System.out.println("Nu s-a inregistrat");
        }
        driver.close();

    }
}
