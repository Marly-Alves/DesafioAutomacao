package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

    public class compraOnlineTest {
    private WebDriver navegador;

    //Fluxo Principal
    @Test
    public void testEscolherProduto() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);

        //Navegando para a página do E-commerce
        navegador.get("https://www.shopfacil.com.br");

        //Digitar no campo de pesquisa o texto "phone 11 pro"
        WebElement Pesquisa = navegador.findElement(By.xpath("//input[@placeholder=\"O que você está procurando?\"]"));
        Pesquisa.findElement(By.xpath("//input[@placeholder=\"O que você está procurando?\"]")).sendKeys("iphone 11 pro");

        //Clicar no botão "Buscar"
        WebElement Busca = navegador.findElement(By.xpath("//input[@value=\"Buscar\"]"));
        navegador.findElement(By.xpath("//input[@value=\"Buscar\"]")).click();

        //Validar que exibe o texto IPHONE 11 PRO
        WebElement Resultado = navegador.findElement(By.xpath("//div[text()=\"IPHONE 11 PRO\"]"));
        String textoNoElementoResultado = Resultado.getText();

        assertEquals("IPHONE 11 PRO", textoNoElementoResultado);
    }
    @Test
    public void testAdicionarAoCarrinho() {

        //Clicar no produto escolhido
        WebElement celEscolhido = navegador.findElement(By.xpath("//div[@data-sku=\"6701377\"]"));
        navegador.findElement(By.xpath("//div[@data-sku=\"6701377\"]")).click();

        //Clicar em Comprar
        WebElement Compra = navegador.findElement(By.xpath("//a[text()=\"Comprar\"]"));
        navegador.findElement(By.xpath("//a[text()=\"Comprar\"]")).click();

        //Validar que exibe o texto "MEU CARRINHO"
        WebElement Carrinho = navegador.findElement(By.xpath(" //a[@id=\"cart-to-orderform\"][text()=\"Fechar pedido\"]"));
        String textoNoElementoCarrinho = Carrinho.getText();

        assertEquals("Fechar pedido", textoNoElementoCarrinho);

        navegador.quit();
    }
    /*
    //Fluxo Alternativo
    @Test
    public void testFluxoAlternativo() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(17, TimeUnit.SECONDS);
        navegador.get("https://www.shopfacil.com.br");

        //Digitar no campo de pesquisa o texto "phone 11"
        WebElement Pesquisa = navegador.findElement(By.xpath("//input[@placeholder=\"O que você está procurando?\"]"));
        Pesquisa.findElement(By.xpath("//input[@placeholder=\"O que você está procurando?\"]")).sendKeys("iphone 11");

        //Clicar no produto escolhido
        WebElement celEscolhido2 = navegador.findElement(By.xpath("//li[@data-sku=\"6701377\"]"));
        navegador.findElement(By.xpath("//li[@data-sku=\"6701377\"]")).click();

        //Clicar em Comprar
        WebElement Compra2 = navegador.findElement(By.xpath("//a[text()=\"Comprar\"]"));
        navegador.findElement(By.xpath("//a[text()=\"Comprar\"]")).click();

        //Validar que exibe o texto "MEU CARRINHO"
        WebElement Carrinho = navegador.findElement(By.xpath(" //a[@id=\"cart-to-orderform\"][text()=\"Fechar pedido\"]"));
        String textoNoElementoCarrinho = Carrinho.getText();

        assertEquals("Fechar pedido", textoNoElementoCarrinho);
        navegador.quit();

     */
    }

