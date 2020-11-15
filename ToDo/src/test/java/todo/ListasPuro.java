// 1 - Pacote = Conjunto de Classes
package todo;

// 2 - Bibliotecas = Métodos e Funções Prontas


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

// 3 - Classe = Atributos e métodos relacionados a uma mesma coisa
public class ListasPuro {
    // 3.1 - Atributos = Características
    String url; // guardará o endereço do site alvo
    WebDriver driver; // objetivo do Selenium WebDriver


    // 3.2 - Métodos ou Funcionalidades = O que ele sabe fazer
   @Before //Antes
    public void inicializar(){
       // Declarando o endereço do site alvo
        url = "https://todo.microsoft.com";

        // Informando o local
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
       //Instanciar o objeto Selenium WebDriver como navegador Chrome
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
       driver.manage().window().maximize(); //maximiza a janela do navegador

   }

    @After //Depois
    public void finalizar(){
        //driver.quit(); //destruir o objeto Selenium WebDriver

    }
    @Test //
    public void criarListaComTresItens() throws InterruptedException {
        driver.get(url);

        //Página de Login
        driver.findElement(By.id("mectrl_headerPicture")).click(); //clica no icone de Sign In/Login
        Thread.sleep(3000);
        driver.findElement(By.id("i0116")).sendKeys("samiatester@gmail.com"); //preenche o e-mail
        Thread.sleep(3000);
        driver.findElement(By.id("idSIButton9")).click(); // clica no botão próximo
        Thread.sleep(3000);
        driver.findElement(By.id("i0118")).sendKeys("nunc@123");
        Thread.sleep(3000);
        driver.findElement(By.id("idSIButton9")).click(); // clica no botão entrar
        Thread.sleep(3000);
        driver.findElement(By.id("idSIButton9")).click(); // clica no botão sim

        //Página de Tasks - Tarefas
        driver.findElement(By.id("baseAddInput-addList")).clear(); //apaga o texto no elemento

        // Cria a Lista Música
        //driver.findElement(By.id("baseAddInput-addList")).sendKeys("Musicas"); // cola a palavra "Musica"
        driver.findElement(By.id("baseAddInput-addList")).sendKeys(Keys.chord("Musicas")); //soletra a palavra "Musica"
        // Todo Implementar o print da tela
        driver.findElement(By.id("baseAddInput-addList")).sendKeys(Keys.ENTER); //pressiona a tecla Enter

        // Adiciona 3 músicas a lista
        driver.findElement(By.id("baseAddInput-addTask")).sendKeys("O Quereres" + Keys.ENTER);
        driver.findElement(By.id("baseAddInput-addTask")).sendKeys("Terra" + Keys.ENTER);
        driver.findElement(By.id("baseAddInput-addTask")).sendKeys("Me Gusta" + Keys.ENTER);

        //Alterar lista
        driver.findElement(By.cssSelector("i.ms-Icon--More")).click();
        driver.findElement(By.cssSelector("ul.ms-ContextualMenu-list.is-open.list-62 li:nth-child(1)")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input.chromeless.editing.tasksToolbar-input")).sendKeys("Minhas Musicas" + Keys.ENTER);

        //Excluir lista
        driver.findElement(By.cssSelector("i.ms-Icon--More")).click();
        driver.findElement(By.cssSelector("ul.ms-ContextualMenu-list.is-open.list-62 li:nth-child(5)")).click();
        driver.findElement(By.cssSelector("button.button.red")).click();
    }


}
