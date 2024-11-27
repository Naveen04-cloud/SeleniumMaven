import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class TestCase3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.worldometers.info/gdp/gdp-by-country/");
        Thread.sleep(2000);
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr[@role=\"row\"]"));
        List<String> expectedValues=new ArrayList<>();
        expectedValues.add("#");
        expectedValues.add("country");
        expectedValues.add("Gdp \n(nominal 2022)");
        expectedValues.add("GDP \n (abbrev.)");
        expectedValues.add("GDP \n growth");
        expectedValues.add("Population \n(2022)");
        expectedValues.add("GDP \n per capita");
        System.out.println("expectedValues"+expectedValues);

        List<String> actualvalues=new ArrayList<>();
        for(WebElement s : elementsList){
            actualvalues.add(s.getText().trim());
        }
        System.out.println("actualValues"+actualvalues);
        if(expectedValues.equals(actualvalues)){
            System.out.println("pass");
        }
        else {
            System.out.println("fail");

        }

    }
}
