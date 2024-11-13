import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.Set;

public class Sel1 {
    public static void main(String[] args) throws InterruptedException {
        Sel1 s = new Sel1();
        //launching browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //maximising browser
        driver.manage().window().maximize();
        driver.get("https://www.cleartrip.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"pb-1 px-1 flex flex-middle nmx-1\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"field-1 h-13 flex flex-middle p-relative pr-4 w-100p \"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"mr-4\"][1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"field-2 flex h-13 flex-middle p-relative pr-4 w-100p \"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Mumbai')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"focus:bc-secondary-500 t-all c-pointer flex flex-middle flex-between bg-neutral-100 c-neutral-900 p-4 py-3 px-4 h-10 fs-16 ba-solid bc-default c-neutral-900 fromDiv false\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='" + s.getCurrentDatePlus1()+"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class=\" c-neutral-400 flex flex-nowrap fs-16 fw-500\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='"+s.getCurrentDataPlus2()+"']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//h4[@class=\"sc-gEvEer cmEgze\"])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=\"p-relative\"])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'One way')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class=\"fw-600 fs-3\"]")).click();
        Thread.sleep(2000);

        //switching to new window
        String parentWindowHande=driver.getWindowHandle();
        System.out.println("parent Window Handle"+parentWindowHande);
        Set<String> windowHandle= driver.getWindowHandles();
        System.out.println("window Handle"+windowHandle);
        for(String h :windowHandle){
            if(h.equals(parentWindowHande)){
                System.out.println("h has parent window");
            }
            else {
                driver.switchTo().window(h);
                System.out.println("switched to new window"+h);
            }
        }

        //validating header in new window
        driver.findElement(By.xpath("//h2[@class=\"fs-7 px-4 c-neutral-900 fw-600\"]")).isDisplayed();
        boolean a =driver.findElement(By.xpath("//h2[@class=\"fs-7 px-4 c-neutral-900 fw-600\"]")).isDisplayed();
        if(a== true) {
            System.out.println("is displayed");
        }
        else{
            System.out.println("not displsyed");
        }
    }

    public String getCurrentDatePlus1() {
        LocalDate currentdata = LocalDate.now().plusDays(1);
        return currentdata.toString().substring(9);
    }

    public String getCurrentDataPlus2() {
        LocalDate currentdata = LocalDate.now().plusDays(2);
        return currentdata.toString().substring(9);

    }
}