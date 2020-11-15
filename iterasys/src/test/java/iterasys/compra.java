package iterasys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class compra {
    String url;
    WebDriver driver;

    @Before
    public void siteiterasys(){
        url = "https://iterasys.com.br";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        //driver.quit();
    }

    @Test
    public void comprarnosite() throws InterruptedException{
        driver.get(url);

        driver.findElement(By.id("searchtext")).sendKeys("Testlink");
        Thread.sleep(3000);
        driver.findElement(By.id("btn_form_search")).click();
        driver.findElement(By.cssSelector("span.comprar")).click();
    }
}
