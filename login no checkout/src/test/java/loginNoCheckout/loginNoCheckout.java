package loginNoCheckout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class loginNoCheckout {
    WebDriver driver;
    String url = "https://ccstore-test-zf4a.oracleoutsourcing.com/home";

    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }


    @After
    public void finalizar(){
        //driver.quit();
    }



    @Test
    public void loginNoCheckout() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.menu__show-categories")).click();
        driver.findElement(By.cssSelector("div.menu__categories--item--image")).click();
        driver.findElement(By.linkText("a./med_anticoncepcionais")).click();
    }


}
