//1 - Pacote
package pesquisa;

//2 - Biblioteca
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

//3 - classe
@RunWith(Parameterized.class) // Esta classe é parametrizada = lê uma massa de teste
public class pesquisa {
    //3.1 - Atributos
    WebDriver driver;
    static String url;
    String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()) + "/";

    //3.2 - métodos ou funções
    //métodos ou funções de apoio (util / commons)
    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + browser + ".png"));

    }

    // função para ler um massa de teste

    //1 - Atributos / Campos da Massa de Teste
    private String id;
    private String pesquisa;
    private String browser;

    //2 -Construtor (De-Para entre os campos na massa e os atribudos)
    public pesquisa(String id, String pesquisa, String browser) {
        this.id = id;
        this.pesquisa = pesquisa;
        this.browser = browser;
    }
    //3- Collection intermediária entre o Constructor e a Colletion que vai fazer a leitura
    // Ela serve para apontar a pasta e o nome do arquivo a ser lido
    @Parameterized.Parameters
    public static Collection<String[]> LerArquivo() throws IOException{
        return LerCSV("db/pesquisa.csv");
    }

    //4- Collection que lê um arquivo no formato CSV
    public static Collection<String[]> LerCSV(String nomeCSV) throws IOException{
        //Lê o arquivo no disco e disponibiliza na memória RAM
        BufferedReader arquivo = new BufferedReader(new FileReader(nomeCSV));
        String linha; //cria uma variavel linha
        List<String[]> dados = new ArrayList<>(); //cria uma lista para receber o resultado

        while ((linha = arquivo.readLine()) != null) {
            String[] campos = linha.split(";");
            dados.add(campos);
        }
        arquivo.close();
        return dados;
    }


    @BeforeClass
    public static void antesDeTudo() {
        url = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/87/chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "drivers/edge/msedgedriver.exe");
        System.setProperty("webdriver.gecko.driver", "drivers/firefox/geckodriver.exe");
    }

    @Before
    public void iniciar(){
        switch (browser){
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void pesquisar() throws IOException, InterruptedException {
        driver .get(url);
        tirarPrint("Passo 1 - Abrir o Google no ");
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).click();
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(pesquisa);
        tirarPrint("Passo 2 - Pesquisa realizada usando o navegador ");
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.hdtb-mitem.hdtb-msel.hdtb-imb")).click();
        tirarPrint("Passo 3 - Resultado da pesquisa no navegador ");
    }






}
