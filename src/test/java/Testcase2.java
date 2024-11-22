import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase2{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='pb-1 px-1 flex flex-middle nmx-1']")).click();
        WebElement about =  driver.findElement(By.xpath("//a[@class=\"sc-1019823e-0 jTiBfs fs-12 lh-16 fw-500 maxContent c-neutral-900\"]"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()",about);
        driver.findElement(By.xpath("//a[@class=\'sc-1019823e-0 jTiBfs fs-12 lh-16 fw-500 maxContent c-neutral-900\']")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}