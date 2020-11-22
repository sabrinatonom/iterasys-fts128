package login;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class loginValido {
    WebDriver driver;
    String url = "https://www.chinainbox.com.br/home";
    String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()) + "/";

    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));

    }

    @Before
    public void iniciar(){
        ChromeOptions chOptions = new ChromeOptions(); //instanciar o objeto de configuração do ChromeDriver
        chOptions.addArguments("--disable-notifications");

        System.setProperty("webdriver.chrome.driver","drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver(chOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }

    @After
    public void finalizar(){
        //driver.quit();
    }

    @Test
    public void efetuarLogin() throws InterruptedException, IOException {
        driver .get(url);
        tirarPrint("Passo 1 - Acessou o site");
        driver.findElement(By.id("my_text_desktop")).sendKeys("99700252");
        tirarPrint("Passo 2 - Informou o Cep");
        driver.findElement(By.id("btn-find-store")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("btn-enter-map")).click();
        tirarPrint("Passo 3 - Confirmou o endereco");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a.js-open-login")).click();
        tirarPrint("Passo 4 - Acessou a home");
        driver.findElement(By.id("new-user-email")).sendKeys("samiatester@gmail.com");
        driver.findElement(By.id("new-user-pass")).sendKeys("nunc@123" + Keys.ENTER);
        tirarPrint("Passo 5 - Informou login e senha");
        Thread.sleep(3000);
        assertEquals("Samia", driver.findElement(By.cssSelector(".icon-menu span:nth-child(3)")).getText());
        tirarPrint("Passo 6 - Confirmar o nome do usuario");

        // procurar produto
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).sendKeys("Yakissoba");
        tirarPrint("Passo 7 - Item Pesquisado");
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        tirarPrint("Passo 8 - Pagina com busca apresentada");
        driver.findElement(By.id("CC-product-grid-detail-9000000009-00")).click();
        assertTrue(driver.findElement(By.cssSelector(".-main-description h2")).getText().contains("Yakissoba"));
        tirarPrint("Passo 9 - Produto confirmado");
        //driver.findElement(By.cssSelector("button.btn.btn-green.btn-full")).click();
    }

}
