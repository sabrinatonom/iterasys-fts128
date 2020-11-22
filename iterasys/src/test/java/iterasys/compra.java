//1 - Pacote
package iterasys;

//2 - Bibliotecas

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//3 - Classe

public class compra {
    //3.1 - Atributos
    String url;
    WebDriver driver;
    String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime()) + "/";

    //3.2 - Métodos ou funções

    //métidos ou funções de apoio (util / commons)
    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
    }



    @Before
    public void siteiterasys(){
        url = "https://iterasys.com.br";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void comprarnosite() throws InterruptedException, IOException {
        driver.get(url);
        tirarPrint("Passo 1 - Acessou a Home");
        driver.findElement(By.id("searchtext")).sendKeys("Testlink");
        Thread.sleep(3000);
        driver.findElement(By.id("btn_form_search")).click();
        tirarPrint("Passo 2 - Exibiu os cursos da pesquisa");
        driver.findElement(By.cssSelector("span.comprar")).click();
        tirarPrint("Passo 3 - Exibiu informacoes do curso");

        //Validar nome do curso
        assertEquals("TestLink", driver.findElement(By.cssSelector("span.item-title")).getText());

        //Validar preço
        assertEquals("R$ 79,99", driver.findElement(By.cssSelector("span.new-price")).getText());

        //Validar subtotal
        assertEquals("SUBTOTAL R$ 79,99", driver.findElement(By.cssSelector("div.subtotal")).getText());

        //Validar o valor da parcele
        assertTrue(driver.findElement(By.cssSelector("div.ou-parcele")).getText().contains("ou em 12 x de R$ 8,03"));
    }
}
